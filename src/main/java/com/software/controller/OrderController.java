package com.software.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
	@RequestMapping("/query")
	public Order queryOrder(@RequestBody Map<String, Object> params){
		Integer orderid = (Integer) params.get("orderid");
		Integer viceid = (Integer) params.get("viceid");
		Integer clientid = (Integer) params.get("clientid");
		Integer principalid = (Integer) params.get("principalid");
		Integer itemnum = (Integer) params.get("itemnum");
		Float perprice = (Float) params.get("perprice");
		Float sumprice = (Float) params.get("sumprice");
		Float margin = (Float) params.get("margin");
		System.out.println(orderid);
		Order result = new Order();
		//根据查询结果确定result
		
		return result;
	}
}
