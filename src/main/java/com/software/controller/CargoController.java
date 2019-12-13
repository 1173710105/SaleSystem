package com.software.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.trans.ReceiveCargo;

@RestController
@RequestMapping("/cargo")
public class CargoController {
	
	@RequestMapping("/queryById")
	public ReceiveCargo queryCargoById(@RequestBody Map<String, String> param){
		Integer id = Integer.valueOf(param.get("id"));
		
		ReceiveCargo result = new ReceiveCargo();
		return result;
	}
	
	@RequestMapping("/query")
	public List<ReceiveCargo> queryCargo(@RequestBody ReceiveCargo param){
		List<ReceiveCargo> result = new ArrayList<ReceiveCargo>();
		
		return result;
	}
	
	@RequestMapping("/add")
	public String addCargo(@RequestBody ReceiveCargo param){
		
		
		return "success";
	}
}
