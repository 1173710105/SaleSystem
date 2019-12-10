package com.software.dao;

import com.software.domain.WarehourseDetail;

public interface WarehourseDetailMapper {
    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer warehourseid);

    /**
     *
     * @mbg.generated
     */
    int insert(WarehourseDetail record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(WarehourseDetail record);

    /**
     *
     * @mbg.generated
     */
    WarehourseDetail selectByPrimaryKey(Integer warehourseid);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(WarehourseDetail record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(WarehourseDetail record);
}