package com.software.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.domain.Staff;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	
	@RequestMapping("/queryById")
	public Staff queryStaffById(@RequestBody Map<String, String> param){
		String tablename = param.get("tablename");
		String id = param.get("id");
		String password = param.get("password");
		Integer hourseid = Integer.valueOf(param.get("hourseid"));
		String name = param.get("name");
		String gender = param.get("gender");
		String phone = param.get("phone");
		String email = param.get("email");
		
		Staff staff = new Staff();
		staff.setTablename(tablename);
		staff.setId(id);
		staff.setPassword(password);
		staff.setHourseid(hourseid);
		staff.setName(name);
		staff.setGender(gender);
		staff.setPhone(phone);
		staff.setEmail(email);
		staff.setLabel("valid");
		
		
		Staff result = null;
		
		return result;
	}
	
	@RequestMapping("/query")
	public List<Staff> queryStaff(@RequestBody Map<String, String> param){
		String tablename = param.get("tablename");
		String id = param.get("id");
		String password = param.get("password");
		Integer hourseid = Integer.valueOf(param.get("hourseid"));
		String name = param.get("name");
		String gender = param.get("gender");
		String phone = param.get("phone");
		String email = param.get("email");
		
		Staff staff = new Staff();
		staff.setTablename(tablename);
		staff.setId(id);
		staff.setPassword(password);
		staff.setHourseid(hourseid);
		staff.setName(name);
		staff.setGender(gender);
		staff.setPhone(phone);
		staff.setEmail(email);
		staff.setLabel("valid");
		
		List<Staff> result = null;
		return result;
	}
	
	@RequestMapping("/add")
	public String addStaff(@RequestBody Map<String, String> param){
		String tablename = param.get("tablename");
		String id = param.get("id");
		String password = param.get("password");
		Integer hourseid = Integer.valueOf(param.get("hourseid"));
		String name = param.get("name");
		String gender = param.get("gender");
		String phone = param.get("phone");
		String email = param.get("email");
		
		Staff staff = new Staff();
		staff.setTablename(tablename);
		staff.setId(id);
		staff.setPassword(password);
		staff.setHourseid(hourseid);
		staff.setName(name);
		staff.setGender(gender);
		staff.setPhone(phone);
		staff.setEmail(email);
		staff.setLabel("valid");
		
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteStaff(@RequestBody Map<String, String> param){
		String tablename = param.get("tablename");
		String id = param.get("id");
		String password = param.get("password");
		Integer hourseid = Integer.valueOf(param.get("hourseid"));
		String name = param.get("name");
		String gender = param.get("gender");
		String phone = param.get("phone");
		String email = param.get("email");
		
		Staff staff = new Staff();
		staff.setTablename(tablename);
		staff.setId(id);
		staff.setPassword(password);
		staff.setHourseid(hourseid);
		staff.setName(name);
		staff.setGender(gender);
		staff.setPhone(phone);
		staff.setEmail(email);
		staff.setLabel("valid");
		
		return "success";
	}
	
	@RequestMapping("/update")
	public String updateStaff(@RequestBody Map<String, String> param){
		String tablename = param.get("tablename");
		String id = param.get("id");
		String password = param.get("password");
		Integer hourseid = Integer.valueOf(param.get("hourseid"));
		String name = param.get("name");
		String gender = param.get("gender");
		String phone = param.get("phone");
		String email = param.get("email");
		
		Staff staff = new Staff();
		staff.setTablename(tablename);
		staff.setId(id);
		staff.setPassword(password);
		staff.setHourseid(hourseid);
		staff.setName(name);
		staff.setGender(gender);
		staff.setPhone(phone);
		staff.setEmail(email);
		staff.setLabel("valid");
		
		return "success";
	}
}
