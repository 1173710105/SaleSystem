package com.software.domain;

public class WarehourseOrder {
    /**
     * 订单主ID orderID
     */
    private Integer orderid;

    /**
     * 订单副ID viceOrderID
     */
    private Integer viceorderid;

    /**
     * 货源地ID sourceID
     */
    private Integer sourceid;

    /**
     * 目的地ID targerID
     */
    private Integer targerid;

    /**
     * 负责人ID principalID
     */
    private Integer principalid;

    /**
     * 商品数量ID itemID
     */
    private Integer itemid;

    /**
     * 商品数量 itemNum
     */
    private Integer itemnum;

    /**
     * 商品每一个价格 perPrice
     */
    private Float perprice;

    /**
     * 商品总价 sumPrice
     */
    private Float sumprice;

    /**
     * 商品价格类型 priceType
     */
    private String pricetype;

    /**
     * 商品货源类型 sourceType
     */
    private String sourcetype;

    /**
     * 订单主ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return orderID 订单主ID
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * 订单主ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param orderid 订单主ID
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    /**
     * 订单副ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return viceOrderID 订单副ID
     */
    public Integer getViceorderid() {
        return viceorderid;
    }

    /**
     * 订单副ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param viceorderid 订单副ID
     */
    public void setViceorderid(Integer viceorderid) {
        this.viceorderid = viceorderid;
    }

    /**
     * 货源地ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return sourceID 货源地ID
     */
    public Integer getSourceid() {
        return sourceid;
    }

    /**
     * 货源地ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param sourceid 货源地ID
     */
    public void setSourceid(Integer sourceid) {
        this.sourceid = sourceid;
    }

    /**
     * 目的地ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return targerID 目的地ID
     */
    public Integer getTargerid() {
        return targerid;
    }

    /**
     * 目的地ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param targerid 目的地ID
     */
    public void setTargerid(Integer targerid) {
        this.targerid = targerid;
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
     * 商品数量ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return itemID 商品数量ID
     */
    public Integer getItemid() {
        return itemid;
    }

    /**
     * 商品数量ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param itemid 商品数量ID
     */
    public void setItemid(Integer itemid) {
        this.itemid = itemid;
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
     * 商品每一个价格
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return perPrice 商品每一个价格
     */
    public Float getPerprice() {
        return perprice;
    }

    /**
     * 商品每一个价格
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param perprice 商品每一个价格
     */
    public void setPerprice(Float perprice) {
        this.perprice = perprice;
    }

    /**
     * 商品总价
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return sumPrice 商品总价
     */
    public Float getSumprice() {
        return sumprice;
    }

    /**
     * 商品总价
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param sumprice 商品总价
     */
    public void setSumprice(Float sumprice) {
        this.sumprice = sumprice;
    }

    /**
     * 商品价格类型
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return priceType 商品价格类型
     */
    public String getPricetype() {
        return pricetype;
    }

    /**
     * 商品价格类型
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param pricetype 商品价格类型
     */
    public void setPricetype(String pricetype) {
        this.pricetype = pricetype == null ? null : pricetype.trim();
    }

    /**
     * 商品货源类型
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return sourceType 商品货源类型
     */
    public String getSourcetype() {
        return sourcetype;
    }

    /**
     * 商品货源类型
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param sourcetype 商品货源类型
     */
    public void setSourcetype(String sourcetype) {
        this.sourcetype = sourcetype == null ? null : sourcetype.trim();
    }
}