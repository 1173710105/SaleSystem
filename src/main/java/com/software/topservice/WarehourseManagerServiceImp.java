//package com.software.topservice;
//
//import static org.hamcrest.CoreMatchers.nullValue;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.hamcrest.core.Is;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.mysql.cj.x.protobuf.MysqlxCrud.Update;
//import com.software.domain.Item;
//import com.software.domain.SaleorderCommon;
//import com.software.domain.SaleorderItem;
//import com.software.domain.Staff;
//import com.software.domain.StoreManager;
//import com.software.domain.SubBranchDetailMap;
//import com.software.domain.Warehourse;
//import com.software.domain.WarehourseDetail;
//import com.software.service.ItemService;
//import com.software.service.SaleorderCommonService;
//import com.software.service.SaleorderItemService;
//import com.software.service.StaffService;
//import com.software.service.StoreManagerService;
//import com.software.service.SubBranchDetailMapService;
//import com.software.service.WarehourseDetailService;
//import com.software.service.WarehourseService;
//
//@Service
//public class WarehourseManagerServiceImp implements WarehourseManagerService 
//{
//
//	
//	@Autowired
//	private StaffService staffService;
//	
//	@Autowired
//	private WarehourseDetailService warehourseDetailService;
//	
//	@Autowired
//	private ItemService itemService;
//	
//	@Autowired
//	private SaleorderCommonService saleorderCommonService;
//	
//	@Autowired
//	private SaleorderItemService saleorderItemService;
//	
//	@Autowired
//	private SubBranchDetailMapService subBranchDetailMapService;
//	
//	@Autowired
//	private StoreManagerService storeManagerService;
//	
//	@Autowired
//	private WarehourseService warehourseService;
//	
//	public String addWarehourse(SubBranchDetailMap record)
//	{
//		//添加仓库
//		Warehourse hourse = new Warehourse();
//		hourse.setName(record.getWarehoursename());
//		hourse.setLocation(record.getWarehourselocation());
//		hourse.setLabel("valid");
//		
//		Warehourse examplehourse = new Warehourse();
//		examplehourse.setName(record.getWarehoursename());
//		if (!isExist(hourse)) 
//		{
//			//添加仓库失败，已经存在同名的仓库
//			return "error";
//		}
//		//插入仓库
//		warehourseService.insertSelective(hourse);
//		//获取插入后的仓库信息
//		hourse = warehourseService.select(hourse).get(0);
//		
//		//获取仓库编号
//		String hourseid = String.format("%04d", hourse.getId()); 
//		
//		//添加子仓库表
//		String staffName = "sub_staff_"+hourseid;
//		String warehourseDetailName = "sub_warehourse_detail_"+hourseid;
//		String warehourseItemName = "sub_warehourse_item_"+hourseid;
//		String saleorderItemName = "sub_saleorder_item_"+hourseid;
//		String saleorderConmonName = "sub_saleorder_common_"+hourseid;
//		
//		Staff staff = new Staff();
//		staff.setTablename(staffName);
//		staffService.createNewTable(staff);
//		
//		WarehourseDetail warehourseDetail = new WarehourseDetail();
//		warehourseDetail.setTablename(warehourseDetailName);
//		warehourseDetailService.createNewTable(warehourseDetail);
//		
//		Item item = new Item();
//		item.setTablename(warehourseItemName);
//		itemService.createNewTable(item);
//		
//		SaleorderItem saleorderItem = new SaleorderItem();
//		saleorderItem.setTablename(saleorderItemName);
//		saleorderItemService.createNewTable(saleorderItem);
//		
//		SaleorderCommon saleorderCommon = new SaleorderCommon();
//		saleorderCommon.setTablename(saleorderConmonName);
//		saleorderCommonService.createNewTable(saleorderCommon);
//		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		String date = df.format(new Date());// new Date()为获取当前系统时间
//		
//		//记录映射关系
//		SubBranchDetailMap map = new SubBranchDetailMap();
//		map.setWarehourseid(hourse.getId());
//		map.setWarehoursename(hourse.getName());
//		map.setWarehourselocation(hourse.getLocation());
//		map.setPrincipalid(record.getPrincipalid());
//		map.setPrincipalname(record.getPrincipalname());
//		map.setItemtable(warehourseItemName);
//		map.setWarehoursedetailtable(warehourseDetailName);
//		map.setStafftable(staffName);
//		map.setSaleorderitemtable(saleorderItemName);
//		map.setSaleordercommontable(saleorderConmonName);
//		map.setTime(date);
//		map.setLabel("valid");
//		
//		subBranchDetailMapService.insert(map);
//		
//		return "success";
//	}
//		
//	public String deleteWarehourse(SubBranchDetailMap record)
//	{
//		// 传入 warehourse 所有 私有域
//		Warehourse hourse = new Warehourse();
//		hourse.setId(record.getWarehourseid());
//		hourse.setLabel("invalid");
//		warehourseService.updateByPrimaryKeySelective(hourse);
//		
//		record.setLabel("invalid");
//		subBranchDetailMapService.updateByPrimaryKeySelective(record);
//		return "success";
//	}
//	
//	private boolean isExist(Warehourse hourse)
//	{
//		if (warehourseService.select(hourse).size()==0) 
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
//	}
//	
//	@Override
//	public List<SubBranchDetailMap> select(SubBranchDetailMap record)
//	{
//		return subBranchDetailMapService.select(record);
//	}
//	
//	@Override
//	public void updateByPrimaryKey(SubBranchDetailMap record)
//	{
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		String date = df.format(new Date());// new Date()为获取当前系统时间
//		// 更新warehourse
//		Warehourse hourse = new Warehourse();
//		hourse.setId(record.getWarehourseid());
//		hourse.setName(record.getWarehoursename());
//		hourse.setLocation(record.getWarehourselocation());
//		hourse.setTime(date);
//		warehourseService.updateByPrimaryKeySelective(hourse);
//		
//		//更新subBranchDetailMap
//		record.setTime(date);
//		subBranchDetailMapService.updateByPrimaryKeySelective(record);
//	}
//	
//	public SubBranchDetailMap selectByPrimaryKey(SubBranchDetailMap record)
//	{
//		return subBranchDetailMapService.selectByPrimaryKey(record);
//	}
//
//	@Override
//	public List<String> hourseMenu() 
//	{
//		Warehourse hourse = new Warehourse();
//		hourse.setLabel("valid");
//		List<Warehourse> result = warehourseService.select(hourse);
//		List<String> warehousreNameList = new ArrayList<String>(); 
//		warehousreNameList.add("总仓库");
//		for (Warehourse warehourse : result) 
//		{
//			warehousreNameList.add(warehourse.getName());	
//		}
//		return warehousreNameList;
//	}
//
//}
