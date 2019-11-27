package com.software.dao;

import com.software.domain.SaleOrder;

public interface SaleOrderMapper {
    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer orderid);

    /**
     *
     * @mbg.generated
     */
    int insert(SaleOrder record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SaleOrder record);

    /**
     *
     * @mbg.generated
     */
    SaleOrder selectByPrimaryKey(Integer orderid);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SaleOrder record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SaleOrder record);
}