package com.software.trans;

import java.util.List;

public class ReceiveOrder 
{
	private String tablename;
	private String orderid;
	private String viceid;
	private String warehourseid;
	private String warehoursename;
	private String clientid;
	private String clientname;
	private String principalid;
	private String principalname;
	private String itemid;
	private String itemnum;
	private String perprice;
	private String sumprice;
	private String gather;
	private String change;
	private Float margin;
	private String createtime;
	private String checktime;
	private String gathertime;
	private String returntime;
	private String postime;
	private Integer status;
	private String type;
	private String exception;
	private String note;
	
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getViceid() {
		return viceid;
	}
	public void setViceid(Integer viceid) {
		this.viceid = viceid;
	}
	public Integer getWarehourseid() {
		return warehourseid;
	}
	public void setWarehourseid(Integer warehourseid) {
		this.warehourseid = warehourseid;
	}
	public Integer getClientid() {
		return clientid;
	}
	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}
	public Integer getPrincipalid() {
		return principalid;
	}
	public void setPrincipalid(Integer principalid) {
		this.principalid = principalid;
	}
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
	public Float getPerprice() {
		return perprice;
	}
	public void setPerprice(Float perprice) {
		this.perprice = perprice;
	}
	public Float getSumprice() {
		return sumprice;
	}
	public void setSumprice(Float sumprice) {
		this.sumprice = sumprice;
	}
	public Float getGather() {
		return gather;
	}
	public void setGather(Float gather) {
		this.gather = gather;
	}
	public Float getChange() {
		return change;
	}
	public void setChange(Float change) {
		this.change = change;
	}
	public Float getMargin() {
		return margin;
	}
	public void setMargin(Float margin) {
		this.margin = margin;
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
	public String getGathertime() {
		return gathertime;
	}
	public void setGathertime(String gathertime) {
		this.gathertime = gathertime;
	}
	public String getReturntime() {
		return returntime;
	}
	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}
	public String getPostime() {
		return postime;
	}
	public void setPostime(String postime) {
		this.postime = postime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "RecieveOrder [orderid=" + orderid + ", viceid=" + viceid + ", warehourseid=" + warehourseid
				+ ", clientid=" + clientid + ", principalid=" + principalid + ", itemid=" + itemid + ", itemnum="
				+ itemnum + ", perprice=" + perprice + ", sumprice=" + sumprice + ", gather=" + gather + ", change="
				+ change + ", margin=" + margin + ", createtime=" + createtime + ", checktime=" + checktime
				+ ", gathertime=" + gathertime + ", returntime=" + returntime + ", postime=" + postime + ", status="
				+ status + ", type=" + type + ", exception=" + exception + ", note=" + note + "]";
	}
	
    
}
