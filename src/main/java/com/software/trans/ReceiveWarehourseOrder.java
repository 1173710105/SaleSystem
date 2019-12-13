package com.software.trans;

import com.software.domain.WarehourseOrderCommon;
import com.software.domain.WarehourseOrderItem;

public class ReceiveWarehourseOrder 
{
    private String id;
    private String sourceid;
    private String sourcename;
    private String targetid;
    private String targetname;
    private String principalid;
    private String principalname;
    private String type;
    private String createtime;
    private String checktime;
    private String status;
    private String ordersumprice;

    
    private String viceid;
    private String itemid;
    private String itemname;
    private String itemnum;
    private String perprice;
    private String sumprice;
	
	
	
	


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getSourceid() {
		return sourceid;
	}



	public void setSourceid(String sourceid) {
		this.sourceid = sourceid;
	}



	public String getSourcename() {
		return sourcename;
	}



	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}



	public String getTargetid() {
		return targetid;
	}



	public void setTargetid(String targetid) {
		this.targetid = targetid;
	}



	public String getTargetname() {
		return targetname;
	}



	public void setTargetname(String targetname) {
		this.targetname = targetname;
	}



	public String getPrincipalid() {
		return principalid;
	}



	public void setPrincipalid(String principalid) {
		this.principalid = principalid;
	}



	public String getPrincipalname() {
		return principalname;
	}



	public void setPrincipalname(String principalname) {
		this.principalname = principalname;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getCreatetime() {
		return createtime;
	}



	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}



	public String getChecktime() {
		return checktime;
	}



	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getOrdersumprice() {
		return ordersumprice;
	}



	public void setOrdersumprice(String ordersumprice) {
		this.ordersumprice = ordersumprice;
	}



	public String getViceid() {
		return viceid;
	}



	public void setViceid(String viceid) {
		this.viceid = viceid;
	}



	public String getItemid() {
		return itemid;
	}



	public void setItemid(String itemid) {
		this.itemid = itemid;
	}



	public String getItemname() {
		return itemname;
	}



	public void setItemname(String itemname) {
		this.itemname = itemname;
	}



	public String getItemnum() {
		return itemnum;
	}



	public void setItemnum(String itemnum) {
		this.itemnum = itemnum;
	}



	public String getPerprice() {
		return perprice;
	}



	public void setPerprice(String perprice) {
		this.perprice = perprice;
	}



	public String getSumprice() {
		return sumprice;
	}



	public void setSumprice(String sumprice) {
		this.sumprice = sumprice;
	}



	@Override
	public String toString() {
		return "ReceiveWarehourseOrder [id=" + id + ", sourceid=" + sourceid + ", sourcename=" + sourcename
				+ ", targetid=" + targetid + ", targetname=" + targetname + ", principalid=" + principalid
				+ ", principalname=" + principalname + ", type=" + type + ", createtime=" + createtime + ", checktime="
				+ checktime + ", status=" + status + ", ordersumprice=" + ordersumprice + ", viceid=" + viceid
				+ ", itemid=" + itemid + ", itemname=" + itemname + ", itemnum=" + itemnum + ", perprice=" + perprice
				+ ", sumprice=" + sumprice + "]";
	}



	public WarehourseOrderCommon toWarehourseOrderCommon(){
		WarehourseOrderCommon common = new WarehourseOrderCommon();
		common.setId(Integer.valueOf(this.getId()));
		common.setSourceid(Integer.valueOf(this.getSourceid()));
		common.setSourcename(this.getSourcename());
		common.setTargetid(Integer.valueOf(this.getTargetid()));
		common.setTargetname(this.getTargetname());
		common.setPrincipalid(this.getPrincipalid());
		common.setPrincipalname(this.getPrincipalname());
		common.setType(this.getType());
		common.setSumprice(Float.valueOf(this.getOrdersumprice()));
		common.setCreatetime(this.getCreatetime());
		common.setChecktime(this.getChecktime());
		common.setStatus(this.getStatus());
		return common;
	}
	
	public WarehourseOrderItem toWarehourseOrderItem(){
		WarehourseOrderItem item = new WarehourseOrderItem();
		item.setViceid(Integer.valueOf(this.getViceid()));
		item.setId(this.getId());
		item.setItemid(Integer.valueOf(this.getItemid()));
		item.setItemname(this.getItemname());
		item.setItemnum(Integer.valueOf(this.getItemnum()));
		item.setPerprice(Float.valueOf(this.getPerprice()));
		item.setSumprice(Float.valueOf(this.getSumprice()));
		return item;
	}
}
