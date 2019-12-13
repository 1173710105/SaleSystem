package com.software.topservice;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.Item;
import com.software.domain.ItemToPrice;
import com.software.service.ItemService;
import com.software.service.ItemToPriceService;
import com.software.trans.ReceiveCargo;

@Service
public class ItemManagerSerivceImp implements ItemManagerSerivce 
{
	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemToPriceService priceService;

	@Override
	public ReceiveCargo selectByPrimaryKey(ReceiveCargo record) 
	{
		Item exampleItem = record.toItem();
		ItemToPrice examplePrice = record.toPrice();
		Item item = itemService.selectByPrimaryKey(exampleItem);
		ItemToPrice price = priceService.selectByPrimaryKey(examplePrice);
		ReceiveCargo cargo = new ReceiveCargo();
		cargo.initByItem(item);
		cargo.initByPrice(price);
		return cargo;
	}
	
	@Override
	public void insertSelective(ReceiveCargo record) 
	{
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		String date = df.format(new Date());// new Date()为获取当前系统时间
//		
		Item exampleItem = record.toItem();
		
		ItemToPrice examplePrice = record.toPrice();
		
		itemService.insertSelective(exampleItem);
		priceService.insertSelective(examplePrice);
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
		priceService.updateByPrimaryKey(examplePrice);
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
}
