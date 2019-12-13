package com.software.topservice;

import java.util.List;

import com.software.domain.Item;

public interface ItemManagerSerivce 
{
//	public void deleteByPrimaryKey(car);

    public void insertSelective(Item record);
    
    public List<Item> select(Item record);
    
    public void updateByPrimaryKeySelective(Item record);    
    
    public List<String> typeMenu(Item record);
    
}
