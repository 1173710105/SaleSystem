package com.software.trans;

import com.software.domain.Item;
import com.software.domain.ItemToPrice;

public class ReceiveCargo 
{
	private String tablename;
	private String id;
	private String name;
	private String type;
	private String specification;
	private String picture;
	private String retailprice;
	private String wholesaleprice;
	private String purchaseprice;
	private String time;
	private String label;
	
	public String getId() {
		return id;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
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
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public void initByItem(Item item)
	{
		this.id = item.getId()+"";
		this.name = item.getName();
		this.type = item.getType();
		this.specification = item.getSpecification();
		this.picture = item.getPicture();
		this.time = item.getTime();
		this.label = item.getLabel();
	}
	
	public void initByPrice(ItemToPrice price)
	{
		this.tablename = price.getTablename();
		this.retailprice = price.getRetailprice()+"";
		this.purchaseprice = price.getPurchaseprice()+"";
		this.wholesaleprice = price.getWholesaleprice()+"";
	}
	
	public Item toItem()
	{
		Item item = new Item();
		item.setId(Integer.valueOf(this.id));
		item.setName(this.name);
		item.setType(this.type);
		item.setSpecification(this.specification);
		item.setPicture(this.picture);
		item.setTime(this.time);
		return item;
	}
	
	public ItemToPrice toPrice()
	{
		ItemToPrice price = new ItemToPrice();
		price.setTablename(this.tablename);
		price.setId(Integer.valueOf(this.id));
		price.setName(this.name);
		price.setRetailprice(Float.valueOf(this.retailprice));
		price.setPurchaseprice(Float.valueOf(this.purchaseprice));
		price.setWholesaleprice(Float.valueOf(this.wholesaleprice));
		price.setTime(time);
		return price;
	}
	@Override
	public String toString() {
		return "ReceiveCargo [tablename=" + tablename + ", id=" + id + ", name=" + name + ", type=" + type
				+ ", specification=" + specification + ", picture=" + picture + ", retailprice=" + retailprice
				+ ", wholesaleprice=" + wholesaleprice + ", purchaseprice=" + purchaseprice + "]";
	}
}
