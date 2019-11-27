package com.software.domain;

public class Item {
    /**
     * 商品ID ID
     */
    private Integer id;

    /**
     * 商品名字 name
     */
    private String name;

    /**
     * 商品类型 type
     */
    private String type;

    /**
     * 商品说明信息 specification
     */
    private String specification;

    /**
     * 存放图片路径 picture
     */
    private String picture;

    /**
     * 零售价 retailPrice
     */
    private Float retailprice;

    /**
     * 批发价 wholesalePrice
     */
    private Float wholesaleprice;

    /**
     * 进货价 purchasePrice
     */
    private Float purchaseprice;

    /**
     * 商品ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return ID 商品ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 商品ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param id 商品ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 商品名字
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return name 商品名字
     */
    public String getName() {
        return name;
    }

    /**
     * 商品名字
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param name 商品名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 商品类型
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return type 商品类型
     */
    public String getType() {
        return type;
    }

    /**
     * 商品类型
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param type 商品类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 商品说明信息
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return specification 商品说明信息
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * 商品说明信息
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param specification 商品说明信息
     */
    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    /**
     * 存放图片路径
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return picture 存放图片路径
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 存放图片路径
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param picture 存放图片路径
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * 零售价
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return retailPrice 零售价
     */
    public Float getRetailprice() {
        return retailprice;
    }

    /**
     * 零售价
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param retailprice 零售价
     */
    public void setRetailprice(Float retailprice) {
        this.retailprice = retailprice;
    }

    /**
     * 批发价
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return wholesalePrice 批发价
     */
    public Float getWholesaleprice() {
        return wholesaleprice;
    }

    /**
     * 批发价
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param wholesaleprice 批发价
     */
    public void setWholesaleprice(Float wholesaleprice) {
        this.wholesaleprice = wholesaleprice;
    }

    /**
     * 进货价
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return purchasePrice 进货价
     */
    public Float getPurchaseprice() {
        return purchaseprice;
    }

    /**
     * 进货价
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param purchaseprice 进货价
     */
    public void setPurchaseprice(Float purchaseprice) {
        this.purchaseprice = purchaseprice;
    }
}