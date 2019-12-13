package com.software.topservice;

import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import com.software.trans.ReceiveOrder;
import com.software.trans.SendOrder;

public interface SaleOrderManagerService 
{
	public List<SendOrder> select(ReceiveOrder order);
	
	public void insert(List<ReceiveOrder> orderList);
	
	public void update(List<ReceiveOrder> orderList);
	
	public void delete(ReceiveOrder order);
	
	/**
	 * 设计到detail表的操作，可能数量不够
	 * @param order
	 */
	public void checkOrder(ReceiveOrder order);
	
	public void payOrder(ReceiveOrder order);
	
	/**
	 * 设计到detail表的操作
	 * @param order
	 */
	public void returnOrder(ReceiveOrder order);
}
