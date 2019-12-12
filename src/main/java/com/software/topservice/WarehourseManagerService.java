package com.software.topservice;

import java.util.List;

import com.software.domain.SubBranchDetailMap;


public interface WarehourseManagerService 
{
	/**
	 * 	name  
	 * 	location  
	 *	principalID principalName
	 */
	public String addWarehourse(SubBranchDetailMap record);

	/**
	 *  hourseid, principalid
	 */
	public String deleteWarehourse(SubBranchDetailMap record);
	
	/**
	 * 页面填什么就写什么
	 * 
	 */
	public List<SubBranchDetailMap> select(SubBranchDetailMap record);
	
	/**
	 * 
	 * @param record
	 * @return
	 */
	public SubBranchDetailMap selectByPrimaryKey(SubBranchDetailMap record);
	
	/**
	 * name  
	 * 	location  
	 *	principalID principalName
	 * @param record
	 */
	public void updateByPrimaryKey(SubBranchDetailMap record);
	
	/**
	 * 无参数
	 * @return
	 */
	public List<String> hourseMenu();

}
