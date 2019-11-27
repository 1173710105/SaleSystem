package com.software.dao;

import com.software.domain.PosOrder;

public interface PosOrderMapper {
    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer saleorderid);

    /**
     *
     * @mbg.generated
     */
    int insert(PosOrder record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(PosOrder record);

    /**
     *
     * @mbg.generated
     */
    PosOrder selectByPrimaryKey(Integer saleorderid);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PosOrder record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PosOrder record);
}