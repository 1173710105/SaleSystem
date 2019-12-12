package com.software.topservice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WarehourseManagerServiceTest 
{
	@Autowired
	private WarehourseManagerService service;
	
	@Test
	public void testAddWarehourse() 
	{
//		Warehourse warehourse = new Warehourse();
//		warehourse.setName("东北地区总仓库");
//		warehourse.setLocation("北京");
//		warehourse.setPrincipalid("200010002");
//		service.addWarehourse(warehourse);
	}

}
