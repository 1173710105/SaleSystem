package com.software.topservice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.dao.SubBranchDetailMapMapper;
import com.software.domain.SubBranchDetailMap;
import com.software.service.WarehourseOrderCommonService;
import com.software.service.WarehourseOrderItemService;
import com.software.trans.ReceiveWarehourseOrder;
import com.software.trans.SendWarehourseOrder;

@Service
public class WarehourseOrderManagerServiceImp implements WarehourseOrderManagerService 
{

	@Autowired
	private WarehourseOrderCommonService commonService;
	
	@Autowired
	private WarehourseOrderItemService itemService;
	
	@Autowired
	private SubBranchDetailMapMapper mapper;
	@Override
	public List<SendWarehourseOrder> select(ReceiveWarehourseOrder order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(List<ReceiveWarehourseOrder> orderList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(List<ReceiveWarehourseOrder> orderList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ReceiveWarehourseOrder order) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public String checkOrder(ReceiveWarehourseOrder order) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	private String getWarehourseDetailTable(String hourseid)
	{
		if (hourseid.equals("-1")) 
		{
			return "base_warehourse_detail";
		}
		else
		{
			SubBranchDetailMap exampleMap = new SubBranchDetailMap();
			exampleMap.setWarehourseid(Integer.valueOf(hourseid));
			return mapper.select(exampleMap).get(0).getWarehoursedetailtable();
		}
		
	}
}
