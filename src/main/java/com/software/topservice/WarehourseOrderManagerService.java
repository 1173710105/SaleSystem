package com.software.topservice;

import java.util.List;

import com.software.trans.ReceiveOrder;
import com.software.trans.ReceiveWarehourseOrder;
import com.software.trans.SendOrder;
import com.software.trans.SendWarehourseOrder;

public interface WarehourseOrderManagerService 
{
	public List<SendWarehourseOrder> select(ReceiveWarehourseOrder order);
	
	public void insert(List<ReceiveWarehourseOrder> orderList);
	
	public void update(List<ReceiveWarehourseOrder> orderList);
	
	public void delete(ReceiveWarehourseOrder order);

	public String checkOrder(ReceiveWarehourseOrder order);
	
}
