package com.software.topservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.dao.WarehourseMapper;
import com.software.domain.ItemToPrice;
import com.software.domain.SaleorderCommon;
import com.software.domain.SaleorderItem;
import com.software.domain.Staff;
import com.software.domain.SubBranchDetailMap;
import com.software.domain.Warehourse;
import com.software.domain.WarehourseDetail;
import com.software.service.ItemToPriceService;
import com.software.service.SaleorderCommonService;
import com.software.service.SaleorderItemService;
import com.software.service.StaffService;
import com.software.service.SubBranchDetailMapService;
import com.software.service.WarehourseDetailService;
import com.software.service.WarehourseService;

@Service
public class WarehourseManagerServiceImp implements WarehourseManagerService {

	@Autowired
	private WarehourseService hourseService;
	
	@Autowired 
	private SubBranchDetailMapService mapService;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private SaleorderCommonService salecommonSevice;
	
	@Autowired
	private SaleorderItemService saleitemService;
	
	@Autowired
	private ItemToPriceService priceService;
	
	@Autowired
	private WarehourseDetailService detailService;
	
	@Override
	public void deleteByPrimaryKey(Warehourse record) 
	{
		Integer hourseid = record.getId();
		// warehourse delete
		hourseService.deleteByPrimaryKey(record);
		
		// map delete
		SubBranchDetailMap exampleBranch = new SubBranchDetailMap();
		exampleBranch.setWarehourseid(hourseid);
		mapService.delete(exampleBranch);
		
		//  删除5个表
		// 	sub_staff_hourseid
		// 	sub_saleorder_common_hourseid
		//	sub_saleorder_item_hourseid
		//  sub_warehourse_itemToPrice_hourseid
		//	sub_warehourse_detail_hourseid
		
		String staffTableName = "sub_staff_hourseid_"+String.format("%04d", hourseid);
		String saleorderCommonTableName = "sub_saleorder_common_"+String.format("%04d", hourseid);
		String saleorderItemTableName = "sub_saleorder_item_"+String.format("%04d", hourseid);
		String warehourseItemToPriceTableName = "sub_warehourse_itemToPrice_"+String.format("%04d", hourseid);
		String warehourseDetailTableName = "sub_warehourse_detail_"+String.format("%04d", hourseid);
		
		Staff exampleStaff = new Staff();
		exampleStaff.setTablename(staffTableName);
		staffService.dropTable(exampleStaff);
		
		SaleorderCommon exampleCommon = new SaleorderCommon();
		exampleCommon.setTablename(saleorderCommonTableName);
		salecommonSevice.dropTable(exampleCommon);
		
		SaleorderItem exampleItem = new SaleorderItem();
		exampleItem.setTablename(saleorderItemTableName);
		saleitemService.dropTable(exampleItem);
		
		ItemToPrice examplePrice = new ItemToPrice();
		examplePrice.setTablename(warehourseItemToPriceTableName);
		priceService.dropTable(examplePrice);
		
		WarehourseDetail exampleDetail = new WarehourseDetail();
		exampleDetail.setTablename(warehourseDetailTableName);
		detailService.dropTable(exampleDetail);
		
	}

	@Override
	public void insertSelective(Warehourse record) 
	{		
		// 插入
		hourseService.insertSelective(record);
		// 查取，获取id
		Warehourse result = hourseService.select(record).get(0);
		Integer hourseid = result.getId();
		// 加入五个表
		String staffTableName = "sub_staff_hourseid_"+String.format("%04d", hourseid);
		String saleorderCommonTableName = "sub_saleorder_common_"+String.format("%04d", hourseid);
		String saleorderItemTableName = "sub_saleorder_item_"+String.format("%04d", hourseid);
		String warehourseItemToPriceTableName = "sub_warehourse_itemToPrice_"+String.format("%04d", hourseid);
		String warehourseDetailTableName = "sub_warehourse_detail_"+String.format("%04d", hourseid);
		
		Staff exampleStaff = new Staff();
		exampleStaff.setTablename(staffTableName);
		staffService.createNewTable(exampleStaff);
		
		SaleorderCommon exampleCommon = new SaleorderCommon();
		exampleCommon.setTablename(saleorderCommonTableName);
		salecommonSevice.createNewTable(exampleCommon);
		
		SaleorderItem exampleItem = new SaleorderItem();
		exampleItem.setTablename(saleorderItemTableName);
		saleitemService.createNewTable(exampleItem);
		
		ItemToPrice examplePrice = new ItemToPrice();
		examplePrice.setTablename(warehourseItemToPriceTableName);
		priceService.createNewTable(examplePrice);
		
		WarehourseDetail exampleDetail = new WarehourseDetail();
		exampleDetail.setTablename(warehourseDetailTableName);
		detailService.createNewTable(exampleDetail);
		
		// 建立映射关系
		SubBranchDetailMap exampleMap = new SubBranchDetailMap();
		exampleMap.setWarehourseid(record.getId());
		exampleMap.setWarehoursename(record.getName());
		exampleMap.setWarehourselocation(record.getLocation());
		exampleMap.setPrincipalid("-1000");
		
		exampleMap.setItemtable(warehourseItemToPriceTableName);
		exampleMap.setSaleorderitemtable(saleorderItemTableName);
		exampleMap.setSaleordercommontable(saleorderCommonTableName);
		exampleMap.setStafftable(staffTableName);
		exampleMap.setWarehoursedetailtable(warehourseDetailTableName);
		exampleMap.setTime(record.getTime());
		exampleMap.setLabel(record.getLabel());
		
		mapService.insertSelective(exampleMap);
	}

	@Override
	public Warehourse selectByPrimaryKey(Warehourse record) 
	{
		return hourseService.selectByPrimaryKey(record);
	}

	@Override
	public List<Warehourse> select(Warehourse record) 
	{
		return hourseService.select(record);
	}

	@Override
	public void updateByPrimaryKeySelective(Warehourse record) 
	{
		hourseService.updateByPrimaryKeySelective(record);
		SubBranchDetailMap exampleMap = new SubBranchDetailMap();
		exampleMap.setWarehourseid(record.getId());
		exampleMap.setLabel(record.getLabel());
		mapService.updateByHourseID(exampleMap);
	}
	
}
