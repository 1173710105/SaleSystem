package com.software.topservice;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.Item;
import com.software.domain.ItemToPrice;
import com.software.domain.Warehourse;
import com.software.domain.WarehourseDetail;
import com.software.service.ItemService;
import com.software.service.ItemToPriceService;
import com.software.service.WarehourseDetailService;
import com.software.trans.ReceiveCargo;

@Service
public class ItemManagerSerivceImp implements ItemManagerSerivce 
{
	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemToPriceService priceService;

	@Autowired
	private WarehourseDetailService detailService;
	
	@Override
	public ReceiveCargo selectByPrimaryKey(ReceiveCargo record) 
	{
		Item exampleItem = record.toItem();
		ItemToPrice examplePrice = record.toPrice();
		System.out.println(exampleItem);
		Item item = itemService.selectByPrimaryKey(exampleItem);
		if (item!=null) 
		{
			ReceiveCargo cargo = new ReceiveCargo();
			ItemToPrice price = priceService.selectByPrimaryKey(examplePrice);
			cargo.initByItem(item);
			cargo.initByPrice(price);
			System.out.println(cargo);
			return cargo;
		}
		else
		{
			return null;
		}

	}
	
	@Override
	public void insertSelective(ReceiveCargo record) 
	{
		Item exampleItem = record.toItem();
		exampleItem.setPicture(getRandom()+"");
		itemService.insertSelective(exampleItem);
		
		Item resultItem = itemService.select(exampleItem).get(0);
		
		WarehourseDetail detail = new WarehourseDetail();
		detail.setTablename(record.getTablename());
		detail.setItemnum(0);
		detail.setTime(record.getTime());
		detail.fillTableName();
		detail.setItemid(resultItem.getId());
		
		ItemToPrice examplePrice = record.toPrice();
		examplePrice.setId(resultItem.getId());
		
		priceService.insertSelective(examplePrice);
		detailService.insertSelective(detail);
	}

	@Override
	public List<ReceiveCargo> select(ReceiveCargo record) 
	{
		Item exampleItem = record.toItem();
		ItemToPrice examplePrice = record.toPrice();
		List<Item> itemList = itemService.select(exampleItem);
		Map<Integer, ReceiveCargo> map = new HashMap<Integer, ReceiveCargo>();
		ReceiveCargo cargo;
		for (Item item : itemList) 
		{
			cargo = new ReceiveCargo();
			cargo.initByItem(item);
			map.put(item.getId(), cargo);
		}
		
		List<ItemToPrice> prices = priceService.select(examplePrice);
		for (ItemToPrice itemToPrice : prices) 
		{
			itemToPrice.setTablename(examplePrice.getTablename());
			map.get(itemToPrice.getId()).initByPrice(itemToPrice);
		}
		
		List<ReceiveCargo> result = new ArrayList<>();
		for (Integer index : map.keySet()) {
			result.add(map.get(index));
		}
		return result;
	}

	@Override
	public void updateByPrimaryKeySelective(ReceiveCargo record) 
	{
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		String date = df.format(new Date());// new Date()为获取当前系统时间
//		
		Item exampleItem = record.toItem();
		
		ItemToPrice examplePrice = record.toPrice();
		
		itemService.updateByPrimaryKeySelective(exampleItem);
		priceService.updateByPrimaryKeySelective(examplePrice);
	}

	@Override
	public Map<Integer, String> typeMenu() 
	{
		Item item = new Item();
		item.setLabel("valid");
		List<Item> itemList = itemService.select(item);
		Map<Integer, String> result = new HashMap<>();
		for (int i = 0; i < itemList.size(); i++) 
		{
			result.put(i, itemList.get(i).getType());
		}
		return result;
	}
	
	private int getRandom() 
	{
		Random random = new Random();
		return random.nextInt(100000000);
	}
}
