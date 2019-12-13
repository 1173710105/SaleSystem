package com.software.topservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.Staff;
import com.software.domain.StoreManager;
import com.software.service.StaffService;

@Service
public class StaffManagerServiceImp implements StaffManagerService 
{
	@Autowired
	private StaffService service;
	
	@Override
	public void insertSelective(Staff record)
	{
		service.insertSelective(record);
	}

	@Override
	public Staff selectByPrimaryKey(Staff record) 
	{
		return service.selectByPrimaryKey(record);
	}

	@Override
	public List<Staff> select(Staff record) 
	{
		return service.select(record);
	}

	@Override
	public void updateByPrimaryKeySelective(Staff record) 
	{
		service.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public int count(Staff staff)
	{
		return service.count(record);
	}
}
