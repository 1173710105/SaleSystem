package com.software.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.domain.Staff;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@RequestMapping("/queryById")
	public Staff queryStaffById(@RequestBody Staff param){
		Staff result = null;
		
		
		return result;
	}
	
	@RequestMapping("/query")
	public List<Staff> queryStaff(@RequestBody Staff pamram){
		List<Staff> result = null;
		return result;
	}
	
	@RequestMapping("/add")
	public String addStaff(@RequestBody Staff param){
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteStaff(@RequestBody Staff param){
		return "success";
	}
	
	@RequestMapping("/update")
	public String updateStaff(@RequestBody Staff param){
		return "success";
	}
}
