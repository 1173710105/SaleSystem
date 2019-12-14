package com.software.controller;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.domain.StoreManager;

@RestController
@RequestMapping("/shopmanager")
public class ShopmanagerController {
	@RequestMapping("/queryById")
	public StoreManager queryManagerById(@RequestBody Map<String, String> param){
		String id = param.get("id");
		String password = param.get("password");
		String name = param.get("name");
		String gender = param.get("gender");
		String phone = param.get("phone");
		String email = param.get("email");
		String hourseid = param.get("hourseid");
		
		StoreManager storemanager = new StoreManager();
		storemanager.setId(id);
		storemanager.setPassword(password);
		storemanager.setName(name);
		storemanager.setGender(gender);
		storemanager.setPhone(phone);
		storemanager.setEmail(email);
		storemanager.setLabel("valid");
		storemanager.setHourseid(hourseid);

		
		
		StoreManager result = null;
		return result;
	}
	
	@RequestMapping("/query")
	public List<StoreManager> queryManager(@RequestBody Map<String, String> param){
		String id = param.get("id");
		String password = param.get("password");
		String name = param.get("name");
		String gender = param.get("gender");
		String phone = param.get("phone");
		String email = param.get("email");
		String hourseid = param.get("hourseid");
		
		StoreManager storemanager = new StoreManager();
		storemanager.setId(id);
		storemanager.setPassword(password);
		storemanager.setName(name);
		storemanager.setGender(gender);
		storemanager.setPhone(phone);
		storemanager.setEmail(email);
		storemanager.setLabel("valid");
		storemanager.setHourseid(hourseid);

		
		List<StoreManager> result = null;
		return result;
	}
	
	@RequestMapping("/insert")
	public String insertManager(@RequestBody Map<String, String> param){
		String id = param.get("id");
		String password = param.get("password");
		String name = param.get("name");
		String gender = param.get("gender");
		String phone = param.get("phone");
		String email = param.get("email");
		String hourseid = param.get("hourseid");
		
		StoreManager storemanager = new StoreManager();
		storemanager.setId(id);
		storemanager.setPassword(password);
		storemanager.setName(name);
		storemanager.setGender(gender);
		storemanager.setPhone(phone);
		storemanager.setEmail(email);
		storemanager.setLabel("valid");
		storemanager.setHourseid(hourseid);
		
		
		
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteManager(@RequestBody Map<String, String> param){
		String id = param.get("id");
		String password = param.get("password");
		String name = param.get("name");
		String gender = param.get("gender");
		String phone = param.get("phone");
		String email = param.get("email");
		String hourseid = param.get("hourseid");
		
		StoreManager storemanager = new StoreManager();
		storemanager.setId(id);
		storemanager.setPassword(password);
		storemanager.setName(name);
		storemanager.setGender(gender);
		storemanager.setPhone(phone);
		storemanager.setEmail(email);
		storemanager.setLabel("invalid");
		storemanager.setHourseid(hourseid);
		
		return "success";
	}
	
	@RequestMapping("/update")
	public String updateManager(@RequestBody Map<String, String> param){
		String id = param.get("id");
		String password = param.get("password");
		String name = param.get("name");
		String gender = param.get("gender");
		String phone = param.get("phone");
		String email = param.get("email");
		String hourseid = param.get("hourseid");
		
		StoreManager storemanager = new StoreManager();
		storemanager.setId(id);
		storemanager.setPassword(password);
		storemanager.setName(name);
		storemanager.setGender(gender);
		storemanager.setPhone(phone);
		storemanager.setEmail(email);
		storemanager.setLabel("valid");
		storemanager.setHourseid(hourseid);
		
		return "success";
	}
	
	@RequestMapping("/queryWare")
	public String queryWareIdByManagerId(@RequestBody Map<String, String> param){
		String id = param.get("id");
		StoreManager storemanager = new StoreManager();
		storemanager.setId(id);
		
		StoreManager result = null;
		return result.getHourseid();
	}
}
