//package com.software.topservice;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.software.domain.GeneralManager;
//import com.software.domain.SubBranchDetailMap;
//import com.software.service.GeneralManagerService;
//import com.software.service.StoreManagerService;
//
//@Service
//public class LoginManagerServiceImp implements LoginManagerService {
//
//	@Autowired
//	private GeneralManagerService managerService;
//	
//	@Autowired
//	private StoreManagerService storeService;
//	@Override
//	public SubBranchDetailMap login(String id, String password, String authority) 
//	{
//		if (authority.equals("general-manager")) 
//		{
//			return generalManagerLogin(id, password);
//		}
//		else if (authority.equals("shop-manager")) 
//		{
//			return null;
//		}
//		else
//		{
//			return null;
//		}
//	}
//	
//	private SubBranchDetailMap generalManagerLogin(String id, String password)
//	{
//		SubBranchDetailMap result = new SubBranchDetailMap();
//		GeneralManager exampleManager = new GeneralManager();
//		exampleManager.setId(id);
//		GeneralManager manager = managerService.selectByPrimaryKey(exampleManager);
//		if (manager==null) 
//		{
//			result.setFlag("wrongid");
//		}
//		else if(!manager.getPassword().equals("password"))
//		{
//			result.setFlag("wrongpwd");
//		}
//		else
//		{
//			
////			result.setware
////			result.setPrincipalid(id);
////			
//			result.setFlag("true");
//		}
//		return result;
//	}
//	
//	private SubBranchDetailMap storeManagerLogin(String id, String password)
//	{
//		return null;
//	}
//}
