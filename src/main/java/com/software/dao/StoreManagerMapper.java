package com.software.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.software.domain.StoreManager;

@Mapper
public interface StoreManagerMapper {
    int deleteByPrimaryKey(StoreManager record);

    int insert(StoreManager record);

    int insertSelective(StoreManager record);

    StoreManager selectByPrimaryKey(StoreManager record);

    List<StoreManager> select(StoreManager record);
    
    int updateByPrimaryKeySelective(StoreManager record);

    int updateByPrimaryKey(StoreManager record);
}