package com.software.domain;

public class WarehourseDetail {
    /**
     * 仓库货品ID warehourseID
     */
    private Integer warehourseid;

    /**
     * 商品ID ItemID
     */
    private Integer itemid;

    /**
     * 商品数量 itemNum
     */
    private Integer itemnum;

    /**
     * 仓库货品ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return warehourseID 仓库货品ID
     */
    public Integer getWarehourseid() {
        return warehourseid;
    }

    /**
     * 仓库货品ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param warehourseid 仓库货品ID
     */
    public void setWarehourseid(Integer warehourseid) {
        this.warehourseid = warehourseid;
    }

    /**
     * 商品ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return ItemID 商品ID
     */
    public Integer getItemid() {
        return itemid;
    }

    /**
     * 商品ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param itemid 商品ID
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
}