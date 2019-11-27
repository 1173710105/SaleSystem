package com.software.domain;

import java.util.Date;

public class SaleOrder {
    /**
     * 订单ID orderID
     */
    private Integer orderid;

    /**
     * 订单副ID viceID
     */
    private Integer viceid;

    /**
     * 客户ID clientID
     */
    private Integer clientid;

    /**
     * 负责人ID principalID
     */
    private Integer principalid;

    /**
     * 商品数量 itemNum
     */
    private Integer itemnum;

    /**
     * 每个商品的单价 perPrice
     */
    private Float perprice;

    /**
     * 总价 sumPrice
     */
    private Float sumprice;

    /**
     * 订单毛利润 margin
     */
    private Float margin;

    /**
     * 标志是否是草稿 isScript
     */
    private Boolean isscript;

    /**
     * 标志是否已经通过审核 isCheck
     */
    private Boolean ischeck;

    /**
     * 标志是否收款 isGather
     */
    private Boolean isgather;

    /**
     * 标志是否退款 isReturn
     */
    private Boolean isreturn;

    /**
     * 草稿创建时间 createTime
     */
    private Date createtime;

    /**
     * 审核时间 checkTime
     */
    private Date checktime;

    /**
     * 收款时间 gatherTime
     */
    private Date gathertime;

    /**
     * 退款时间 returnTime
     */
    private Date returntime;

    /**
     * 标志状态 status
     */
    private Integer status;

    /**
     * 异常描述 exception
     */
    private String exception;

    /**
     * 订单备注 note
     */
    private String note;

    /**
     * 订单ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return orderID 订单ID
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * 订单ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param orderid 订单ID
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    /**
     * 订单副ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return viceID 订单副ID
     */
    public Integer getViceid() {
        return viceid;
    }

    /**
     * 订单副ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param viceid 订单副ID
     */
    public void setViceid(Integer viceid) {
        this.viceid = viceid;
    }

    /**
     * 客户ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return clientID 客户ID
     */
    public Integer getClientid() {
        return clientid;
    }

    /**
     * 客户ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param clientid 客户ID
     */
    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    /**
     * 负责人ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return principalID 负责人ID
     */
    public Integer getPrincipalid() {
        return principalid;
    }

    /**
     * 负责人ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param principalid 负责人ID
     */
    public void setPrincipalid(Integer principalid) {
        this.principalid = principalid;
    }

    /**
     * 商品数量
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return itemNum 商品数量
     */
    public Integer getItemnum() {
        return itemnum;
    }

    /**
     * 商品数量
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param itemnum 商品数量
     */
    public void setItemnum(Integer itemnum) {
        this.itemnum = itemnum;
    }

    /**
     * 每个商品的单价
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return perPrice 每个商品的单价
     */
    public Float getPerprice() {
        return perprice;
    }

    /**
     * 每个商品的单价
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param perprice 每个商品的单价
     */
    public void setPerprice(Float perprice) {
        this.perprice = perprice;
    }

    /**
     * 总价
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return sumPrice 总价
     */
    public Float getSumprice() {
        return sumprice;
    }

    /**
     * 总价
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param sumprice 总价
     */
    public void setSumprice(Float sumprice) {
        this.sumprice = sumprice;
    }

    /**
     * 订单毛利润
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return margin 订单毛利润
     */
    public Float getMargin() {
        return margin;
    }

    /**
     * 订单毛利润
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param margin 订单毛利润
     */
    public void setMargin(Float margin) {
        this.margin = margin;
    }

    /**
     * 标志是否是草稿
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return isScript 标志是否是草稿
     */
    public Boolean getIsscript() {
        return isscript;
    }

    /**
     * 标志是否是草稿
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param isscript 标志是否是草稿
     */
    public void setIsscript(Boolean isscript) {
        this.isscript = isscript;
    }

    /**
     * 标志是否已经通过审核
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return isCheck 标志是否已经通过审核
     */
    public Boolean getIscheck() {
        return ischeck;
    }

    /**
     * 标志是否已经通过审核
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param ischeck 标志是否已经通过审核
     */
    public void setIscheck(Boolean ischeck) {
        this.ischeck = ischeck;
    }

    /**
     * 标志是否收款
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return isGather 标志是否收款
     */
    public Boolean getIsgather() {
        return isgather;
    }

    /**
     * 标志是否收款
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param isgather 标志是否收款
     */
    public void setIsgather(Boolean isgather) {
        this.isgather = isgather;
    }

    /**
     * 标志是否退款
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return isReturn 标志是否退款
     */
    public Boolean getIsreturn() {
        return isreturn;
    }

    /**
     * 标志是否退款
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param isreturn 标志是否退款
     */
    public void setIsreturn(Boolean isreturn) {
        this.isreturn = isreturn;
    }

    /**
     * 草稿创建时间
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return createTime 草稿创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 草稿创建时间
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param createtime 草稿创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 审核时间
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return checkTime 审核时间
     */
    public Date getChecktime() {
        return checktime;
    }

    /**
     * 审核时间
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param checktime 审核时间
     */
    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    /**
     * 收款时间
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return gatherTime 收款时间
     */
    public Date getGathertime() {
        return gathertime;
    }

    /**
     * 收款时间
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param gathertime 收款时间
     */
    public void setGathertime(Date gathertime) {
        this.gathertime = gathertime;
    }

    /**
     * 退款时间
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return returnTime 退款时间
     */
    public Date getReturntime() {
        return returntime;
    }

    /**
     * 退款时间
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param returntime 退款时间
     */
    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }

    /**
     * 标志状态
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return status 标志状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 标志状态
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param status 标志状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 异常描述
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return exception 异常描述
     */
    public String getException() {
        return exception;
    }

    /**
     * 异常描述
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param exception 异常描述
     */
    public void setException(String exception) {
        this.exception = exception == null ? null : exception.trim();
    }

    /**
     * 订单备注
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return note 订单备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 订单备注
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param note 订单备注
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}