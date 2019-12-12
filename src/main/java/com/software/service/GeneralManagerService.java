package com.software.service;

import org.springframework.stereotype.Service;

import com.software.domain.GeneralManager;

public interface GeneralManagerService 
{
	public void deleteByPrimaryKey(GeneralManager record);

    public void insert(GeneralManager record);

    public void insertSelective(GeneralManager record);

    public GeneralManager selectByPrimaryKey(GeneralManager record);

    public void updateByPrimaryKeySelective(GeneralManager record);

    public void updateByPrimaryKey(GeneralManager record);
    
}
