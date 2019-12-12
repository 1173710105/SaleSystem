package com.software.domain;

import static org.hamcrest.CoreMatchers.nullValue;

public class ItemDetail 
{
	private String itemtablename;  // item 所属表名

    private Integer itemid;  //item id *

    private String itemname;  // item name

    private String itemtype;  // item type

    private String itemspecification;  // item specification 规格说明
    
    private String comeFromID;  // 所属仓库ID *
     
    private String comeFromName;  // 所属仓库名字 * 
    
    private String detailtablename;  // detail 所属表格
    
    private Integer itemnum; //商品数量
    
    private Integer itemnumAfterChange; // 更新后的盘点*
    
    private String detailtime; // 商品

    
    
	

	public String getItemtablename() {
		return itemtablename;
	}

	public void setItemtablename(String itemtablename) {
		this.itemtablename = itemtablename;
	}

	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getItemspecification() {
		return itemspecification;
	}

	public void setItemspecification(String itemspecification) {
		this.itemspecification = itemspecification;
	}

	public String getDetailtablename() 
	{
		return detailtablename;
	}

	public void setDetailtablename(String detailtablename) {
		this.detailtablename = detailtablename;
	}

	public Integer getItemnum() {
		return itemnum;
	}

	public void setItemnum(Integer itemnum) {
		this.itemnum = itemnum;
	}

	public String getDetailtime() {
		return detailtime;
	}

	public void setDetailtime(String detailtime) {
		this.detailtime = detailtime;
	}
    
	
	public Integer getItemnumAfterChange() {
		return itemnumAfterChange;
	}

	public void setItemnumAfterChange(Integer itemnumAfterChange) {
		this.itemnumAfterChange = itemnumAfterChange;
	}

	public ItemDetail()
	{
		
	}
	public ItemDetail(Item item, WarehourseDetail detail) 
	{
		this.itemtablename = item.getTablename();
	    this.itemid = item.getId();
	    this.itemname = item.getName();
	    this.itemtype = item.getType();
	    this.itemspecification = item.getSpecification();    
	    this.detailtablename = detail.getTablename();
	    this.itemnum = detail.getItemnum();
	    this.detailtime = detail.getTime();
	}
	
	public void partyInitByItem(Item item)
	{
		this.itemtablename = item.getTablename();
	    this.itemid = item.getId();
	    this.itemname = item.getName();
	    this.itemtype = item.getType();
	    this.itemspecification = item.getSpecification();  
	}
	public void partyInitByDetail(WarehourseDetail detail)
	{
		this.detailtablename = detail.getTablename();
	    this.itemnum = detail.getItemnum();
	    this.detailtime = detail.getTime();
	}
	public WarehourseDetail toWarehourseDetail()
	{
		WarehourseDetail detail = new WarehourseDetail();
		detail.setTablename(this.detailtablename);
		detail.setItemid(this.itemid);
		if (this.itemnumAfterChange!=null) 
		{
			detail.setItemnum(this.itemnum);
		}
		else
		{
			detail.setItemnum(this.itemnumAfterChange);
		}
		detail.setTime(this.detailtime);
		return detail;
	}
	
	public Item toItem()
	{
		Item item = new Item();
		item.setTablename(this.itemtablename);
		item.setId(this.itemid);
		item.setName(this.itemname);
		item.setType(this.itemtype);
		return item;
	}

	public String getComeFromID() {
		return comeFromID;
	}

	public void setComeFromID(String comeFromID) {
		this.comeFromID = comeFromID;
	}

	public String getComeFromName() {
		return comeFromName;
	}

	public void setComeFromName(String comeFromName) {
		this.comeFromName = comeFromName;
	}

	@Override
	public String toString() {
		return "ItemDetail [itemtablename=" + itemtablename + ", itemid=" + itemid + ", itemname=" + itemname
				+ ", itemtype=" + itemtype + ", itemspecification=" + itemspecification + ", comeFromID=" + comeFromID
				+ ", comeFromName=" + comeFromName + ", detailtablename=" + detailtablename + ", itemnum=" + itemnum
				+ ", itemnumAfterChange=" + itemnumAfterChange + ", detailtime=" + detailtime + "]";
	}
}

