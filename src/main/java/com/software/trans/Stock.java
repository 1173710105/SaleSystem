package com.software.trans;

public class Stock {
	private String tablename;
    private String itemid;
    private String itemnum;
    private String time;
    private String id;
    private String name;
    private String type;
    private String specification;
    private String picture;
    private String label;
    private String hourseid;
    private String afterstock;
    
    
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getItemnum() {
		return itemnum;
	}
	public void setItemnum(String itemnum) {
		this.itemnum = itemnum;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getHourseid() {
		return hourseid;
	}
	public void setHourseid(String hourseid) {
		this.hourseid = hourseid;
	}
	public String getAfterstock() {
		return afterstock;
	}
	public void setAfterstock(String afterstock) {
		this.afterstock = afterstock;
	}
	@Override
	public String toString() {
		return "SendStock [tablename=" + tablename + ", itemid=" + itemid + ", itemnum=" + itemnum + ", time=" + time
				+ ", id=" + id + ", name=" + name + ", type=" + type + ", specification=" + specification + ", picture="
				+ picture + ", label=" + label + ", hourseid=" + hourseid + ", afterstock=" + afterstock + "]";
	}
    
    
	
	
	
}
