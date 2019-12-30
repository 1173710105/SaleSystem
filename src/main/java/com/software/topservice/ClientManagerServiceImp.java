package com.software.topservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.Client;
import com.software.domain.SaleorderCommon;
import com.software.domain.SubBranchDetailMap;
import com.software.domain.WarehourseOrderCommon;
import com.software.service.ClientService;
import com.software.service.SaleorderCommonService;
import com.software.service.SubBranchDetailMapService;
import com.software.service.WarehourseOrderCommonService;

@Service
public class ClientManagerServiceImp implements ClientManagerService {

	@Autowired
	private ClientService service;
	
	@Autowired
	private SaleorderCommonService saleCommonService;
	
	@Autowired
	private SubBranchDetailMapService mapService;
	
	@Override
	public String deleteByPrimaryKey(Client record) 
	{
		if (isCited(record.getId())) 
		{
			return "删除失败，客户被引用";
		}
		service.deleteByPrimaryKey(record);
		return "删除成功";
	}

	@Override
	public void insert(Client record) 
	{
		service.insert(record);
	}

	@Override
	public void insertSelective(Client record) 
	{
		service.insertSelective(record);
	}

	@Override
	public Client selectByPrimaryKey(Client record) 
	{
		return service.selectByPrimaryKey(record);
	}

	@Override
	public List<Client> select(Client record) 
	{		
		return service.select(record);
	}
	
	@Override
	public void updateByPrimaryKeySelective(Client record) {
		service.updateByPrimaryKeySelective(record);
	}

	@Override
	public void updateByPrimaryKey(Client record) 
	{
		service.updateByPrimaryKey(record);
	}
	
	private boolean isCited(Integer clientid)
	{
		SubBranchDetailMap exampleMap = new SubBranchDetailMap();
		exampleMap.setLabel("valid");
		SaleorderCommon exampleCommon = new SaleorderCommon();
		exampleCommon.setClientid(clientid);
		for (SubBranchDetailMap map : mapService.select(exampleMap)) 
		{
			exampleCommon.setTablename(map.getSaleordercommontable());
			if(saleCommonService.select(exampleCommon).size()>=1) 
			{
				return true;
			}
		}
		return false;
	}
}
