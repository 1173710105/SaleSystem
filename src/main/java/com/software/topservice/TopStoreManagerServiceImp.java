package com.software.topservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.StoreManager;
import com.software.service.StoreManagerService;

@Service
public class TopStoreManagerServiceImp implements TopStoreManagerService 
{
	@Autowired
	private StoreManagerService service;
	
	
	@Override
	public void insertSelective(StoreManager record) 
	{
		service.insertSelective(record);
	}

	@Override
	public List<StoreManager> select(StoreManager record) 
	{
		return service.select(record);
	}

	@Override
	public void updateByPrimaryKeySelective(StoreManager record) 
	{
		service.updateByPrimaryKeySelective(record);
	}

}
