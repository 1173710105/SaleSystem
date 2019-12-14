package com.software.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.domain.Staff;
import com.software.topservice.StaffManagerService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	private StaffManagerService service;
	
	@RequestMapping("/queryById")
	public Staff queryStaffById(@RequestBody Map<String, String> param)
	{
		String id = param.get("id");
		String password = param.get("password");
		Integer hourseid = Integer.valueOf(param.get("hourseid"));
		String tablename = "sub_staff_"+String.format("%04d", hourseid);
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
		
		
		Staff result = service.selectByPrimaryKey(staff);
		return result;
	}
	
	@RequestMapping("/query")
	public List<Staff> queryStaff(@RequestBody Map<String, String> param){
		String id = param.get("id");
		String password = param.get("password");
		Integer hourseid = Integer.valueOf(param.get("hourseid"));
		String tablename = "sub_staff_"+String.format("%04d", hourseid);
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
		
		List<Staff> result = service.select(staff);
		return result;
	}
	
	@RequestMapping("/add")
	public String addStaff(@RequestBody Map<String, String> param){
		Integer hourseid = Integer.valueOf(param.get("hourseid"));
		String tablename = "sub_staff_"+String.format("%04d", hourseid);
		String mid = tablename.substring(tablename.length()-4, tablename.length());
		String prefix = "3";
		String last = String.format("%04d", service.count(null));
		String id = prefix+mid+last;
		String password = param.get("password");
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
		
		service.insertSelective(staff);
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteStaff(@RequestBody Map<String, String> param){
		String id = param.get("id");
		String password = param.get("password");
		Integer hourseid = Integer.valueOf(param.get("hourseid"));
		String tablename = "sub_staff_"+String.format("%04d", hourseid);
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
		staff.setLabel("invalid");
		service.updateByPrimaryKeySelective(staff);
		return "success";
	}
	
	@RequestMapping("/update")
	public String updateStaff(@RequestBody Map<String, String> param){
		String id = param.get("id");
		String password = param.get("password");
		Integer hourseid = Integer.valueOf(param.get("hourseid"));
		String tablename = "sub_staff_"+String.format("%04d", hourseid);
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
		service.updateByPrimaryKeySelective(staff);
		return "success";
	}
}
