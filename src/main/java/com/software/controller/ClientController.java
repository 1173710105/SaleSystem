package com.software.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.topservice.ClientManagerService;
import com.software.trans.ReceiveClient;


@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientManagerService service;
	
	@RequestMapping("/queryById")
	public com.software.domain.Client queryClientById(@RequestBody Map<String, String> param){
		String id = param.get("id");
		com.software.domain.Client result = new com.software.domain.Client();
		result.setId(Integer.valueOf(id));
		return service.selectByPrimaryKey(result);
	}
	
	@RequestMapping("/query")
	public List<com.software.domain.Client> queryClient(@RequestBody ReceiveClient param){
		com.software.domain.Client client = new com.software.domain.Client();
		client.setId(Integer.valueOf(param.getId()));
		client.setName(param.getName());
		client.setGender(param.getGender());
		client.setPhone(param.getPhone());
		client.setLabel(param.getLabel());
		List<com.software.domain.Client> result = service.selectValid(client);
		return result;
	}
	
	@RequestMapping("/add")
	public String addClient(@RequestBody ReceiveClient param){
		com.software.domain.Client client = new com.software.domain.Client();
		client.setId(Integer.valueOf(param.getId()));
		client.setName(param.getName());
		client.setGender(param.getGender());
		client.setPhone(param.getPhone());
		client.setLabel(param.getLabel());
		service.insertSelective(client);
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteClient(@RequestBody Map<String, String> param){
		String id = param.get("id");
		com.software.domain.Client result = new com.software.domain.Client();
		result.setId(Integer.valueOf(id));
		result.setLabel("invalid");
		service.updateByPrimaryKeySelective(result);
		return "success";
	}
	
	@RequestMapping("/update")
	public String updateClient(@RequestBody ReceiveClient param){
		com.software.domain.Client client = new com.software.domain.Client();
		client.setId(Integer.valueOf(param.getId()));
		client.setName(param.getName());
		client.setGender(param.getGender());
		client.setPhone(param.getPhone());
		client.setLabel(param.getLabel());
		service.updateByPrimaryKeySelective(client);
		return "success";
	}
}
