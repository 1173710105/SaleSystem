package com.software.dao;

import java.util.List;

import com.software.domain.WarehourseOrderCommon;

public interface WarehourseOrderCommonMapper {
    int deleteByPrimaryKey(WarehourseOrderCommon record);

    int insert(WarehourseOrderCommon record);

    int insertSelective(WarehourseOrderCommon record);

    WarehourseOrderCommon selectByPrimaryKey(WarehourseOrderCommon record);

    List<WarehourseOrderCommon> select(WarehourseOrderCommon record);

    int updateByPrimaryKeySelective(WarehourseOrderCommon record);

    int updateByPrimaryKey(WarehourseOrderCommon record);
}