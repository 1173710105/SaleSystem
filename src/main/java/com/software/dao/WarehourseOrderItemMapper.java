package com.software.dao;

import java.util.List;

import com.software.domain.WarehourseOrderItem;

public interface WarehourseOrderItemMapper 
{
    int deleteByPrimaryKey(WarehourseOrderItem record);

    int insert(WarehourseOrderItem record);

    int insertSelective(WarehourseOrderItem record);

    WarehourseOrderItem selectByPrimaryKey(WarehourseOrderItem record);

    List<WarehourseOrderItem> select(WarehourseOrderItem record);
    
    int updateByPrimaryKeySelective(WarehourseOrderItem record);

    int updateByPrimaryKey(WarehourseOrderItem record);
}