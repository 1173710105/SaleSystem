package com.software.dao;

import java.util.List;

import com.software.domain.Warehourse;

public interface WarehourseMapper {
    int deleteByPrimaryKey(Warehourse record);

    int insert(Warehourse record);

    int insertSelective(Warehourse record);

    Warehourse selectByPrimaryKey(Warehourse record);

    List<Warehourse> select(Warehourse record);

    int updateByPrimaryKeySelective(Warehourse record);

    int updateByPrimaryKey(Warehourse record);
}