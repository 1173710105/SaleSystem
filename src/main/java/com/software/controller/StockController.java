package com.software.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.domain.GeneralManager;
import com.software.topservice.StockManagerService;
import com.software.trans.Stock;

@RestController
@RequestMapping("/stock")
public class StockController 
{
	@Autowired
	private StockManagerService service;
	
	@RequestMapping("/queryById")
	public List<Stock> queryStockByWarehourseId(@RequestBody Stock param)
	{
		List<Stock> result = service.select(param);
		return result;
	}
	
	@RequestMapping("/query")
	public List<Stock> queryStock(@RequestBody Stock param){
		List<Stock> result = service.select(param);
		return result;
	}
	
	@RequestMapping("/update")
	public Map<String, String> updateStock(@RequestBody List<Stock> param)
	{
		System.out.println(param.get(0).toString());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		for(Stock s: param){
			s.setTime(time);
		}
		service.update(param);
		Map<String,String> result = new HashMap<String,String>();
		result.put("info", "更新成功");
		return result;
	}
}
