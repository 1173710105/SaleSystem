package com.software.topservice;

import java.util.List;


import com.software.domain.VIPLevel;

public interface VIPLevelManagerService 
{
	public void deleteByPrimaryKey(VIPLevel record);

    public void insert(VIPLevel record);

    public void insertSelective(VIPLevel record);

    public VIPLevel selectByPrimaryKey(VIPLevel record);
    
    public List<VIPLevel> select(VIPLevel record);
    
    public void updateByPrimaryKeySelective(VIPLevel record);

    public void updateByPrimaryKey(VIPLevel record);
}
