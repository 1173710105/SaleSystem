package com.software.topservice;

import java.util.List;

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

		// 	删除原有的映射  新店长肯定不存在原有映射
		//	SubBranchDetailMap exampleMap = new SubBranchDetailMap();
		//	exampleMap.setPrincipalid(record.getId());
		//	mapService.delete(exampleMap);
		
		// 查出门店信息
		SubBranchDetailMap exampleMap = new SubBranchDetailMap();
		exampleMap.setWarehourseid(Integer.valueOf(record.getHourseid()));
		exampleMap.setPrincipalid("-1000");
		exampleMap = mapService.select(exampleMap).get(0);
		
		// 门店 与 店长 新增映射关系
		exampleMap.setWarehourseid(Integer.valueOf(record.getHourseid()));
		exampleMap.setPrincipalid(record.getId());
		exampleMap.setPrincipalname(record.getName());
		exampleMap.setTime(record.getTime());
		
		mapService.insertSelective(exampleMap);
	}

	@Override
	public List<StoreManager> select(StoreManager record) 
	{
		List<StoreManager> resultList = managerService.select(record);
		SubBranchDetailMap exampleMap = new SubBranchDetailMap();
		SubBranchDetailMap resultMap;
		for (StoreManager storeManager : resultList) 
		{
			exampleMap.setPrincipalid(storeManager.getId());
			resultMap = mapService.select(exampleMap).get(0);  // 在insert 出保证得到唯一的门店
			storeManager.setHourseid(resultMap.getWarehourseid()+"");
			storeManager.setHoursename(resultMap.getWarehoursename());
			storeManager.setTime(resultMap.getTime());
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
	public int count()
	{
		return managerService.count();
	}
}
