package com.software.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.domain.StoreManager;
import com.software.topservice.TopStoreManagerService;

@RestController
@RequestMapping("/shopmanager")
public class ShopmanagerController 
{
	@Autowired
	private TopStoreManagerService service;
	
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
		List<StoreManager> list = service.select(storemanager);
		if (list==null) 
		{
			return null;
		}
		StoreManager result = list.get(0);
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

		
		List<StoreManager> result = service.select(storemanager);
		return result;
	}
	
	@RequestMapping("/insert")
	public String insertManager(@RequestBody Map<String, String> param){
		String hourseid = param.get("hourseid");
		String mid = String.format("%04", Integer.valueOf(hourseid));
		String prefix = "3";
		
		String last = String.format("%04d", service.count());
		String id = prefix+mid+last;
		String password = param.get("password");
		String name = param.get("name");
		String gender = param.get("gender");
		String phone = param.get("phone");
		String email = param.get("email");
		
		StoreManager storemanager = new StoreManager();
		storemanager.setId(id);
		storemanager.setPassword(password);
		storemanager.setName(name);
		storemanager.setGender(gender);
		storemanager.setPhone(phone);
		storemanager.setEmail(email);
		storemanager.setLabel("valid");
		storemanager.setHourseid(hourseid);
		
		service.insertSelective(storemanager);
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
		
		service.updateByPrimaryKeySelective(storemanager);
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
		service.updateByPrimaryKeySelective(storemanager);
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
	
	@RequestMapping("/assign")
	public Map<String, String> assign(@RequestBody Map<String, String> param){
		String id = param.get("id");
		String name = param.get("name");
		String hourseid = param.get("hourseid");
		
		StoreManager storemanager = new StoreManager();
		storemanager.setId(id);
		storemanager.setName(name);
		storemanager.setLabel("valid");
		storemanager.setHourseid(hourseid);
		
		
		String infovalue = service.assign(storemanager);
		Map<String,String> result = new HashMap<String,String>();
		result.put("info", infovalue);
		return result;
	}
}
