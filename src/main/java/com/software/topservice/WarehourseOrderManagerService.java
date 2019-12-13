package com.software.topservice;

import java.util.List;

import com.software.trans.ReceiveOrder;
import com.software.trans.SendOrder;

public interface WarehourseOrderManagerService 
{
public List<SendOrder> select(ReceiveOrder order);
	
	public void insert(List<ReceiveOrder> orderList);
	
	public void update(List<ReceiveOrder> orderList);
	
	public void delete(ReceiveOrder order);
	
	/**
	 * 设计到detail表的操作，可能数量不够
	 * @param order
	 */
	public String checkOrder(ReceiveOrder order);
	
	public void payOrder(ReceiveOrder order);
	
	/**
	 * 设计到detail表的操作
	 * @param order
	 */
	public void returnOrder(ReceiveOrder order);
}
