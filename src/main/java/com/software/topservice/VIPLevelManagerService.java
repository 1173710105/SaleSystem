package com.software.topservice;

import java.util.List;
import java.util.Map;

import com.software.domain.VIPLevel;

public interface VIPLevelManagerService 
{

    public List<VIPLevel> select(VIPLevel record);
    
    public void updateByPrimaryKey(VIPLevel record);
    
    public Map<Integer, String> vipMenu();
}
