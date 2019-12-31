package com.software.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.software.domain.SubBranchDetailMap;
import com.software.topservice.LoginManagerService;
import com.software.trans.ReceiveUser;

@RestController
@RequestMapping("/exam")
public class LoginController 
{
	@Autowired
	private LoginManagerService loginService;
	
	private Map<String, SubBranchDetailMap> mp = new HashMap<String, SubBranchDetailMap>();
	
	@RequestMapping(value = {"/administrator/login","/teacher/login","/student/login"})
	public String login(@RequestBody ReceiveUser param)
	{
		String id = param.getId();
		String password = param.getPassword();
		String authority = param.getType();
		SubBranchDetailMap map = loginService.login(id, password, authority);
		System.out.println(map);
    	if(map.getFlag().equals("true"))
    	{
			mp.put(id, map);
		}
		return map.getFlag();
	}
	
	@RequestMapping("/secondRequest")
	public SubBranchDetailMap secondRequest(@RequestBody ReceiveUser param)
	{
		String id = param.getId();
		if(mp.containsKey(id)){
			System.out.println(mp.get(id).toString());
			return mp.get(id);
		}else{
			return null;
		}
	}
}