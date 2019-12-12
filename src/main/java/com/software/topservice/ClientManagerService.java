package com.software.topservice;

import java.util.List;

import com.software.domain.Client;

public interface ClientManagerService 
{
	/**
	 * 给 客户ID
	 * @param record
	 */
	public void deleteByPrimaryKey(Client record);
    
	/**
	 * 页面填啥，你给啥
	 * @param record
	 */
    public void insertSelective(Client record);

    /**
     * 给 客户ID
     * @param record
     * @return
     */
    public Client selectByPrimaryKey(Client record);

    /**
     * 页面给啥，你填啥
     * @param record
     * @return
     */
    public List<Client> select(Client record);
    
    /**
     * 给 客户ID，页面给啥你填啥
     * @param record
     */
    public void updateByPrimaryKeySelective(Client record);

}
