//package com.software.topservice;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.software.domain.Item;
//import com.software.domain.SaleorderCommon;
//import com.software.domain.SaleorderItem;
//import com.software.domain.Staff;
//import com.software.service.SaleorderCommonService;
//import com.software.service.SaleorderItemService;
//
//@Service
//public class StaffWorkManagerServiceImp implements StaffWorkManagerService {
//
//	@Autowired
//	private SaleorderCommonService commonService;
//	
//	@Autowired
//	private SaleorderItemService itemService;
//	
//	@Override
//	public List<SaleorderCommon> reviewHistoryCommons(Staff staff) 
//	{
//		SaleorderCommon exampleCommon = new SaleorderCommon();
//		String saleorderCommonTablename = "sub_saleorder_common_"+String.format("%04d", staff.getHourseid());
//		exampleCommon.setTablename(saleorderCommonTablename);
//		exampleCommon.setPrincipalid(staff.getId());
//		exampleCommon.setWarehourseid(staff.getHourseid());
//		return commonService.select(exampleCommon);
//	}
//
//	@Override
//	public List<SaleorderItem> reviewHistoryItems(SaleorderCommon common) 
//	{
//		SaleorderItem exampleItem = new SaleorderItem();
//		String saleorderItemTablename = "sub_saleorder_item_"+String.format("%04d", common.getWarehourseid());
//		exampleItem.setTablename(saleorderItemTablename);
//		exampleItem.setItemid(common.getId());
//		return itemService.select(exampleItem);
//	}
//
//	@Override
//	public SaleorderCommon createSaleOrder(Staff staff, String clientID, String clientName) 
//	{
//		SaleorderCommon common = new SaleorderCommon();
//		String saleorderCommonTablename = "sub_saleorder_common_"+String.format("%04d", staff.getHourseid());
//		common.setTablename(saleorderCommonTablename);
//		common.setWarehourseid(staff.getHourseid());
//		common.setWarehoursename(staff.getHoursename());
//		common.setClientid(Integer.valueOf(clientID));
//		common.setClientname(clientName);
//		common.setPrincipalid(staff.getId());
//		common.setPrincipalname(staff.getName());
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		String date = df.format(new Date());// new Date()为获取当前系统时间
//		common.setCreatetime(date);
//		common.setStatus(1);
//		common.setType("零售");
//		commonService.insertSelective(common);
//		return common;
//	}
//
//	@Override
//	public void addItem(SaleorderItem item) 
//	{
//		itemService.insertSelective(item);
//	}
//
//	@Override
//	public void settleAccounts(SaleorderCommon common) 
//	{
////		SaleorderCommon exampleCommon = new SaleorderCommon();
////		exampleCommon.setId(common.getId());
////		
////		SaleorderCommon detailCommon = commonService.selectByPrimaryKey(exampleCommon);
////		detailCommon.setChange(common.getChange());
////		
////		detailCommon.setGather(common.getChange());
////		
////		detailCommon.setcommon.getChange());
////		
////		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
////		String date = df.format(new Date()); // new Date()为获取当前系统时间
////		
//		
//	}
//
//	@Override
//	public SaleorderCommon calSumPrice(SaleorderCommon common) 
//	{
//		SaleorderCommon exampleCommon = new SaleorderCommon();
//		exampleCommon.setTablename(common.getTablename());
//		exampleCommon.setId(common.getId());
//		
//		SaleorderCommon detailCommon = commonService.selectByPrimaryKey(exampleCommon);
//		
//		// 读取货品，计算价格
//		SaleorderItem exampleItem = new SaleorderItem();
//		String saleorderItemTablename = "sub_saleorder_item_"+String.format("%04d", common.getId());
//		exampleItem.setTablename(saleorderItemTablename);
//		exampleCommon.setId(common.getId());
//		List<SaleorderItem> itemlist = itemService.select(exampleItem);
//		
//		float sumPrice = 0;
//		for (SaleorderItem saleorderItem : itemlist) 
//		{
//			sumPrice += saleorderItem.getPerprice()*saleorderItem.getItemnum();
//		}
//		detailCommon.setSumprice(new Float(sumPrice));
//		return detailCommon;
//	}
//	
//	
//	
//	
//
//}
