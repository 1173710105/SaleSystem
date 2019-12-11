package com.software.domain;

public class WarehourseOrderCommon {
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
        this.senderprincipalid = senderprincipalid == null ? null : senderprincipalid.trim();
    }

    public String getReceiverprincipalid() {
        return receiverprincipalid;
    }

    public void setReceiverprincipalid(String receiverprincipalid) {
        this.receiverprincipalid = receiverprincipalid == null ? null : receiverprincipalid.trim();
    }

    public String getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(String sourcetype) {
        this.sourcetype = sourcetype == null ? null : sourcetype.trim();
    }

    public String getTargettype() {
        return targettype;
    }

    public void setTargettype(String targettype) {
        this.targettype = targettype == null ? null : targettype.trim();
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
        this.pricetype = pricetype == null ? null : pricetype.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}