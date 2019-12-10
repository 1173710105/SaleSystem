package com.software.domain;

public class SubBranchDetailMap 
{
	/**
     *  ID
     */
    private Integer id;

    /**
     * 子仓库ID warehourseID
     */
    private Integer warehourseid;

    /**
     * 子仓库负责人ID principalID
     */
    private String principalid;

    /**
     * 子仓库商品表的名称 itemTable
     */
    private String itemtable;

    /**
     * 子仓库销售表的名称 saleOrderItemTable
     */
    private String saleorderitemtable;

    /**
     *  saleOrderCommonTable
     */
    private String saleordercommontable;

    /**
     * 子仓库员工表的名称 staffTable
     */
    private String stafftable;

    /**
     * 子仓库的表的名称 warehourseDetailTable
     */
    private String warehoursedetailtable;

    /**
     *  time
     */
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWarehourseid() {
        return warehourseid;
    }

    public void setWarehourseid(Integer warehourseid) {
        this.warehourseid = warehourseid;
    }

    public String getPrincipalid() {
        return principalid;
    }

    public void setPrincipalid(String principalid) {
        this.principalid = principalid == null ? null : principalid.trim();
    }

    public String getItemtable() {
        return itemtable;
    }

    public void setItemtable(String itemtable) {
        this.itemtable = itemtable == null ? null : itemtable.trim();
    }

    public String getSaleorderitemtable() {
        return saleorderitemtable;
    }

    public void setSaleorderitemtable(String saleorderitemtable) {
        this.saleorderitemtable = saleorderitemtable == null ? null : saleorderitemtable.trim();
    }

    public String getSaleordercommontable() {
        return saleordercommontable;
    }

    public void setSaleordercommontable(String saleordercommontable) {
        this.saleordercommontable = saleordercommontable == null ? null : saleordercommontable.trim();
    }

    public String getStafftable() {
        return stafftable;
    }

    public void setStafftable(String stafftable) {
        this.stafftable = stafftable == null ? null : stafftable.trim();
    }

    public String getWarehoursedetailtable() {
        return warehoursedetailtable;
    }

    public void setWarehoursedetailtable(String warehoursedetailtable) {
        this.warehoursedetailtable = warehoursedetailtable == null ? null : warehoursedetailtable.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}