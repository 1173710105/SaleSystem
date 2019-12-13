//package com.software.topservice;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.software.domain.Item;
//import com.software.service.ItemService;
//
//@Service
//public class ItemManagerSerivceImp implements ItemManagerSerivce 
//{
//	@Autowired
//	private ItemService service;
//
//	@Override
//	public void deleteByPrimaryKey(Item record) 
//	{
//		service.deleteByPrimaryKey(record);
//
//	}
//
//	@Override
//	public void insertSelective(Item record) 
//	{
//		service.insertSelective(record);
//
//	}
//
//	@Override
//	public List<Item> select(Item record) 
//	{
//		return service.select(record);
//	}
//
//	@Override
//	public void updateByPrimaryKeySelective(Item record) 
//	{
//		service.updateByPrimaryKeySelective(record);
//	}
//
//	@Override
//	public List<String> typeMenu(Item record) 
//	{
//		List<Item> list = service.select(record);
//		List<String> types = new ArrayList<String>();
//		for (Item item : list) 
//		{
//			types.add(item.getType());
//		}
//		return types;
//	}
//
//}
