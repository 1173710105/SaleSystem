package com.software.topservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.Client;
import com.software.service.ClientService;

@Service
public class ClientManagerServiceImp implements ClientManagerService 
{
	@Autowired
	private ClientService service;
	
	@Override
	public void deleteByPrimaryKey(Client record) 
	{
		service.deleteByPrimaryKey(record);
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
	public void updateByPrimaryKeySelective(Client record) 
	{
		service.updateByPrimaryKeySelective(record);
	}

}
