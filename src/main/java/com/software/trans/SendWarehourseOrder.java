package com.software.trans;

import java.util.List;

import com.software.domain.WarehourseOrderItem;

public class SendWarehourseOrder {
	/**
     * 查看表ID ID
     */
    private Integer id;

    /**
     * 货源地ID sourceID
     */
    private Integer sourceid;

    /**
     * 目的地ID targetID
     */
    private Integer targetid;

    /**
     * 发起人ID senderPrincipalID
     */
    private String senderprincipalid;

    /**
     * 接受人ID receiverPrincipalID
     */
    private String receiverprincipalid;

    /**
     * 货品货源地类型 sourceType
     */
    private String sourcetype;

    /**
     * 货品目的地类型 targetType
     */
    private String targettype;

    /**
     * 总价 sumPrice
     */
    private Float sumprice;

    /**
     * 价格类型 priceType
     */
    private String pricetype;

    /**
     * 创建时间 createTime
     */
    private String createtime;

    /**
     * 审核时间 checkTime
     */
    private String checktime;

    /**
     * 记录销售单状态 status
     */
    private String status;
    
    /**
     * 货单货品列表
     */
    private List<WarehourseOrderItem> items;
}
