package com.software.domain;

public class Item 
{
	private String tablename;
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
    
	public Item() {
		super();
	}

	public Item(String tablename, Integer id, String name, String type, String specification, String picture,
			Float retailprice, Float wholesaleprice, Float purchaseprice) {
		super();
		this.tablename = tablename;
		this.id = id;
		this.name = name;
		this.type = type;
		this.specification = specification;
		this.picture = picture;
		this.retailprice = retailprice;
		this.wholesaleprice = wholesaleprice;
		this.purchaseprice = purchaseprice;
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

    public Float getRetailprice() {
        return retailprice;
    }

    public void setRetailprice(Float retailprice) {
        this.retailprice = retailprice;
    }

    public Float getWholesaleprice() {
        return wholesaleprice;
    }

    public void setWholesaleprice(Float wholesaleprice) {
        this.wholesaleprice = wholesaleprice;
    }

    public Float getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(Float purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

	@Override
	public String toString() {
		return "Item [tableName=" + tablename + ", id=" + id + ", name=" + name + ", type=" + type + ", specification="
				+ specification + ", picture=" + picture + ", retailprice=" + retailprice + ", wholesaleprice="
				+ wholesaleprice + ", purchaseprice=" + purchaseprice + "]";
	}
	
    
}