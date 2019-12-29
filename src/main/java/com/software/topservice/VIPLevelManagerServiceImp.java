package com.software.topservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.VIPLevel;
import com.software.service.VIPLevelService;

@Service
public class VIPLevelManagerServiceImp implements VIPLevelManagerService 
{

	@Autowired
	private VIPLevelService service;
	
	@Override
	public void deleteByPrimaryKey(VIPLevel record) {
		service.deleteByPrimaryKey(record);
	}

	@Override
	public void insert(VIPLevel record) {
		service.insert(record);
	}

	@Override
	public void insertSelective(VIPLevel record) {
		service.insertSelective(record);
	}

	@Override
	public VIPLevel selectByPrimaryKey(VIPLevel record) {
		return service.selectByPrimaryKey(record);
	}

	@Override
	public List<VIPLevel> select(VIPLevel record) {
		return service.select(record);
	}

	@Override
	public void updateByPrimaryKeySelective(VIPLevel record) {
		service.updateByPrimaryKeySelective(record);
	}

	@Override
	public void updateByPrimaryKey(VIPLevel record) {
		service.updateByPrimaryKey(record);
	}

}
