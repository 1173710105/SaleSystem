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
	public Staff queryClientById(@RequestBody Map<String, String> param){
		String id = param.get("id");
		Staff result = null;
		
		
		return result;
	}
	
	@RequestMapping("/query")
	public List<Staff> queryClient(@RequestBody Staff pamram){
		List<Staff> result = null;
		return result;
	}
	
	@RequestMapping("/add")
	public String addClient(@RequestBody com.software.domain.Client param){
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteClient(@RequestBody Map<String, String> param){
		String id = param.get("id");
		return "success";
	}
	
	@RequestMapping("/update")
	public String updateClient(@RequestBody com.software.domain.Client param){
		return "success";
	}
}
