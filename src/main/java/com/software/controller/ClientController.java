package com.software.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.server.Client;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@RequestMapping("/queryById")
	public Client queryClientById(@RequestBody Map<String, String> param){
		Client result = null;
		return result;
	}
//	
//	public List<com.software.domain.Client> queryClient()
}
