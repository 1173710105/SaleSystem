package com.software.dao;

import java.util.List;

import com.software.domain.SubBranchDetailMap;

public interface SubBranchDetailMapMapper 
{
	int deleteByPrimaryKey(SubBranchDetailMap record);

    int insert(SubBranchDetailMap record);

    int insertSelective(SubBranchDetailMap record);

    SubBranchDetailMap selectByPrimaryKey(SubBranchDetailMap record);

    List<SubBranchDetailMap> select(SubBranchDetailMap record);
  
    int updateByPrimaryKeySelective(SubBranchDetailMap record);

    int updateByPrimaryKey(SubBranchDetailMap record);
}