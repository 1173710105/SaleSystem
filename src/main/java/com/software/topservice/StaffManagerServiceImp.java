package com.software.topservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.sym.Name;
import com.software.domain.Staff;
import com.software.domain.StoreManager;
import com.software.domain.Warehourse;
import com.software.service.StaffService;
import com.software.service.WarehourseService;

@Service
public class StaffManagerServiceImp implements StaffManagerService 
{
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private WarehourseService hourseService;
	
	@Override
	public void insertSelective(Staff record)
	{
		record.filltablename();
		
		staffService.insertSelective(record);
	}

	@Override
	public Staff selectByPrimaryKey(Staff record) 
	{
		record.filltablename();
		Staff staff = staffService.selectByPrimaryKey(record);
		return staff;
	}

	@Override
	public List<Staff> select(Staff record) 
	{
		record.filltablename();
		List<Staff> result = staffService.select(record);
		
		/**
		Warehourse hourse = new Warehourse();
		Map<Integer, String> idToName = new HashMap<Integer, String>();
		for (Staff staff : result) 
		{
			if (idToName.keySet().contains(staff.getHourseid())) 
			{
				staff.setHoursename(idToName.get(staff.getHourseid()));
			}
			else 
			{
				hourse.setId(Integer.valueOf(staff.getId()));
				staff.setHoursename(hourseService.selectByPrimaryKey(hourse).getName());
				idToName.put(hourse.getId(), staff.getHoursename());
			}
		}
		*/
		return result;
	}

	@Override
	public void updateByPrimaryKeySelective(Staff record) 
	{
		record.filltablename();
		staffService.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public int count(Staff record)
	{
		return staffService.count(record);
	}
}
