package com.software.dao;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.List;

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
	private ItemMapper iMapper;
	
	@Test
	public void testCreateNewTable()
	{
//		String tableName = "item_01";
//		iMapper.createNewTable(tableName);
	}
	
	@Test
	public void testInsert()
	{
//		Item newItem = new Item();
//		newItem.setTableName("item_01");
//		newItem.setName("sufei");
//		newItem.setPicture("1");
//		newItem.setPurchaseprice((float) 1.0);
//		newItem.setRetailprice((float) 2.0);
//		newItem.setSpecification("i am here");
//		newItem.setType("qita");
//		newItem.setWholesaleprice((float) 20.0);
//		iMapper.insert(newItem);
	}
	
	@Test
	public void testQuery1()
	{
//		Item newItem = new Item();
//		newItem.setTableName("item_01");
//		newItem.setName("sufei");
//		List<Item> Item1 = iMapper.select(newItem);
//		for (Item item : Item1) 
//		{
//			System.out.println(item);
//		}
	}
	
	@Test
	public void testQuery2()
	{
//		Item Item1 = iMapper.selectByPrimaryKey(1);
//		System.out.println(Item1);
	}
}
