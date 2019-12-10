package com.software.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.dao.WarehourseMapper;
import com.software.domain.Warehourse;

@Service
public class WarehourseServiceImp implements WarehourseService {

	@Autowired
	private WarehourseMapper mapper;
	
	@Override
	public void deleteByPrimaryKey(Warehourse record) 
	{
		// 需要删除，附加表单吗？？？

	}

	@Override
	public void insert(Warehourse record) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void insertSelective(Warehourse record) {
		// TODO Auto-generated method stub

	}

	@Override
	public Warehourse selectByPrimaryKey(Warehourse record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Warehourse> select(Warehourse record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateByPrimaryKeySelective(Warehourse record) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateByPrimaryKey(Warehourse record) {
		// TODO Auto-generated method stub

	}

}
