package com.software.topservice;

import java.util.List;

import com.software.domain.StoreManager;

public interface TopStoreManagerService 
{
	/**
	 * StoreManager 全部属性
	 * @param record
	 */
    public void insertSelective(StoreManager record);

    /**
     * id
     * @param record
     * @return
     */
    public StoreManager selectByPrimaryKey(StoreManager record);

    /**
     * 网页给什么，填什么
     * @param record
     * @return
     */
    public List<StoreManager> select(StoreManager record);

    /** 
     *  id
     * @param record
     */
    public void updateByPrimaryKeySelective(StoreManager record);
}
