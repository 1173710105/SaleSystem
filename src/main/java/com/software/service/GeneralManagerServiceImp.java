package com.software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.software.dao.GeneralManagerMapper;
import com.software.domain.GeneralManager;

@Service
public class GeneralManagerServiceImp implements GeneralManagerService 
{
	@Autowired 
	private GeneralManagerMapper gmm;
	
	@Override
	public void deleteByPrimaryKey(GeneralManager record) 
	{
		gmm.deleteByPrimaryKey(record);
	}

	@Override
	public void insert(GeneralManager record) 
	{
		gmm.insert(record);
	}

	@Override
	public void insertSelective(GeneralManager record) 
	{
		gmm.insertSelective(record);

	}

	@Override
	public GeneralManager selectByPrimaryKey(GeneralManager record) 
	{
		return gmm.selectByPrimaryKey(record);
	}

	@Override
	public void updateByPrimaryKeySelective(GeneralManager record) {
		gmm.updateByPrimaryKeySelective(record);

	}

	@Override
	public void updateByPrimaryKey(GeneralManager record) {
		gmm.updateByPrimaryKey(record);

	}

	@Override
	public GeneralManager login(GeneralManager record) 
	{
		GeneralManager gManager = new GeneralManager();
		gManager.setId(record.getId());
		
		GeneralManager result = gmm.selectByPrimaryKey(gManager);
		if(result==null)
		{
			return null;
		}
		else if (result.getPassword().equals(record.getPassword())) 
		{
			return result;
		}
		else 
		{
			return null;
		}
	}

}
