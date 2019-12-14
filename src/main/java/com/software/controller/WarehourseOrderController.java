package com.software.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.topservice.WarehourseOrderManagerService;
import com.software.trans.ReceiveWarehourseOrder;
import com.software.trans.SendWarehourseOrder;

@RestController
@RequestMapping("/warehourseOrder")
public class WarehourseOrderController 
{
	@Autowired
	private WarehourseOrderManagerService service;
	
	@RequestMapping("/queryById")
	public SendWarehourseOrder queryWarehourseOrderById(@RequestBody ReceiveWarehourseOrder param){
		
		SendWarehourseOrder result = service.select(param).get(0);
		return result;
	}
	
	@RequestMapping("/query")
	public List<SendWarehourseOrder> queryWarehourseOrder(@RequestBody ReceiveWarehourseOrder param){
		List<SendWarehourseOrder> result = service.select(param);
		return result;
	}
	
	@RequestMapping("/insert")
	public String insertWarehourseOrder(@RequestBody List<ReceiveWarehourseOrder> param){
		if (param.size()==0) 
		{
			return "";
		}
		param.get(0).setStatus(1+"");
		service.insert(param);
		return "success";
	}
	
	@RequestMapping("/update")
	public String updateWarehourseOrder(@RequestBody List<ReceiveWarehourseOrder> param){
		if (param.size()==0) 
		{
			return "";
		}
		param.get(0).setStatus(1+"");
		service.update(param);
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteWarehourseOrder(@RequestBody ReceiveWarehourseOrder param){
		service.delete(param);
		return "success";
	}
	
	@RequestMapping("/apply")
	public String applyWarehourseOrder(@RequestBody ReceiveWarehourseOrder param){
		// update
		param.setStatus(2+"");
		service.updateStatus(param);
		return "success";
	}
	
	@RequestMapping("/pass")
	public String passWarehourseOrder(@RequestBody ReceiveWarehourseOrder param){
		// check
		param.setStatus(4+"");
		String result = service.checkOrder(param);
		return result;
	}
}
