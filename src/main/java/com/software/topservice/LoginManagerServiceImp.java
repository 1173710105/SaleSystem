package com.software.topservice;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.GeneralManager;
import com.software.domain.Staff;
import com.software.domain.StoreManager;
import com.software.domain.SubBranchDetailMap;
import com.software.service.GeneralManagerService;
import com.software.service.StaffService;
import com.software.service.StoreManagerService;
import com.software.service.SubBranchDetailMapService;

@Service
public class LoginManagerServiceImp implements LoginManagerService 
{
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private StoreManagerService storeManagerService;
	
	@Autowired
	private GeneralManagerService generalManagerService;
	
	@Autowired
	private SubBranchDetailMapService subBranchDetailMapService;
	
	@Override
	public SubBranchDetailMap login(String id, String password, String authority) 
	{
		SubBranchDetailMap map = new SubBranchDetailMap();
		map.setFlag("success");
		if (authority.equals("总经理")) 
		{
			GeneralManager gManager = generalManagerLogin(id, password, map);
			if (gManager==null) 
			{
				//登录失败
				return map;
			}
			else
			{
				//登录成功，建立映射关系
				map.setItemtable("base_warehourse_item");
				map.setWarehoursedetailtable("base_warehourse_detail");
				return map;
			}
		}
		else if(authority.equals("店长"))
		{
			StoreManager storeManager = storeManagerLogin(id, password, map);
			if (storeManager==null) 
			{
				//登录失败
				return map;
			}
			//登录成功，获取该店长与门店之间的关系
			map.setPrincipalid(storeManager.getId());
			map.setLabel("valid");
			SubBranchDetailMap result = getAuthority(map);
			if (result==null) 
			{
				//"有此人，但未与门店建立关系";
				map.setFlag("authority errror");
				return map;
			}
			else
			{
				//将result保存到cookie中去
				result.setFlag("success");
				return result;
			}
		}
		else if(authority.equals("店员"))
		{
			Staff staff = staffLogin(id, password, map);
			if (staff==null) 
			{
				//登录失败
				return map;
			}
			//登录成功，获取该店员与门店之间的关系
			
			map.setWarehourseid(staff.getHourseid());
			map.setLabel("valid");
			SubBranchDetailMap result = getAuthority(map);
			if (result==null) 
			{
				// 员工没有对应的门店
				map.setFlag("authority errror");
				return map;
			}
			else
			{
				//将result保存到cookie中去
				result.setFlag("success");
				return result;
			}
		}
		
		return null;
	}

	private GeneralManager generalManagerLogin(String id, String password, SubBranchDetailMap map)
	{
		GeneralManager manager = new GeneralManager();
		manager.setId(id);
		GeneralManager result = generalManagerService.selectByPrimaryKey(manager);
		if (result==null) 
		{
			//查无此人，账号不对
			map.setFlag("account error");
			return null;
		}
		else if(!result.getPassword().equals(password))
		{
			// 密码不对
			map.setFlag("password error");
			return null;
		}
		else 
		{
			return result;
		}
	}
	
	private StoreManager storeManagerLogin(String id, String password, SubBranchDetailMap map) 
	{
		StoreManager storeManager = new StoreManager();
		storeManager.setId(id);
		StoreManager result = storeManagerService.selectByPrimaryKey(storeManager);
		if (result==null) 
		{
			//查无此人，账号不对
			map.setFlag("account error");
			return null;
		}
		else if(!result.getPassword().equals(password))
		{
			// 密码不对
			map.setFlag("password error");
			return null;
		}
		else if(result.getLabel().equals("invalid")) 
		{
			//店长无效
			map.setFlag("account error");
			return null;
		}
		else 
		{
			return result;
		}
	}
	
	private Staff staffLogin(String id, String password, SubBranchDetailMap map) 
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
				map.setFlag("account error");
				return null;
			}
			else if(!result.getPassword().equals(password))
			{
				//在这个表中密码不对
				map.setFlag("password error");
				return null;
			}
			else if(result.getLabel().equals("invalid")) 
			{
				//员工无效
				map.setFlag("account error");
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
			map.setFlag("account error");
			System.out.println("表名错误");
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