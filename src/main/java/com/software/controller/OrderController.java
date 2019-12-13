package com.software.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.software.trans.ReceiveOrder;
import com.software.trans.SendOrder;

@RestController
@RequestMapping("/order")
public class OrderController {
	@RequestMapping("/query")
	public List<SendOrder> queryOrder(@RequestBody ReceiveOrder param)
	{
		
		List<SendOrder> result = null;
		return result;//返回查找结果
	}
	
	@RequestMapping("/insert")
	public String insertOrder(@RequestBody List<ReceiveOrder> param){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String createtime = df.format(new Date());// new Date()为获取当前系统时间
		for(ReceiveOrder r:param){
			r.setCreatetime(createtime);
		}
		
		String result = null;
		return result;//返回成功/失败信息
	}
	
	@RequestMapping("/update")
	public String updateOrder(@RequestBody List<ReceiveOrder> param){
		String result = null;
		return result;//返回成功/失败信息
	}
	
	@RequestMapping("/delete")
	public String deleteOrder(@RequestBody ReceiveOrder param){
		String result = null;
		return result;//返回成功/失败信息
	}
	
	@RequestMapping("/check")
	public String checkOrder(@RequestBody ReceiveOrder param){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String checktime = df.format(new Date());// new Date()为获取当前系统时间
		param.setChecktime(checktime);
		
		String result = null;
		return result;//返回成功/失败信息
	}
	
	@RequestMapping("/pay")
	public String payOrder(@RequestBody ReceiveOrder param)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String gathertime = df.format(new Date());// new Date()为获取当前系统时间
		param.setGathertime(gathertime);
		param.setStatus("5");
		
		String result = null;
		return result;//返回成功/失败信息
	}
	
	@RequestMapping("/return")
	public String returnOrder(@RequestBody ReceiveOrder param){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String returntime = df.format(new Date());// new Date()为获取当前系统时间
		param.setReturntime(returntime);
		param.setStatus("6");
		
		String result = null;
		return result;//返回成功/失败信息
	}
}