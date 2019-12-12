package com.software.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.domain.GeneralManager;
import com.software.domain.Staff;
import com.software.domain.StoreManager;
import com.software.domain.SubBranchDetailMap;
import com.software.service.GeneralManagerService;
import com.software.service.StaffService;
import com.software.service.StoreManagerService;
import com.software.service.SubBranchDetailMapService;
import com.software.topservice.LoginManagerService;

@RestController
@RequestMapping("/exam")
public class LoginController 
{
	@Autowired
	private LoginManagerService loginManagerService;
	
	@RequestMapping(value = {"/administrator/login","/teacher/login","/student/login"})
	public String login(@RequestBody Map<String,Object> params)
	{
		String id = (String) params.get("id");
		String password = (String) params.get("password");
		String authority = (String) params.get("type");
		System.out.println(authority);
		
		System.out.println(loginManagerService.login(id, password, authority).getFlag());
		return "true";
	}
}
