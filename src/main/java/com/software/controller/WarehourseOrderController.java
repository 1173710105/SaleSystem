package com.software.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.trans.ReceiveWarehourseOrder;
import com.software.trans.SendWarehourseOrder;

@RestController
@RequestMapping("/warehourseOrder")
public class WarehourseOrderController {
	@RequestMapping("/queryById")
	public SendWarehourseOrder queryWarehourseOrderById(@RequestBody ReceiveWarehourseOrder param){
		
		SendWarehourseOrder result = null;
		return result;
	}
	
	@RequestMapping("/query")
	public List<SendWarehourseOrder> queryWarehourseOrder(@RequestBody ReceiveWarehourseOrder param){
		List<SendWarehourseOrder> result = null;
		return result;
	}
	
	@RequestMapping("/insert")
	public String insertWarehourseOrder(@RequestBody List<ReceiveWarehourseOrder> param){
		return "success";
	}
	
	@RequestMapping("/update")
	public String updateWarehourseOrder(@RequestBody List<ReceiveWarehourseOrder> param){
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteWarehourseOrder(@RequestBody ReceiveWarehourseOrder param){
		return "success";
	}
	
	@RequestMapping("/apply")
	public String applyWarehourseOrder(@RequestBody ReceiveWarehourseOrder param){
		// update
		return "success";
	}
	
	@RequestMapping("/pass")
	public String passWarehourseOrder(@RequestBody ReceiveWarehourseOrder param){
		// check
		return "success";
	}
}
