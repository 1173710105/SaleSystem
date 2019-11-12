package com.software.dao;

import com.software.domain.new_table;

public interface new_tableMapper {
    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(new_table record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(new_table record);

    /**
     *
     * @mbg.generated
     */
    new_table selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(new_table record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(new_table record);
}