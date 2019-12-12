package com.software.topservice;

import java.util.List;

import com.software.domain.Staff;
import com.software.domain.StoreManager;

public interface StoreAndStaffManagerService 
{
	public void StaffDeleteByPrimaryKey(Staff record);

    public void StaffInsert(Staff record);

    public void StaffInsertSelective(Staff record);

    public Staff StaffSelectByPrimaryKey(Staff record);

    public List<Staff> StaffSelect(Staff record);

    public void StaffUpdateByPrimaryKeySelective(Staff record);

    public void StaffUpdateByPrimaryKey(Staff record);
    
    
    
	public void StoreDeleteByPrimaryKey(StoreManager record);
	
	public void StoreInsert(StoreManager record);
	
	public void StoreInsertSelective(StoreManager record);
	
	public StoreManager StoreSelectByPrimaryKey(StoreManager record);
	
	public List<StoreManager> StoreSelect(StoreManager record);
	
	public void StoreUpdateByPrimaryKeySelective(StoreManager record);
	
	public void StoreUpdateByPrimaryKey(StoreManager record);
}
