package com.software.middleware;

public class SaleOrderTreated 
{
	private String tablename;

    /**
     * 销售单副ID viceID
     */
    private String viceid;

    /**
     * 门店ID warehourseID
     */
    private Integer warehourseid;

    /**
     * 客户ID clientID
     */
    private Integer clientid;

    /**
     * 负责人ID principalID
     */
    private Integer principalid;
   

    /**
     * 创建时间 createTime
     */
    private String createtime;

    /**
     * 审核时间 checkTime
     */
    private String checktime;

    /**
     * 收款时间 gatherTime
     */
    private String gathertime;

    /**
     * 退款时间 returnTime
     */
    private String returntime;

    /**
     * pos机上结算时间 posTime
     */
    private String postime;

    /**
     * 销售单状态 status
     */
    private Integer status;

    private Float sumprice;

    /**
     * 毛利润 margin
     */
    private Float margin;
    
    /**
     * 收款 gather
     */
    private Float gather;

    /**
     * 找零 change
     */
    private Float change;

    /**
     * 销售单类型 type
     */
    private String type;

    /**
     * 备注信息 note
     */
    private String note;

    /**
     * 异常情况记录 exception
     */
    private String exception;
    
    
    
    /**
     * 销售单ID orderID
     */
    private Integer orderid;
    
    /**
     * 商品ID itemID
     */
    private Integer itemid;

    /**
     * 商品个数 itemNum
     */
    private Integer itemnum;

    /**
     * 单价 perPrice
     */
    private Float perprice;

//    /**
//     * 总价 sumPrice
//     */
//    private Float sumprice;
}
