package com.software.topservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.dao.WarehourseMapper;
import com.software.domain.Warehourse;
import com.software.service.WarehourseService;

@Service
public class WarehourseManagerServiceImp implements WarehourseManagerService {

	@Autowired
	private WarehourseService service;
	
	@Override
	public void deleteByPrimaryKey(Warehourse record) 
	{
		service.deleteByPrimaryKey(record);

	}

	@Override
	public void insertSelective(Warehourse record) 
	{
		service.insertSelective(record);
	}

	@Override
	public Warehourse selectByPrimaryKey(Warehourse record) 
	{
		return service.selectByPrimaryKey(record);
	}

	@Override
	public List<Warehourse> select(Warehourse record) 
	{
		return service.select(record);
	}

	@Override
	public void updateByPrimaryKeySelective(Warehourse record) 
	{
		service.updateByPrimaryKeySelective(record);
	}

	@Override
	public void updateByPrimaryKey(Warehourse record) 
	{
		service.updateByPrimaryKey(record);
	}
}
