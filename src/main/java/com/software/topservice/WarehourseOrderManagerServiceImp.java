package com.software.topservice;

import static org.mockito.Mockito.ignoreStubs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.ItemToPrice;
import com.software.domain.WarehourseDetail;
import com.software.domain.WarehourseOrderCommon;
import com.software.domain.WarehourseOrderItem;
import com.software.service.ItemToPriceService;
import com.software.service.WarehourseDetailService;
import com.software.service.WarehourseOrderCommonService;
import com.software.service.WarehourseOrderItemService;
import com.software.trans.ReceiveWarehourseOrder;
import com.software.trans.SendWarehourseOrder;


@Service
public class WarehourseOrderManagerServiceImp implements WarehourseOrderManagerService 
{

	@Autowired
	private WarehourseOrderCommonService commonService;
	
	@Autowired
	private WarehourseOrderItemService itemService;
	
	@Autowired
	private WarehourseDetailService detailService;
	
	@Autowired
	private ItemToPriceService priceService;
	
	@Override
	public List<SendWarehourseOrder> select(ReceiveWarehourseOrder order) 
	{	
		List<SendWarehourseOrder> result = new ArrayList<SendWarehourseOrder>();
		WarehourseOrderCommon examplecommon = order.toWarehourseOrderCommon();

		// 选取符合条件的订单
		List<WarehourseOrderCommon> commonList = commonService.select(examplecommon);
		
		// 获取每一条订单的基本信息
		SendWarehourseOrder orderTemp;
		WarehourseOrderItem itemTemp = new WarehourseOrderItem();
		for (WarehourseOrderCommon warehourseOrderCommon : commonList) 
		{
			orderTemp = new SendWarehourseOrder(); // 新建
			orderTemp.initByCommon(warehourseOrderCommon);
			
			//获取订单对应的物品
			itemTemp.setId(warehourseOrderCommon.getId()+"");
			orderTemp.setItems(itemService.select(itemTemp));
			result.add(orderTemp);
		}
		return result;
	}

	@Override
	public void insert(List<ReceiveWarehourseOrder> orderList) 
	{
		if (orderList.size()==0) 
		{
			System.out.println("没有商品，insert个屁");
			return;
		}
		// 插入的时候不知道订单ID
		ReceiveWarehourseOrder example = orderList.get(0);
		WarehourseOrderCommon exampleCommon = example.toWarehourseOrderCommon();
		example.setId(null);
		example.setChecktime(getRandom()+"");
		commonService.insertSelective(exampleCommon);
		
		// 查出插入后的ID
		WarehourseOrderCommon resultCommon = commonService.select(exampleCommon).get(0);
		
		// 将具体的商品信息插入到detail表里面
		WarehourseOrderItem itemTemp;
		for (ReceiveWarehourseOrder receiveWarehourseOrder : orderList) 
		{
			itemTemp = receiveWarehourseOrder.toWarehourseOrderItem();
			// 设置关联关系
			itemTemp.setId(resultCommon.getId()+"");
			itemService.insertSelective(itemTemp);
		}
	}

	@Override
	public void update(List<ReceiveWarehourseOrder> orderList) 
	{
		// 更新共同信息
		ReceiveWarehourseOrder example = orderList.get(0);
		WarehourseOrderCommon exampleCommon = example.toWarehourseOrderCommon();
		commonService.updateByPrimaryKeySelective(exampleCommon);
		
		// 删除订单中的商品
		WarehourseOrderItem exampleItem = new WarehourseOrderItem();
		example.setId(exampleCommon.getId()+"");
		itemService.deleteByID(exampleItem);
		
		WarehourseOrderItem itemTemp;
		// 重新添加
		for (ReceiveWarehourseOrder receiveWarehourseOrder : orderList) 
		{
			itemTemp = receiveWarehourseOrder.toWarehourseOrderItem();
			itemTemp.setViceid(null);
			itemService.insertSelective(itemTemp);
		}
	}

	@Override
	public void delete(ReceiveWarehourseOrder order) 
	{
		WarehourseOrderCommon exampleCommon = order.toWarehourseOrderCommon();
		commonService.deleteByPrimaryKey(exampleCommon);
		
		WarehourseOrderItem exampleItem = order.toWarehourseOrderItem();
		itemService.deleteByID(exampleItem);
		
	}

	@Override
	public String checkOrder(ReceiveWarehourseOrder order) 
	{
		// common 最后才更新
		WarehourseOrderCommon exampleCommon = order.toWarehourseOrderCommon();
		
		// 获取订单的商品
		WarehourseOrderItem exampleItem = order.toWarehourseOrderItem();
		List<WarehourseOrderItem> itemList = itemService.select(exampleItem);
		
		// 用于初始化商品数量信息表，获取源和目的表名
		String sourceTableName = getWarehourseDetailTable(exampleCommon.getSourceid());
		String targetTableName = getWarehourseDetailTable(exampleCommon.getTargetid());
		
		// 用于初始化商品价格信息表
		String sourcePriceTablename = getItemToPriceTable(exampleCommon.getSourceid());
		String targetPriceTablename = getItemToPriceTable(exampleCommon.getTargetid());
		
		// 用于保存商品价格信息
		ItemToPrice examplePrice = new ItemToPrice();
		ItemToPrice sourcePrice = new ItemToPrice();
		ItemToPrice targetPrice = new ItemToPrice();
		List<ItemToPrice> priceList = new ArrayList<>();
		
		// 用于保存变化后商品数量信息
		List<WarehourseDetail> sourceItemList = new ArrayList<>();
		List<WarehourseDetail> targetItemList = new ArrayList<>();
		
		WarehourseDetail exampleDetail = new WarehourseDetail();
		WarehourseDetail sourceDetail;
		WarehourseDetail targetDetail;
		
		// 遍历订单中所有货品
		// 子->总、、子-总 作为一个类  源要减，目的加     
		// 进货商->总设为一个类        目的加   
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间
		
		
		for (WarehourseOrderItem warehourseOrderItem : itemList) 
		{
			if (sourceTableName!=null) 
			{
				exampleDetail.setTablename(sourceTableName);
				exampleDetail.setItemid(warehourseOrderItem.getItemid());
				
				sourceDetail = detailService.selectByPrimaryKey(exampleDetail);
				if (sourceDetail==null) 
				{
					// 源仓库中没有该商品， 需要先添加   如果出现这一步，则会有逻辑错误
					System.out.println("逻辑错误");
					return "false";
				}
				if (sourceDetail.getItemnum()<warehourseOrderItem.getItemnum()) 
				{
					// 商品数量不够，审核失败
					return "false";
				}
				// 源仓库，减
				sourceDetail.setTablename(sourceTableName);
				sourceDetail.setItemnum(sourceDetail.getItemnum()-warehourseOrderItem.getItemnum());
				sourceDetail.setTime(date);  // 更新时间
				sourceItemList.add(sourceDetail);
			}
			// 目的仓库加
			exampleDetail.setTablename(targetTableName);
			exampleDetail.setItemid(warehourseOrderItem.getItemid());
			targetDetail = detailService.selectByPrimaryKey(exampleDetail);
			if (targetDetail==null) 
			{
				// 目标仓库中，没有该商品，需要初始化
				targetDetail = new WarehourseDetail();
				targetDetail.setTablename(targetTableName);
				targetDetail.setItemid(exampleDetail.getItemid());
				targetDetail.setItemnum(warehourseOrderItem.getItemnum());
				targetDetail.setTime(date);
			}
			else 
			{
				targetDetail.setTablename(targetTableName);
				targetDetail.setItemnum(targetDetail.getItemnum()+warehourseOrderItem.getItemnum());
				targetDetail.setTime(date);
			}
			targetItemList.add(targetDetail);
			
			
			examplePrice.setTablename(targetPriceTablename);
			examplePrice.setId(warehourseOrderItem.getItemid());
			targetPrice = priceService.selectByPrimaryKey(examplePrice);
			if (targetPrice==null) 
			{
				// 如果目的仓库里面没有商品到价格的信息，则需要初始化
				if (sourcePriceTablename==null) 
				{
					// 货源地是进货商，则商品价格信息 中 进货价 与订单中的商品价格相同
					targetPrice = new ItemToPrice();
					targetPrice.setTablename(targetPriceTablename);
					targetPrice.setId(warehourseOrderItem.getItemid());
					targetPrice.setName(warehourseOrderItem.getItemname());
					targetPrice.setPurchaseprice(warehourseOrderItem.getPerprice());
					targetPrice.setTime(date);
					priceList.add(targetPrice);
				}
				else
				{
					// 货源地是仓库，则商品价格信息与源仓库相同
					sourcePrice = new ItemToPrice();
					sourcePrice.setTablename(targetPriceTablename);
					priceList.add(sourcePrice);
				}
			}
		}
		//更新到仓库商品数量信息表里面
		for (WarehourseDetail warehourseDetail : sourceItemList) 
		{
			detailService.updateByPrimaryKeySelective(warehourseDetail);
		}
		for (WarehourseDetail warehourseDetail : targetItemList) 
		{
			detailService.updateByPrimaryKeySelective(warehourseDetail);
		}
		// 更新到仓库商品价格信息表里面
		for (ItemToPrice price : priceList) 
		{
			priceService.insertSelective(price);
		}
		return "true";
	}
	
	private String getWarehourseDetailTable(Integer hourseid)
	{
		if (hourseid == -1) 
		{
			return "base_warehourse_detail";
		}
		else if(hourseid == -2)
		{
			return null;
		}
		else
		{
			return "sub_warehourse_detail_"+String.format("%04d", hourseid);
		}
		
	}
	
	private String getItemToPriceTable(Integer hourseid)
	{
		if (hourseid == -1) 
		{
			return "base_warehourse_itemtoprice";
		}
		else if (hourseid == -2) 
		{
			return null;
		}
		else
		{
			return "sub_warehourse_itemtoprice_"+String.format("%04d", hourseid);
		}
	}
	private int getRandom()
	{
		Random rand = new Random();
		return rand.nextInt(100000000);
	}

	@Override
	public void updateStatus(ReceiveWarehourseOrder order) 
	{
		WarehourseOrderCommon exampleCommon = order.toWarehourseOrderCommon();
		commonService.updateByPrimaryKeySelective(exampleCommon);
	}
}
