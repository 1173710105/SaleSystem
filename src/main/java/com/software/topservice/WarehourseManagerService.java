package com.software.topservice;

import java.util.List;

import com.software.domain.Warehourse;

public interface WarehourseManagerService 
{
	public void deleteByPrimaryKey(Warehourse record);
    
	public void insertSelective(Warehourse record);

	public Warehourse selectByPrimaryKey(Warehourse record);

    public List<Warehourse> select(Warehourse record);
    
    public void updateByPrimaryKeySelective(Warehourse record);

    public void updateByPrimaryKey(Warehourse record);
}
