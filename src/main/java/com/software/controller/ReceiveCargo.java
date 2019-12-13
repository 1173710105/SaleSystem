package com.software.controller;

public class ReceiveCargo {
	private String id;
	private String name;
	private String type;
	private String specification;
	private String picture;
	private String retailprice;
	private String wholesaleprice;
	private String purchaseprice;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getRetailprice() {
		return retailprice;
	}
	public void setRetailprice(String retailprice) {
		this.retailprice = retailprice;
	}
	public String getWholesaleprice() {
		return wholesaleprice;
	}
	public void setWholesaleprice(String wholesaleprice) {
		this.wholesaleprice = wholesaleprice;
	}
	public String getPurchaseprice() {
		return purchaseprice;
	}
	public void setPurchaseprice(String purchaseprice) {
		this.purchaseprice = purchaseprice;
	}
	@Override
	public String toString() {
		return "ReceiveCargo [id=" + id + ", name=" + name + ", type=" + type + ", specification=" + specification
				+ ", picture=" + picture + ", retailprice=" + retailprice + ", wholesaleprice=" + wholesaleprice
				+ ", purchaseprice=" + purchaseprice + "]";
	}
	
	
}
