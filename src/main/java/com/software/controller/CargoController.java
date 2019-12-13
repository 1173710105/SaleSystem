package com.software.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.topservice.ItemManagerSerivce;
import com.software.trans.ReceiveCargo;

@RestController
@RequestMapping("/cargo")
public class CargoController {
	
	@Autowired
	private ItemManagerSerivce service;
	@RequestMapping("/queryById")
	public ReceiveCargo queryCargoById(@RequestBody ReceiveCargo param){
		param.setLabel("valid");
		ReceiveCargo result = service.selectByPrimaryKey(param);
		return result;
	}
	
	@RequestMapping("/query")
	public List<ReceiveCargo> queryCargo(@RequestBody ReceiveCargo param){
		param.setLabel("valid");
		List<ReceiveCargo> result = service.select(param);
		return result;
	}
	
	@RequestMapping("/add")
	public String addCargo(@RequestBody ReceiveCargo param){
		param.setLabel("valid");
		service.insertSelective(param);
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteCargo(@RequestBody ReceiveCargo param){
		param.setLabel("invalid");
		service.updateByPrimaryKeySelective(param);
		return "success";
	}
	
	@RequestMapping("/update")
	public String updateCargo(@RequestBody ReceiveCargo param){
		param.setLabel("valid");
		service.updateByPrimaryKeySelective(param);
		return "success";
	}
	
	public Map<Integer, String> typeMenu()
	{
		return service.typeMenu();
	}
}
