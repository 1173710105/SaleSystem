package com.software.topservice;

import java.util.List;

import com.software.domain.Staff;
import com.software.domain.StoreManager;

public interface StaffManagerService 
{

    /**
	 * record 全部属性，包括 tablename
	 * @param record
	 */
    public void insertSelective(Staff record);

    /**
     * tablename, id
     * @param record
     * @return
     */
    public Staff selectByPrimaryKey(Staff record);

    /**
     * tablename+页给什么，填什么
     * @param record
     * @return
     */
    public List<Staff> select(Staff record);

    /** 
     * tablename + id
     * @param record
     */
    public void updateByPrimaryKeySelective(Staff record);
   
}
