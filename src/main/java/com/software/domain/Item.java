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
     * 商品信息说明 specification
     */
    private String specification;

    /**
     * 商品图片 picture
     */
    private String picture;

    /**
     *  time
     */
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}