package com.software.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.software.domain.GeneralManager;
import com.software.domain.Staff;
import com.software.domain.StoreManager;
import com.software.domain.SubBranchDetailMap;
import com.software.service.GeneralManagerService;
import com.software.service.StaffService;
import com.software.service.StoreManagerService;
import com.software.service.SubBranchDetailMapService;

@Controller
@RequestMapping("")
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
	
	public String login()
	{
		String id = "id";
		String password = "password";
		String authority = "authority";
		if (authority.equals("总经理")) 
		{
			GeneralManager gManager = generalManagerLogin(id, password);
			if (gManager==null) 
			{
				//登录失败
			}
			else
			{
				// 保存到cookie中，这一步可有可无
				SubBranchDetailMap result = new SubBranchDetailMap();
				result.setWarehoursedetailtable("base_warehourse_item");
				result.setWarehoursedetailtable("base_warehourse_detail");
			}
		}
		else if(authority.equals("店长"))
		{
			StoreManager storeManager = storeManagerLogin(id, password);
			if (storeManager==null) 
			{
				//登录失败
			}
			//登录成功，获取该店长与门店之间的关系
			SubBranchDetailMap map = new SubBranchDetailMap();
			map.setPrincipalid(storeManager.getId());
			map.setLabel("valid");
			SubBranchDetailMap result = getAuthority(map);
			if (result==null) 
			{
				//"有此人，但未与门店建立关系";
			}
			else
			{
				//将result保存到cookie中去
			}
		}
		else if(authority.equals("店员"))
		{
			//将对应门店的信息保存到cookie
			Staff staff = staffLogin(id, password);
			if (staff==null) 
			{
				//登录失败
			}
			//登录成功，获取该店员与门店之间的关系
			
			SubBranchDetailMap map = new SubBranchDetailMap();
			map.setWarehourseid(staff.getHourseid());
			map.setLabel("valid");
			SubBranchDetailMap result = getAuthority(map);
			if (result==null) 
			{
				// 员工没有对应的门店
			}
			else
			{
				//将result保存到cookie中去
			}
		}
		return null;
	}
	
	private GeneralManager generalManagerLogin(String id, String password)
	{
		GeneralManager manager = new GeneralManager();
		manager.setId(id);
		GeneralManager result = generalManagerService.selectByPrimaryKey(manager);
		if (result==null) 
		{
			//查无此人，账号不对
			return null;
		}
		else if(!result.getPassword().equals(password))
		{
			// 密码不对
			return null;
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
			//查无此人，账号不对
			return null;
		}
		else if(!result.getPassword().equals(password))
		{
			// 密码不对
			return null;
		}
		else if(result.getLabel().equals("invalid")) 
		{
			//店长无效
			return null;
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
				return null;
			}
			else if(!result.getPassword().equals(password))
			{
				//在这个表中密码不对
				return null;
			}
			else if(result.getLabel().equals("invalid")) 
			{
				//员工无效
				return null;
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
