package com.software.dao;

import java.util.List;

import com.software.domain.SaleorderCommon;

public interface SaleorderCommonMapper {
    int deleteByPrimaryKey(SaleorderCommon record);

    int insert(SaleorderCommon record);

    int insertSelective(SaleorderCommon record);

    SaleorderCommon selectByPrimaryKey(SaleorderCommon record);

    List<SaleorderCommon> select(SaleorderCommon record);

    int updateByPrimaryKeySelective(SaleorderCommon record);

    int updateByPrimaryKey(SaleorderCommon record);
    
    int createTable(String tablename);
}