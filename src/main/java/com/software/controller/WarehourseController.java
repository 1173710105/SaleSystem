package com.software.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		warehourse.setLabel("valid");
		Warehourse result = service.selectByPrimaryKey(warehourse);
		return result;
	}
	
	@RequestMapping("/query")
	public List<Warehourse> queryWarehourse(@RequestBody Map<String, String> param){
		Warehourse warehourse = new Warehourse();
		warehourse.setId(Integer.valueOf(param.get("id")));
		warehourse.setName(param.get("name"));
		warehourse.setLocation(param.get("location"));
		warehourse.setLabel("valid");
		List<Warehourse> result = service.select(warehourse);
		return result;
	}
	
	@RequestMapping("/add")
	public String addWarehourse(@RequestBody Map<String, String> param){
		Warehourse warehourse = new Warehourse();
		warehourse.setId(Integer.valueOf(param.get("id")));
		warehourse.setName(param.get("name"));
		warehourse.setLocation(param.get("location"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间
		warehourse.setTime(date);
		warehourse.setLabel("valid");
		service.insertSelective(warehourse);
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteWarehourse(@RequestBody Map<String, String> param){
		Warehourse warehourse = new Warehourse();
		warehourse.setId(Integer.valueOf(param.get("id")));
		warehourse.setName(param.get("name"));
		warehourse.setLocation(param.get("location"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间
		warehourse.setTime(date);
		warehourse.setLabel("invalid");
		service.updateByPrimaryKeySelective(warehourse);
		return "success";
	}
	
	@RequestMapping("/update")
	public String updateWarehourse(@RequestBody Map<String, String> param){
		Warehourse warehourse = new Warehourse();
		warehourse.setId(Integer.valueOf(param.get("id")));
		warehourse.setName(param.get("name"));
		warehourse.setLocation(param.get("location"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间
		warehourse.setTime(date);
		warehourse.setLabel("valid");
		service.updateByPrimaryKeySelective(warehourse);
		return "success";
	}
}
