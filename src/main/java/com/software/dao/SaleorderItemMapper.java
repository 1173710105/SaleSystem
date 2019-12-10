package com.software.dao;

import java.util.List;

import com.software.domain.SaleorderItem;

public interface SaleorderItemMapper 
{
    int deleteByPrimaryKey(SaleorderItem record);

    int insert(SaleorderItem record);

    int insertSelective(SaleorderItem record);

    SaleorderItem selectByPrimaryKey(SaleorderItem record);

    List<SaleorderItem> select(SaleorderItem record);
    
    int updateByPrimaryKeySelective(SaleorderItem record);

    int updateByPrimaryKey(SaleorderItem record);

    int createTable(String tablename);
}