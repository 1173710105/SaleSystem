package com.software.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.software.domain.Item;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemMapperTest 
{

	@Autowired
	private ItemMapper mapper;
	
	@Test
	public void test() 
	{
//		try {
//			Item item = new Item();
//			item.setTablename("base_warehourse_item");
//			mapper.select(item);
//			System.out.println(111);
//		} 
//		catch (Exception e) 
//		{
//			System.out.println(222);
//		}
	}
	
	@Test
	public void testCreateNewTable()
	{
//		mapper.createNewTable("sub_warehourse_item_0001");
//		mapper.createNewTable("sub_warehourse_item_0002");
	}

}
