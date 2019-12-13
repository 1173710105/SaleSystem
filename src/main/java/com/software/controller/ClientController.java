package com.software.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import ch.qos.logback.core.net.server.Client;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@RequestMapping("/queryById")
	public com.software.domain.Client queryClientById(@RequestBody Map<String, String> param){
		String id = param.get("id");
		com.software.domain.Client result = null;
		
		
		return result;
	}
	
	@RequestMapping("/query")
	public List<com.software.domain.Client> queryClient(@RequestBody ReceiveClient param){
		com.software.domain.Client client = new com.software.domain.Client();
		client.setId(Integer.valueOf(param.getId()));
		client.setName(param.getName());
		client.setGender(param.getGender());
		client.setPhone(param.getPhone());
		client.setLabel(param.getLabel());
		
		List<com.software.domain.Client> result = null;
		return result;
	}
	
	@RequestMapping("/add")
	public String addClient(@RequestBody ReceiveClient param){
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteClient(@RequestBody Map<String, String> param){
		String id = param.get("id");
		return "success";
	}
	
	@RequestMapping("/update")
	public String updateClient(@RequestBody ReceiveClient param){
		return "success";
	}
}
