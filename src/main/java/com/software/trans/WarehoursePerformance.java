package com.software.trans;

public class WarehoursePerformance 
{
	private String warehourseid;
	private String warehoursename;
	private String principalid;
	private String principalname;
	private String performancedetail;
	private String clientnum;
	private String orderNum;
	private String starttime;
	private String endtime;
	
	public String getWarehourseid() 
	{
		return warehourseid;
	}
	public void setWarehourseid(String warehourseid) 
	{
		this.warehourseid = warehourseid;
	}
	public String getWarehoursename() 
	{
		return warehoursename;
	}
	public void setWarehoursename(String warehoursename) 
	{
		this.warehoursename = warehoursename;
	}
	public String getPrincipalid() 
	{
		return principalid;
	}
	public void setPrincipalid(String principalid) 
	{
		this.principalid = principalid;
	}
	public String getPrincipalname() 
	{
		return principalname;
	}
	public void setPrincipalname(String principalname) {
		this.principalname = principalname;
	}
	public String getPerformancedetail() 
	{
		return performancedetail;
	}
	public void setPerformancedetail(String performancedetail) 
	{
		this.performancedetail = performancedetail;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "WarehoursePerformance [warehourseid=" + warehourseid + ", warehoursename=" + warehoursename
				+ ", principalid=" + principalid + ", principalname=" + principalname + ", performancedetail="
				+ performancedetail + ", starttime=" + starttime + ", endtime=" + endtime + "]";
	}
}
