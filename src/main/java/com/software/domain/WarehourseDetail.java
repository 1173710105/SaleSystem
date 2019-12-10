package com.software.domain;

public class WarehourseDetail 
{
	
	private String tablename;
    /**
     * 物品ID itemID
     */
    private Integer itemid;

    
    public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
     * 物品数量 itemNum
     */
    private Integer itemnum;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getItemnum() {
        return itemnum;
    }

    public void setItemnum(Integer itemnum) {
        this.itemnum = itemnum;
    }

	@Override
	public String toString() {
		return "WarehourseDetail [tablename=" + tablename + ", itemid=" + itemid + ", itemnum=" + itemnum + "]";
	}
    
}