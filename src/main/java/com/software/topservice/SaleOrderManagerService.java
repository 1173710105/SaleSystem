package com.software.topservice;

import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import com.software.trans.ReceiveOrder;
import com.software.trans.SendOrder;

public interface SaleOrderManagerService 
{
	public List<SendOrder> select(ReceiveOrder order);
	
}
