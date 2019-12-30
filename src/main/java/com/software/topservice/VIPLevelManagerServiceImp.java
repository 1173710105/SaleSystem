package com.software.topservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.Client;
import com.software.domain.VIPLevel;
import com.software.service.ClientService;
import com.software.service.VIPLevelService;

@Service
public class VIPLevelManagerServiceImp implements VIPLevelManagerService 
{
	@Autowired
	private VIPLevelService service;
	
	@Autowired
	private ClientService clientService;
	
	@Override
	public List<VIPLevel> select(VIPLevel record) 
	{
		return service.select(record);
	}

	@Override
	public void updateByPrimaryKey(VIPLevel record) 
	{
		// 更新VIP信息，还需要更新客人信息
		service.updateByPrimaryKey(record);
		
		Client exampleClient = new Client();
		exampleClient.setAuthority(record.getVipname());
		List<Client> clientList = clientService.select(exampleClient);
		for (Client client : clientList) 
		{
			client.setPointtoprice(record.getPointtoprice());
			client.setPricetopoint(record.getPricetopoint());
			clientService.updateByPrimaryKeySelective(client);
		}
	}

	@Override
	public Map<Integer, String> vipMenu()
	{
		List<VIPLevel> list = service.select(null);
		Map<Integer, String> idToName = new HashMap<Integer, String>();
		for (VIPLevel vipLevel : list) 
		{
			idToName.put(vipLevel.getId(), vipLevel.getVipname());
		}
		return idToName;
	}
}
