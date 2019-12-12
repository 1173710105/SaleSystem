//package com.software.topservice;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.software.domain.ItemDetail;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class WarehourseDetailManagerServiceTest 
//{
//	@Autowired
//	private WarehourseDetailManagerService service;
//	
//	@Test
//	public void test() 
//	{
//		ItemDetail example = new ItemDetail();
//		example.setComeFromName("总仓库");
//		List<ItemDetail> list = service.select(example);
//		for (ItemDetail itemDetail : list) {
//			System.out.println(itemDetail);
//		}
//	}
//
//}
