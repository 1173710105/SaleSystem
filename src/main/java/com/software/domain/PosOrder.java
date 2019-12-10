package com.software.domain;

import java.util.Date;

public class PosOrder {
    /**
     * 订单ID SaleOrderID
     */
    private Integer saleorderid;

    /**
     * 应该收取价格 sumPrice
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
     * 收款时间 time
     */
    private Date time;

    /**
     * 订单ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return SaleOrderID 订单ID
     */
    public Integer getSaleorderid() {
        return saleorderid;
    }

    /**
     * 订单ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param saleorderid 订单ID
     */
    public void setSaleorderid(Integer saleorderid) {
        this.saleorderid = saleorderid;
    }

    /**
     * 应该收取价格
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return sumPrice 应该收取价格
     */
    public Float getSumprice() {
        return sumprice;
    }

    /**
     * 应该收取价格
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param sumprice 应该收取价格
     */
    public void setSumprice(Float sumprice) {
        this.sumprice = sumprice;
    }

    /**
     * 收款
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return gather 收款
     */
    public Float getGather() {
        return gather;
    }

    /**
     * 收款
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param gather 收款
     */
    public void setGather(Float gather) {
        this.gather = gather;
    }

    /**
     * 找零
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return change 找零
     */
    public Float getChange() {
        return change;
    }

    /**
     * 找零
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param change 找零
     */
    public void setChange(Float change) {
        this.change = change;
    }

    /**
     * 收款时间
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return time 收款时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 收款时间
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param time 收款时间
     */
    public void setTime(Date time) {
        this.time = time;
    }
}