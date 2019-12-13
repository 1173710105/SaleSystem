package com.software.trans;

import java.util.List;

import com.software.domain.WarehourseOrderItem;

public class SendWarehourseOrder {
	/**
     * 查看表ID ID
     */
    private Integer id;

    /**
     * 货源地ID sourceID
     */
    private Integer sourceid;

    /**
     * 目的地ID targetID
     */
    private Integer targetid;

    /**
     * 发起人ID senderPrincipalID
     */
    private String senderprincipalid;

    /**
     * 接受人ID receiverPrincipalID
     */
    private String receiverprincipalid;

    /**
     * 货品货源地类型 sourceType
     */
    private String sourcetype;

    /**
     * 货品目的地类型 targetType
     */
    private String targettype;

    /**
     * 总价 sumPrice
     */
    private Float sumprice;

    /**
     * 价格类型 priceType
     */
    private String pricetype;

    /**
     * 创建时间 createTime
     */
    private String createtime;

    /**
     * 审核时间 checkTime
     */
    private String checktime;

    /**
     * 记录销售单状态 status
     */
    private String status;
    
    /**
     * 货单货品列表
     */
    private List<WarehourseOrderItem> items;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSourceid() {
		return sourceid;
	}

	public void setSourceid(Integer sourceid) {
		this.sourceid = sourceid;
	}

	public Integer getTargetid() {
		return targetid;
	}

	public void setTargetid(Integer targetid) {
		this.targetid = targetid;
	}

	public String getSenderprincipalid() {
		return senderprincipalid;
	}

	public void setSenderprincipalid(String senderprincipalid) {
		this.senderprincipalid = senderprincipalid;
	}

	public String getReceiverprincipalid() {
		return receiverprincipalid;
	}

	public void setReceiverprincipalid(String receiverprincipalid) {
		this.receiverprincipalid = receiverprincipalid;
	}

	public String getSourcetype() {
		return sourcetype;
	}

	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}

	public String getTargettype() {
		return targettype;
	}

	public void setTargettype(String targettype) {
		this.targettype = targettype;
	}

	public Float getSumprice() {
		return sumprice;
	}

	public void setSumprice(Float sumprice) {
		this.sumprice = sumprice;
	}

	public String getPricetype() {
		return pricetype;
	}

	public void setPricetype(String pricetype) {
		this.pricetype = pricetype;
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

	public List<WarehourseOrderItem> getItems() {
		return items;
	}

	public void setItems(List<WarehourseOrderItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "SendWarehourseOrder [id=" + id + ", sourceid=" + sourceid + ", targetid=" + targetid
				+ ", senderprincipalid=" + senderprincipalid + ", receiverprincipalid=" + receiverprincipalid
				+ ", sourcetype=" + sourcetype + ", targettype=" + targettype + ", sumprice=" + sumprice
				+ ", pricetype=" + pricetype + ", createtime=" + createtime + ", checktime=" + checktime + ", status="
				+ status + ", items=" + items + "]";
	}
    
    
}
