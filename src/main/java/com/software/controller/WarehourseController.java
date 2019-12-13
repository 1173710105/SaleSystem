package com.software.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.domain.Staff;
import com.software.domain.Warehourse;

@RestController
@RequestMapping("/warehourse")
public class WarehourseController {
	@RequestMapping("/queryById")
	public Warehourse queryWarehourseById(@RequestBody Warehourse param){
		Warehourse result = null;
		
		return result;
	}
	
	@RequestMapping("/query")
	public List<Warehourse> queryWarehourse(@RequestBody Warehourse pamram){
		List<Warehourse> result = null;
		return result;
	}
	
	@RequestMapping("/add")
	public String addWarehourse(@RequestBody Warehourse param){
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteWarehourse(@RequestBody Warehourse param){
		return "success";
	}
	
	@RequestMapping("/update")
	public String updateWarehourse(@RequestBody Warehourse param){
		return "success";
	}
}
