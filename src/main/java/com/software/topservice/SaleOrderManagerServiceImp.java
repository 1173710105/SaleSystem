package com.software.topservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.SaleorderCommon;
import com.software.service.ItemService;
import com.software.service.SaleorderCommonService;
import com.software.service.SaleorderItemService;
import com.software.trans.ReceiveOrder;
import com.software.trans.SendOrder;

@Service
public class SaleOrderManagerServiceImp implements SaleOrderManagerService {

	@Autowired 
	private SaleorderCommonService commonService;
	@Autowired
	private SaleorderItemService ItemService;
	
	@Override
	public List<SendOrder> select(ReceiveOrder order) 
	{
		List<SendOrder> result = new ArrayList<SendOrder>();
		SaleorderCommon exampleCommon = order.toCommon();
		List<SaleorderCommon> commonList = commonService.select(exampleCommon);
		
		
		return null;
	}

	@Override
	public void insert(List<ReceiveOrder> orderList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(List<ReceiveOrder> orderList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ReceiveOrder order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkOrder(ReceiveOrder order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void payOrder(ReceiveOrder order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void returnOrder(ReceiveOrder order) {
		// TODO Auto-generated method stub

	}

}
