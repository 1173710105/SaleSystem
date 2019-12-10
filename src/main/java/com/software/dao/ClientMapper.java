package com.software.dao;

import com.software.domain.Client;

public interface ClientMapper {
    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(Client record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Client record);

    /**
     *
     * @mbg.generated
     */
    Client selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Client record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Client record);
}