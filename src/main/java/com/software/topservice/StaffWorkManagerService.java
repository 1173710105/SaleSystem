//package com.software.topservice;
//
//import java.util.List;
//
//import com.software.domain.Item;
//import com.software.domain.SaleorderCommon;
//import com.software.domain.SaleorderItem;
//import com.software.domain.Staff;
//
//public interface StaffWorkManagerService 
//{
//	/**
//	 * hourseid， staffid
//	 * @param staff
//	 * @return
//	 */
//	public List<SaleorderCommon> reviewHistoryCommons(Staff staff);
//	
//	/**
//	 * tablename， saleorderid
//	 * @param common
//	 * @return
//	 */
//	public List<SaleorderItem> reviewHistoryItems(SaleorderCommon common);
//	
//	/**
//	 * 
//	 * @param staff  完全信息
//	 * @param clientID  客户ID  散户 默认-1
//	 * @param clientName  客户名字  散户默认 “散户”
//	 */
//	public SaleorderCommon createSaleOrder(Staff staff, String clientID, String clientName);
//	
//	/**
//	 * 表名，item 的完全信息 ，包括其对应的订单ID
//	 * @param item 
//	 */
//	public void addItem(SaleorderItem item);
//	
//	/**
//	 * 给一 SaleorderId， 以及表名
//	 * @param common
//	 */
//	public SaleorderCommon calSumPrice(SaleorderCommon common);
//	
//	/**
//	 * 结算
//	 * 实收，总价，找零， 销售单 id common 的表名
//	 */
//	public void settleAccounts(SaleorderCommon common);
//	
//	
//}
