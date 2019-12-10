package com.software.dao;

import com.software.domain.Staff;

public interface StaffMapper {
    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(Staff record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Staff record);

    /**
     *
     * @mbg.generated
     */
    Staff selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Staff record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Staff record);
}