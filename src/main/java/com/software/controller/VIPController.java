package com.software.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.domain.Client;
import com.software.domain.VIPLevel;
import com.software.topservice.ClientManagerService;
import com.software.topservice.VIPLevelManagerService;

@RestController
@RequestMapping("/vip")
public class VIPController {

	@Autowired
	private VIPLevelManagerService vipService;
	
	@Autowired
	private ClientManagerService clientService;
	
	@RequestMapping("/updatevip")
	public Map<String, String> updatevip()
	{
		Map<String, String> result = new HashMap<String, String>();
		try
		{
			Integer vipid = Integer.valueOf("");
			String vipname = "";
			Float pointtoprice = Float.valueOf("");
			Float pricetopoint = Float.valueOf("");
			if (pointtoprice<0) 
			{
				result.put("info", "积分兑换系数不正确");
				return result;
			}
			if (pricetopoint<0) 
			{
				result.put("info", "金额兑换系数不正确");
				return result;
			}
			VIPLevel vipLevel = new VIPLevel();
			vipLevel.setId(vipid);
			vipLevel.setVipname(vipname);
			vipLevel.setPointtoprice(pointtoprice);
			vipLevel.setPricetopoint(pricetopoint);
			vipService.updateByPrimaryKey(vipLevel);
			result.put("info", "更新成功");
			return result;
		}
		catch (Exception e) 
		{
			result.put("info", "请输入正确的数字");
			return result;
		}
	}
	
	@RequestMapping("/cancel")
	public Map<String, String> cancelAuthority()
	{
		Client client = new Client();
		client.setId(111);
		client.setAuthority("-1");
		clientService.updateByPrimaryKeySelective(client);
		Map<String, String> result = new HashMap<String, String>();
		result.put("info", "取消成功");
		return result;
	}

	@RequestMapping("/updateclient")
	public Map<String, String> updateclient()
	{
		String clientid ="";
		String vipid = "";
		vipService.updateclient(clientid, vipid);
		Map<String, String> result = new HashMap<String, String>();
		result.put("info", "更新成功");
		return result;
	}
	
	@RequestMapping("/menu")
	public Map<Integer, VIPLevel> vipMenu()
	{
		return vipService.vipMenu();
	}
}
