package com.software.domain;

public class WarehourseOrderItem {
    /**
     * 订单副ID viceID
     */
    private Integer viceid;

    /**
     * 订单ID ID
     */
    private String id;

    /**
     * 物品ID itemID
     */
    private Integer itemid;

    /**
     * 物品数量 itemNum
     */
    private Integer itemnum;

    /**
     * 每个价格 perPrice
     */
    private Float perprice;

    /**
     * 总价格 sumPrice
     */
    private Float sumprice;

    /**
     * 价格类型 priceType
     */
    private String pricetype;

    public Integer getViceid() {
        return viceid;
    }

    public void setViceid(Integer viceid) {
        this.viceid = viceid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype == null ? null : pricetype.trim();
    }
}