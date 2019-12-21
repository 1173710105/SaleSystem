package com.software.topservice;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.StoreManager;
import com.software.domain.SubBranchDetailMap;
import com.software.service.StoreManagerService;
import com.software.service.SubBranchDetailMapService;

@Service
public class TopStoreManagerServiceImp implements TopStoreManagerService 
{
	@Autowired
	private StoreManagerService managerService;
	
	@Autowired
	private SubBranchDetailMapService mapService;
	
	@Override
	public void insertSelective(StoreManager record) 
	{
		managerService.insertSelective(record);
	}

	@Override
	public List<StoreManager> select(StoreManager record) 
	{
		List<StoreManager> resultList = managerService.select(record);
		SubBranchDetailMap exampleMap = new SubBranchDetailMap();
		List<SubBranchDetailMap> resultMap;
		for (StoreManager storeManager : resultList) 
		{
			exampleMap.setPrincipalid(storeManager.getId());
			resultMap = mapService.select(exampleMap);
			if (resultMap.size()==0) 
			{
				storeManager.setHourseid("");
				storeManager.setHoursename("");
				storeManager.setTime("");
			}
			else
			{
				exampleMap = resultMap.get(0);
				storeManager.setHourseid(exampleMap.getWarehourseid()+"");
				storeManager.setHoursename(exampleMap.getWarehoursename());
				storeManager.setTime(exampleMap.getTime());
			}
		}
		return resultList;
	}

	@Override
	public void updateByPrimaryKeySelective(StoreManager record) 
	{
		managerService.updateByPrimaryKeySelective(record);
		SubBranchDetailMap exampleMap = new SubBranchDetailMap();
		exampleMap.setPrincipalid(record.getId());
		exampleMap.setWarehourseid(Integer.valueOf(record.getHourseid()));
		exampleMap.setLabel(record.getLabel());
		mapService.updateByHourseID(exampleMap);
	}

	@Override
	public String assign(StoreManager record)
	{
		// 查出门店信息
		SubBranchDetailMap exampleMap = new SubBranchDetailMap();
		exampleMap.setWarehourseid(Integer.valueOf(record.getHourseid()));
		exampleMap.setLabel("valid");
		exampleMap = mapService.select(exampleMap).get(0);
		if (exampleMap.getPrincipalid().equals(record.getId())) 
		{
			// 已经任命成功了
			return "任命成功";
		}
		else if (exampleMap.getPrincipalid().equals("")) 
		{
			
			SubBranchDetailMap tempMap = new SubBranchDetailMap();
			tempMap.setPrincipalid(record.getId());
			List<SubBranchDetailMap> reusltMap = mapService.select(tempMap);
			if (reusltMap.size()==1) 
			{
				// 取消已经任命的关系
				tempMap.setPrincipalid("");
				tempMap.setPrincipalname("");
				tempMap.setTime(record.getTime());
				tempMap.setLabel("valid");
				mapService.updateByPrimaryKeySelective(tempMap);
			}
			
			// 该门店还尚且未任命
			// 门店 与 店长 新增映射关系
			exampleMap.setPrincipalid(record.getId());
			exampleMap.setPrincipalname(record.getName());
			exampleMap.setTime(record.getTime());
			exampleMap.setLabel("valid");
			mapService.updateByPrimaryKeySelective(exampleMap);
			return "任命成功";
		}
		else
		{
			return "该门店已经存在店长，任命失败";
		}
		
	}
	
	@Override
	public int count()
	{
		return managerService.count();
	}
	
	
}
