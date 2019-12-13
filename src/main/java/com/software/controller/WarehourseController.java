package com.software.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.domain.Staff;
import com.software.domain.Warehourse;
import com.software.service.WarehourseService;
import com.software.topservice.WarehourseManagerService;


@RestController
@RequestMapping("/warehourse")
public class WarehourseController 
{
	@Autowired
	private WarehourseManagerService service;
	
	@RequestMapping("/queryById")
	public Warehourse queryWarehourseById(@RequestBody Map<String, String> param){
		Warehourse warehourse = new Warehourse();
		warehourse.setId(Integer.valueOf(param.get("id")));
		warehourse.setName(param.get("name"));
		warehourse.setLocation(param.get("location"));
		warehourse.setPrincipalid(param.get("principalid"));
		warehourse.setLabel("valid");
		
		Warehourse result = null;
		return result;
	}
	
	@RequestMapping("/query")
	public List<Warehourse> queryWarehourse(@RequestBody Map<String, String> param){
		Warehourse warehourse = new Warehourse();
		warehourse.setId(Integer.valueOf(param.get("id")));
		warehourse.setName(param.get("name"));
		warehourse.setLocation(param.get("location"));
		warehourse.setPrincipalid(param.get("principalid"));
		warehourse.setLabel("valid");
		
		List<Warehourse> result = null;
		return result;
	}
	
	@RequestMapping("/add")
	public String addWarehourse(@RequestBody Map<String, String> param){
		Warehourse warehourse = new Warehourse();
		warehourse.setId(Integer.valueOf(param.get("id")));
		warehourse.setName(param.get("name"));
		warehourse.setLocation(param.get("location"));
		warehourse.setPrincipalid(param.get("principalid"));
		warehourse.setLabel("valid");
		
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteWarehourse(@RequestBody Map<String, String> param){
		Warehourse warehourse = new Warehourse();
		warehourse.setId(Integer.valueOf(param.get("id")));
		warehourse.setName(param.get("name"));
		warehourse.setLocation(param.get("location"));
		warehourse.setPrincipalid(param.get("principalid"));
		
		return "success";
	}
	
	@RequestMapping("/update")
	public String updateWarehourse(@RequestBody Map<String, String> param){
		Warehourse warehourse = new Warehourse();
		warehourse.setId(Integer.valueOf(param.get("id")));
		warehourse.setName(param.get("name"));
		warehourse.setLocation(param.get("location"));
		warehourse.setPrincipalid(param.get("principalid"));
		warehourse.setLabel("valid");
		
		return "success";
	}
}
