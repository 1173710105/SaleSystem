package com.software.controller;

import java.util.List;

import com.software.domain.SaleorderItem;

public class SendOrder {
	private String tablename;
    /**
     * 记录订单ID ID
     */
    private Integer id;

    /**
     * 仓库（门店）ID warehourseID
     */
    private Integer warehourseid;

    /**
     * 客户ID clientID
     */
    private Integer clientid;

    /**
     * 负责人ID principalID
     */
    private String principalid;

    /**
     * 创建时间 createTime
     */
    private String createtime;

    /**
     * 审核时间 checkTime
     */
    private String checktime;

    /**
     * 收款时间 gatherTime
     */
    private String gathertime;

    /**
     * 退款时间 returnTime
     */
    private String returntime;

    /**
     * pos时间 posTime
     */
    private String postime;

    /**
     *  status
     */
    private Integer status;

    /**
     * 总价 sumPrice
     */
    private Float sumprice;

    /**
     * 收款 gather
     */
    private Float gather;

    /**
     * 找零 change
     */
    private Float change;

    /**
     * 利润 margin
     */
    private Float margin;

    /**
     * 订单类型 type
     */
    private String type;

    /**
     * 备注信息 note
     */
    private String note;

    /**
     * 异动信息 exception
     */
    private String exception;

    /**
     * 子订单列表
     */
    private List<SaleorderItem> items;
    
    public List<SaleorderItem> getItems() {
		return items;
	}

	public void setItems(List<SaleorderItem> items) {
		this.items = items;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

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

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public String getPrincipalid() {
        return principalid;
    }

    public void setPrincipalid(String principalid) {
        this.principalid = principalid == null ? null : principalid.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getChecktime() {
        return checktime;
    }

    public void setChecktime(String checktime) {
        this.checktime = checktime == null ? null : checktime.trim();
    }

    public String getGathertime() {
        return gathertime;
    }

    public void setGathertime(String gathertime) {
        this.gathertime = gathertime == null ? null : gathertime.trim();
    }

    public String getReturntime() {
        return returntime;
    }

    public void setReturntime(String returntime) {
        this.returntime = returntime == null ? null : returntime.trim();
    }

    public String getPostime() {
        return postime;
    }

    public void setPostime(String postime) {
        this.postime = postime == null ? null : postime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception == null ? null : exception.trim();
    }

	@Override
	public String toString() {
		return "SendOrder [tablename=" + tablename + ", id=" + id + ", warehourseid=" + warehourseid + ", clientid="
				+ clientid + ", principalid=" + principalid + ", createtime=" + createtime + ", checktime=" + checktime
				+ ", gathertime=" + gathertime + ", returntime=" + returntime + ", postime=" + postime + ", status="
				+ status + ", sumprice=" + sumprice + ", gather=" + gather + ", change=" + change + ", margin=" + margin
				+ ", type=" + type + ", note=" + note + ", exception=" + exception + ", items=" + items + "]";
	}
}
