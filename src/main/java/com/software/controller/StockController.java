package com.software.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.domain.GeneralManager;
import com.software.trans.Stock;

@RestController
@RequestMapping("/stock")
public class StockController {
	@RequestMapping("/queryById")
	public List<Stock> queryStockByWarehourseId(@RequestBody Stock param){
		List<Stock> result = null;
		return result;
	}
	
	
}
