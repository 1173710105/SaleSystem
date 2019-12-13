package com.software.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.domain.GeneralManager;
import com.software.domain.Staff;
import com.software.domain.StoreManager;
import com.software.domain.SubBranchDetailMap;
import com.software.service.GeneralManagerService;
import com.software.service.StaffService;
import com.software.service.StoreManagerService;
import com.software.service.SubBranchDetailMapService;

@RestController
@RequestMapping("/exam")
public class LoginController 
{
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private StoreManagerService storeManagerService;
	
	@Autowired
	private GeneralManagerService generalManagerService;
	
	@Autowired
	private SubBranchDetailMapService subBranchDetailMapService;
	
	@RequestMapping(value = {"/administrator/login","/teacher/login","/student/login"})
	public String login(@RequestBody ReceiveUser param)
	{
		String id = param.getId();
		String password = param.getPassword();
		String authority = param.getType();
		System.out.println(authority);
		if (authority.equals("general-manager")) 
		{
			GeneralManager gManager = generalManagerLogin(id, password);
			if (gManager.getId().equals("account error")) 
			{
				//登录失败
				return "wrongid";
			}
			else if (gManager.getId().equals("password error")) 
			{
				//登录失败
				return "wrongpwd";
			}
			else
			{
				return "true";
			}
		}
		else if(authority.equals("shop-manager"))
		{
			StoreManager storeManager = storeManagerLogin(id, password);
			if (storeManager.getId().equals("account error")) 
			{
				//登录失败
				return "wrongid";
			}
			else if(storeManager.getId().equals("password error")) 
			{
				return "wrongpwd";

			}
			//登录成功，获取该店长与门店之间的关系
			SubBranchDetailMap map = new SubBranchDetailMap();
			map.setPrincipalid(storeManager.getId());
			map.setLabel("valid");
			SubBranchDetailMap result = getAuthority(map);
			if (result==null) 
			{
				//"有此人，但未与门店建立关系";
				return "wrongid";
			}
			else
			{
				//将result保存到cookie中去
				return "true";
			}
		}
		else if(authority.equals("clerk"))
		{
			//将对应门店的信息保存到cookie
			Staff staff = staffLogin(id, password);
			if (staff.getId().equals("account error")) 
			{
				//登录失败
				return "wrongid";
			}
			else if(staff.getId().equals("password error"))
			{
				return "wrongpwd";
			}
			//登录成功，获取该店员与门店之间的关系
			
			SubBranchDetailMap map = new SubBranchDetailMap();
			map.setWarehourseid(staff.getHourseid());
			map.setLabel("valid");
			SubBranchDetailMap result = getAuthority(map);
			if (result==null) 
			{
				// 员工没有对应的门店
				return "wrongid";
			}
			else
			{
				//将result保存到cookie中去
				return "true";
			}
		}
		else
		{
			return "wrongid";
		}
	}
	
	private GeneralManager generalManagerLogin(String id, String password)
	{
		GeneralManager manager = new GeneralManager();
		manager.setId(id);
		GeneralManager result = generalManagerService.selectByPrimaryKey(manager);
		if (result==null) 
		{
			result = new GeneralManager();
			result.setId("account error");
			return result;
		}
		else if(!result.getPassword().equals(password))
		{
			// 密码不对
			result = new GeneralManager();
			result.setId("password error");
			return result;
		}
		else 
		{
			return result;
		}
	}
	
	private StoreManager storeManagerLogin(String id, String password) 
	{
		StoreManager storeManager = new StoreManager();
		storeManager.setId(id);
		StoreManager result = storeManagerService.selectByPrimaryKey(storeManager);
		if (result==null) 
		{
			result = new StoreManager();
			result.setId("account error");
			return result;
		}
		else if(!result.getPassword().equals(password))
		{
			// 密码不对
			result = new StoreManager();
			result.setId("password error");
			return result;
		}
		else if(result.getLabel().equals("invalid")) 
		{
			//店长无效
			result = new StoreManager();
			result.setId("account error");
			return result;
		}
		else 
		{
			return result;
		}
	}
	
	private Staff staffLogin(String id, String password) 
	{
		try 
		{
			String tablename = id.substring(1, 5);
			Staff staff = new Staff();
			staff.setId(id);
			staff.setTablename(tablename);
			
			Staff result = staffService.selectByPrimaryKey(staff);
			if (result==null) 
			{
				//在这个表中查无此人，账号不对
				result = new Staff();
				result.setId("account error");
				return result;
			}
			else if(!result.getPassword().equals(password))
			{
				//在这个表中密码不对
				result = new Staff();
				result.setId("password error");
				return result;
			}
			else if(result.getLabel().equals("invalid")) 
			{
				//在这个表中查无此人，账号不对
				result = new Staff();
				result.setId("account error");
				return result;
			}
			else 
			{
				return result;
			}
		} 
		catch (Exception e) 
		{
			// 账号不对
			return null;
		}
	}
	
	private SubBranchDetailMap getAuthority(SubBranchDetailMap map)
	{
		List<SubBranchDetailMap> maps = subBranchDetailMapService.select(map);
		if (maps.isEmpty()) 
		{
			return null;
		}
		else
		{
			return maps.get(0);
		}
	}
	

}