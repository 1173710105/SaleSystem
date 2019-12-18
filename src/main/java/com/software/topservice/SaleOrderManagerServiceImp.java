package com.software.topservice;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.ItemToPrice;
import com.software.domain.SaleorderCommon;
import com.software.domain.SaleorderItem;
import com.software.domain.WarehourseDetail;
import com.software.service.ItemToPriceService;
import com.software.service.SaleorderCommonService;
import com.software.service.SaleorderItemService;
import com.software.service.WarehourseDetailService;
import com.software.trans.ReceiveOrder;
import com.software.trans.SendOrder;

@Service
public class SaleOrderManagerServiceImp implements SaleOrderManagerService 
{
	@Autowired 
	private SaleorderCommonService commonService;
	@Autowired
	private SaleorderItemService itemService;
	@Autowired
	private ItemToPriceService priceService;
	@Autowired
	private WarehourseDetailService detailService;
	
	@Override
	public List<SendOrder> select(ReceiveOrder order) 
	{
		order.fillTablename();
		List<SendOrder> result = new ArrayList<SendOrder>();
		SaleorderCommon exampleCommon = order.toCommon();
		//查取符合条件的订单
		List<SaleorderCommon> commonList = commonService.select(exampleCommon);
		SendOrder orderTemp;
		SaleorderItem exampleItem = new SaleorderItem(); 
		for (SaleorderCommon saleorderCommon : commonList) 
		{
			orderTemp = new SendOrder();
			orderTemp.initByCommon(saleorderCommon);
			// 获取该订单对应的物品
			exampleItem.setTablename(order.getItemtablename());
			exampleItem.setId(saleorderCommon.getId());
			orderTemp.setItems(itemService.select(exampleItem));
			result.add(orderTemp);
		}
		return result;
	}

	@Override
	public void insert(List<ReceiveOrder> orderList) 
	{
		if (orderList.size()==0) 
		{
			System.out.println("没有商品，insert个屁");
			return;
		}
		// 插入的时候是没有ID的，插入，查出来， 这样可以后去ID
		ReceiveOrder example =  orderList.get(0);
		example.fillTablename();
		
		SaleorderCommon exampleCommon = example.toCommon();
		exampleCommon.setId(null);
		exampleCommon.setException(String.valueOf(getRandom()));
		commonService.insertSelective(exampleCommon);
		
		// 插入商品, 最后查出价格之后还需要填上，毛利润
		SaleorderCommon resultCommon = commonService.select(exampleCommon).get(0);
		resultCommon.setTablename(example.getCommontablename());
		
		// 查利润
		ItemToPrice tempPrice = new ItemToPrice();
		tempPrice.setTablename(example.getItemtopricetable());
		
		// 记录需要插入的商品
		SaleorderItem tempItem;
		List<SaleorderItem> itemList = new ArrayList<>();
		
		// 记录数量变化
		List<WarehourseDetail> detailList = new ArrayList<WarehourseDetail>();
		WarehourseDetail tempDetail;
		
		float margin = 0;
		for (ReceiveOrder receiveOrder : orderList) 
		{
			receiveOrder.fillTablename();
			tempItem = receiveOrder.toItem();
			tempItem.setViceid(null);
			tempItem.setId(resultCommon.getId());
			itemList.add(tempItem);
			
			//itemService.insertSelective(tempItem);
			
			// 如果是零售，一步跳到5，需要检测数目够不够
			if (example.getStatus().equals("5")) 
			{
				tempDetail = isEnough(tempItem, receiveOrder.getWarehoursedetailtablename());
				if (tempDetail==null) 
				{
					System.out.println("数量不知，无法零售");
					commonService.deleteByPrimaryKey(resultCommon);  // 删除订单
					return;
				}
				detailList.add(tempDetail);
			}
			// 算利润
			tempPrice.setId(tempItem.getItemid());
			margin += calMargin(priceService.selectByPrimaryKey(tempPrice), example.getType())*tempItem.getItemnum();
			
		}
		
		//更新利润
		resultCommon.setMargin(margin);
		commonService.updateByPrimaryKeySelective(resultCommon);
		
		//detailList 更新仓库信息
		for (WarehourseDetail detail : detailList) 
		{
			detailService.updateByPrimaryKeySelective(detail);
		}
		//itemList 插入订单物品信息
		for (SaleorderItem item : itemList) 
		{
			itemService.updateByPrimaryKeySelective(item);
		}
	}

	@Override
	public void update(List<ReceiveOrder> orderList) 
	{
		if (orderList.size()==0) 
		{
			System.out.println("没有商品，搞个屁");
			return;
		}
		ReceiveOrder example =  orderList.get(0);
		SaleorderCommon exampleCommon = example.toCommon();
		
		// 删除原订单所有商品
		SaleorderItem tempItem = new SaleorderItem();
		tempItem.setId(exampleCommon.getId());
		itemService.deleteByID(tempItem);
		
		// 更新利润
		ItemToPrice tempPrice = new ItemToPrice();
		tempPrice.setTablename(example.getItemtopricetable());
		float margin = 0;
		for (ReceiveOrder receiveOrder : orderList) 
		{
			// 重新插入商品
			tempItem = receiveOrder.toItem();
			tempItem.setViceid(null);
			tempItem.setId(exampleCommon.getId());
			itemService.insertSelective(tempItem);
			// 算利润
			tempPrice.setId(tempItem.getItemid());
			margin += calMargin(priceService.selectByPrimaryKey(tempPrice), example.getType());
		}
		
		// 重新更新common
		exampleCommon.setMargin(margin);
		commonService.updateByPrimaryKeySelective(exampleCommon);
	}

	@Override
	public void delete(ReceiveOrder order) 
	{
		order.fillTablename();
		SaleorderCommon exampleCommon = order.toCommon();
		commonService.deleteByPrimaryKey(exampleCommon);
		
		SaleorderItem exampleItem = order.toItem();
		itemService.deleteByID(exampleItem);
	}

	@Override
	public String checkOrder(ReceiveOrder order) 
	{
		order.fillTablename();
		SaleorderItem exampleItem = order.toItem();
		List<SaleorderItem> itemList = itemService.select(exampleItem);
		
		// 更改库存, 查看库存商品个数
		List<WarehourseDetail> detailList = new ArrayList<>();
		WarehourseDetail tempDetail = new WarehourseDetail();
		WarehourseDetail resultDetail;
		
		for (SaleorderItem saleorderItem : itemList) 
		{
			// 查看当前商品仓库里面一共有多少个
			resultDetail = isEnough(saleorderItem, order.getWarehoursedetailtablename());
			if (resultDetail==null) 
			{
				// 商品数量不足
				return "false";
			}
			detailList.add(resultDetail);
			
//			tempDetail.setTablename(order.getWarehoursedetailtablename());
//			tempDetail.setItemid(saleorderItem.getItemid());
//			resultDetail = detailService.selectByPrimaryKey(tempDetail);
//			
//			if (resultDetail==null) 
//			{
//				System.out.println("逻辑错误，订单里的商品，仓库没有");
//				return "false";
//			}
//			if (resultDetail.getItemnum()<saleorderItem.getItemnum()) 
//			{
//				
//			}
//			//更新商品数量
//			resultDetail.setTablename(order.getWarehoursedetailtablename());
//			resultDetail.setItemnum(resultDetail.getItemnum()-saleorderItem.getItemnum());
//			detailList.add(resultDetail);
		}
		
		// 更改共同信息
		SaleorderCommon exampleCommon = order.toCommon();
		commonService.updateByPrimaryKeySelective(exampleCommon);
		
		// 更新库存
		for (WarehourseDetail warehourseDetail : detailList) 
		{
			detailService.updateByPrimaryKeySelective(warehourseDetail);
		}
		return "true";
	}

	@Override
	public void payOrder(ReceiveOrder order) 
	{
		order.fillTablename();
		SaleorderCommon exampleCommon = order.toCommon();
		commonService.updateByPrimaryKeySelective(exampleCommon);
	}

	@Override
	public void returnOrder(ReceiveOrder order) 
	{
		SaleorderItem exampleItem = order.toItem();
		List<SaleorderItem> itemList = itemService.select(exampleItem);
		
		// 更改库存, 查看库存商品个数
		List<WarehourseDetail> detailList = new ArrayList<>();
		WarehourseDetail tempDetail = new WarehourseDetail();
		WarehourseDetail resultDetail;
		for (SaleorderItem saleorderItem : itemList) 
		{
			// 查看当前商品仓库里面一共有多少个
			tempDetail.setTablename(order.getWarehoursedetailtablename());
			tempDetail.setItemid(saleorderItem.getItemid());
			resultDetail = detailService.selectByPrimaryKey(tempDetail);
			if (resultDetail==null) 
			{
				System.out.println("逻辑错误，退回了一个仓库里面没有的商品");
				return;
			}
			resultDetail.setTablename(order.getWarehoursedetailtablename());
			//更新商品数量
			resultDetail.setItemnum(resultDetail.getItemnum()+saleorderItem.getItemnum());
			detailList.add(resultDetail);
		}
		
		// 更改共同信息
		SaleorderCommon exampleCommon = order.toCommon();
		commonService.updateByPrimaryKeySelective(exampleCommon);
		
		// 更新库存
		for (WarehourseDetail warehourseDetail : detailList) 
		{
			detailService.updateByPrimaryKeySelective(warehourseDetail);
		}
	}
	
	private int getRandom()
	{
		Random rand = new Random();
		return rand.nextInt(100000000);
	}

	private float calMargin(ItemToPrice price, String priceType)
	{
		System.out.println("type"+priceType);
		if (priceType.equals("2"))
		{
			return price.getWholesaleprice() - price.getPurchaseprice();
		}
		else if (priceType.equals("1")) 
		{
			return price.getRetailprice() - price.getPurchaseprice();
		}
		else 
		{
			return (float) -1.0;
		}
	}
	
	private WarehourseDetail isEnough(SaleorderItem item, String detailTablename)
	{
		WarehourseDetail exampleDetail = new WarehourseDetail();
		exampleDetail.setTablename(detailTablename);
		exampleDetail.setItemid(item.getItemid());
		WarehourseDetail resultDetail = detailService.selectByPrimaryKey(exampleDetail);
		if (resultDetail.getItemnum()<item.getItemnum()) 
		{
			return null;
		}
		else
		{
			resultDetail.setTablename(detailTablename);
			resultDetail.setItemnum(resultDetail.getItemnum()-item.getItemnum());
			return resultDetail;
		}
	}
}
