package com.software.controller;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.software.domain.Item;
import com.software.domain.SaleorderCommon;
import com.software.domain.SaleorderItem;
import com.software.domain.Staff;
import com.software.domain.StoreManager;
import com.software.domain.SubBranchDetailMap;
import com.software.domain.Warehourse;
import com.software.domain.WarehourseDetail;
import com.software.service.ItemService;
import com.software.service.SaleorderCommonService;
import com.software.service.SaleorderItemService;
import com.software.service.StaffService;
import com.software.service.StoreManagerService;
import com.software.service.SubBranchDetailMapService;
import com.software.service.WarehourseDetailService;
import com.software.service.WarehourseService;

@Controller
@RequestMapping("")
public class WarehourseController 
{
	@Autowired
	private WarehourseService warehourseService;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private WarehourseDetailService warehourseDetailService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private SaleorderCommonService saleorderCommonService;
	
	@Autowired
	private SaleorderItemService saleorderItemService;
	
	@Autowired
	private SubBranchDetailMapService subBranchDetailMapService;
	
	@Autowired
	private StoreManagerService storeManagerService;
	
	public String addWarehourse()
	{
		//参数 principalid principalname location warehoursename
		StoreManager manager = isExistManager("Managername");
		if (manager==null) 
		{
			return "查无此人";
		}
		
		Warehourse exampleHourse = new Warehourse();
		exampleHourse.setLocation("location");
		exampleHourse.setName("name");
		exampleHourse.setPrincipalid(manager.getId());
		exampleHourse.setLabel("valid");
		warehourseService.insert(exampleHourse);
		
		List<Warehourse> hourses = warehourseService.select(exampleHourse);
		if (hourses.size()==0) 
		{
			//插入失败
			return null;
		}
		
		Warehourse hourse = hourses.get(0);
		String hourseid = String.format("%04d", hourse.getId()); 
		
		//添加子仓库表
		String staffName = "sub_staff_"+hourseid;
		String warehourseDetailName = "sub_warehourse_detail_"+hourseid;
		String warehourseItemName = "sub_warehourse_item_"+hourseid;
		String saleorderItemName = "sub_saleorder_item_"+hourseid;
		String saleorderConmonName = "sub_saleorder_common_"+hourseid;
		
		Staff staff = new Staff();
		staff.setTablename(staffName);
		staffService.createNewTable(staff);
		
		WarehourseDetail warehourseDetail = new WarehourseDetail();
		warehourseDetail.setTablename(warehourseDetailName);
		warehourseDetailService.createNewTable(warehourseDetail);
		
		Item item = new Item();
		item.setTablename(warehourseItemName);
		itemService.createNewTable(item);
		
		SaleorderItem saleorderItem = new SaleorderItem();
		saleorderItem.setTablename(saleorderItemName);
		saleorderItemService.createTable(saleorderItem);
		
		SaleorderCommon saleorderCommon = new SaleorderCommon();
		saleorderCommon.setTablename(saleorderConmonName);
		saleorderCommonService.createTable(saleorderCommon);
		
		//记录映射关系
		SubBranchDetailMap map = new SubBranchDetailMap();
		map.setWarehourseid(hourse.getId());
		map.setPrincipalid(manager.getId());
		map.setItemtable(warehourseItemName);
		map.setWarehoursedetailtable(warehourseDetailName);
		map.setStafftable(staffName);
		map.setSaleorderitemtable(saleorderItemName);
		map.setSaleordercommontable(saleorderConmonName);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间
		map.setTime(date);
		map.setLabel("valid");
		
		subBranchDetailMapService.insertSelective(map);
		
		return null;
	}
	
	
	private StoreManager isExistManager(String name)
	{
		StoreManager manager = new StoreManager();
		manager.setName("name");
		manager.setLabel("valid");
		List<StoreManager> result = storeManagerService.select(manager);
		if (result.size()==0) 
		{
			return null;
		}
		else
		{
			return result.get(0);
		}
	}
	
	public String deleteWarehourse()
	{
		// 传入 warehourse 所有 私有域
		Integer hourseid = 1;
		String principalid = "";
		Warehourse hourse = new Warehourse();
		hourse.setId(hourseid);
		hourse.setLabel("invalid");
		warehourseService.updateByPrimaryKeySelective(hourse);
		
		SubBranchDetailMap map = new SubBranchDetailMap();
		map.setWarehourseid(hourseid);
		map.setPrincipalid(principalid);
		map.setLabel("invalid");
		subBranchDetailMapService.updateByPrimaryKeySelective(map);
		
		return null;
	}
	public String deleteCompletely()
	{
//		Integer hourseid = 1;
//		String principalid = "";
//		Warehourse hourse = new Warehourse();
//		hourse.setId(hourseid);
//		hourse.setLabel("invalid");
//		warehourseService.updateByPrimaryKeySelective(hourse);
//		
//		SubBranchDetailMap map = new SubBranchDetailMap();
//		map.setWarehourseid(hourseid);
//		map.setPrincipalid(principalid);
//		map.setLabel("invalid");
//		subBranchDetailMapService.updateByPrimaryKeySelective(map);
		return null;
	}
}
