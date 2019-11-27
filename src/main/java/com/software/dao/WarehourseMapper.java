package com.software.dao;

import com.software.domain.Warehourse;

public interface WarehourseMapper {
    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(Warehourse record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Warehourse record);

    /**
     *
     * @mbg.generated
     */
    Warehourse selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Warehourse record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Warehourse record);
}