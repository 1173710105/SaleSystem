package com.software.middleware;

public class WarehourseOrderTreated 
{
	/**
     * 仓库单ID orderID
     */
    private Integer orderid;

    /**
     * 货源地ID sourceID
     */
    private Integer sourceid;

    /**
     * 货品目的地ID targetID
     */
    private Integer targetid;

    /**
     * 发送者ID senderPrincipalID
     */
    private String senderprincipalid;

    /**
     * 接收者ID receiverPrincipalID
     */
    private String receiverprincipalid;

    

    /**
     * 货源类型 sourceType
     */
    private String sourcetype;

    /**
     * 货品去向类型 targetType
     */
    private String targettype;
    
    private Float sumPrice;
    
    private String priceType;
    
    /**
     * 是否是草稿 isScript
     */
    private Byte isscript;

    /**
     * 是否已经通过审核 isCheck
     */
    private Byte ischeck;

    /**
     * 创建时间 createTime
     */
    private String createtime;

    /**
     * 审核时间 checkTime
     */
    private String checktime;

    /**
     * 状态标注 status
     */
    private String status;
    
    
    
    
    
//    /**
//     * 仓库单ID orderID
//     */
//    private Integer orderid;

    /**
     * 仓库单ID viceOrderID
     */
    private String viceorderid;
    
    
    /**
     * 商品编号 itemID
     */
    private Integer itemid;

    /**
     * 商品总数量 itemNum
     */
    private Integer itemnum;
    
    /**
     * 单个价格 perPrice
     */
    private Float perprice;

//    /**
//     * 总价 sumPrice
//     */
//    private Float sumprice;

    /**
     * 价格类型 priceType
     */
    private String pricetype;

}
