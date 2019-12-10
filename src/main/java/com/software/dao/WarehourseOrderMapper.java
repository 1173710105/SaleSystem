package com.software.dao;

import com.software.domain.WarehourseOrder;

public interface WarehourseOrderMapper {
    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer orderid);

    /**
     *
     * @mbg.generated
     */
    int insert(WarehourseOrder record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(WarehourseOrder record);

    /**
     *
     * @mbg.generated
     */
    WarehourseOrder selectByPrimaryKey(Integer orderid);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(WarehourseOrder record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(WarehourseOrder record);
}