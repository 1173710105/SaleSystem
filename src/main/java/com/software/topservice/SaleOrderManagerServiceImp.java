package com.software.topservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.ItemToPrice;
import com.software.domain.SaleorderCommon;
import com.software.domain.SaleorderItem;
import com.software.domain.WarehourseDetail;
import com.software.service.ItemService;
import com.software.service.ItemToPriceService;
import com.software.service.SaleorderCommonService;
import com.software.service.SaleorderItemService;
import com.software.service.WarehourseDetailService;
import com.software.trans.ReceiveOrder;
import com.software.trans.SendOrder;

@Service
public class SaleOrderManagerServiceImp implements SaleOrderManagerService {

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
			exampleCommon.setId(saleorderCommon.getId());
			orderTemp.setItems(itemService.select(exampleItem));
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
		SaleorderCommon exampleCommon = example.toCommon();
		exampleCommon.setId(null);
		exampleCommon.setException(String.valueOf(getRandom()));
		commonService.insertSelective(exampleCommon);
		
		// 插入商品, 最后查出价格之后还需要填上，毛利润
		SaleorderCommon resultCommon = commonService.select(exampleCommon).get(0);
		SaleorderItem tempItem;
		// 查利润
		ItemToPrice tempPrice = new ItemToPrice();
		tempPrice.setTablename(example.getItemtopricetable());
		float margin = 0;
		for (ReceiveOrder receiveOrder : orderList) 
		{
			tempItem = receiveOrder.toItem();
			tempItem.setViceid(null);
			tempItem.setId(resultCommon.getId());
			itemService.insertSelective(tempItem);
			// 算利润
			tempPrice.setId(tempItem.getId());
			margin += calMargin(priceService.selectByPrimaryKey(tempPrice), example.getType());
		}
		//更新利润
		resultCommon.setMargin(margin);
		commonService.updateByPrimaryKeySelective(resultCommon);
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
			tempPrice.setId(tempItem.getId());
			margin += calMargin(priceService.selectByPrimaryKey(tempPrice), example.getType());
		}
		
		// 重新更新common
		exampleCommon.setMargin(margin);
		commonService.updateByPrimaryKeySelective(exampleCommon);
	}

	@Override
	public void delete(ReceiveOrder order) 
	{
		SaleorderCommon exampleCommon = order.toCommon();
		commonService.deleteByPrimaryKey(exampleCommon);
		
		SaleorderItem exampleItem = order.toItem();
		itemService.deleteByID(exampleItem);
		
	}

	@Override
	public String checkOrder(ReceiveOrder order) 
	{
		SaleorderItem exampleItem = order.toItem();
		List<SaleorderItem> itemList = itemService.select(exampleItem);
		
		// 更改库存, 查看库存商品个数
		List<WarehourseDetail> detailList = new ArrayList<>();
		WarehourseDetail tempDetail = new WarehourseDetail();
		tempDetail.setTablename(order.getWarehoursedetailtablename());
		for (SaleorderItem saleorderItem : itemList) 
		{
			// 查看当前商品仓库里面一共有多少个
			tempDetail.setItemid(saleorderItem.getItemid());
			tempDetail = detailService.selectByPrimaryKey(tempDetail);
			tempDetail.setTablename(order.getWarehoursedetailtablename());
			if (tempDetail.getItemnum()<saleorderItem.getItemnum()) 
			{
				// 商品数量不足
				return "false";
			}
			//更新商品数量
			tempDetail.setItemnum(tempDetail.getItemnum()-saleorderItem.getItemnum());
			detailList.add(tempDetail);
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
		tempDetail.setTablename(order.getWarehoursedetailtablename());
		for (SaleorderItem saleorderItem : itemList) 
		{
			// 查看当前商品仓库里面一共有多少个
			tempDetail.setItemid(saleorderItem.getItemid());
			tempDetail = detailService.selectByPrimaryKey(tempDetail);
			tempDetail.setTablename(order.getWarehoursedetailtablename());
			//更新商品数量
			tempDetail.setItemnum(tempDetail.getItemnum()+saleorderItem.getItemnum());
			detailList.add(tempDetail);
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
		
		ItemToPrice result = priceService.selectByPrimaryKey(price);
		if (priceType.equals("批发"))
		{
			return result.getWholesaleprice() - result.getPurchaseprice();
		}
		else if (priceType.equals("零售")) 
		{
			return result.getRetailprice() - result.getPurchaseprice();
		}
		else 
		{
			return (float) -1.0;
		}
	}
}
