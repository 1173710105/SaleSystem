/**
 * 订单有关请求和操作
 */

defaultSetting = {
    orderid: '',
    viceid: '',  //订单编号
    warehourseid: '',
    clientid: '',
    clientname : '',
    principalid: '',
    principalname : '',
    itemid : '',
    itemname : '',
    itemnum: '',
    perprice: '',
    sumprice: '',
    ordersumprice: '',
    gather: '',
    change: '',
    margin: '',
    createtime: '',
    checktime: '',
    gathertime: '',
    returntime: '',
    postime: '',
    status: '',
    type: '',
    exception: '',
    note: ''
};

function sendOrderJsonAjax(url, param) {
    var tempdata;
    $.ajax({
        url: url,
        data: param,
        type: "post",
        dataType: "JSON",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            if (data != null) {
                tempdata = data;
            }
        },
        error: function () {
        }
    });
    return tempdata;
}

//查询订单,结果为list
function queryOrder(order) {
    if (order == null) {
        return;
    }
    param = buildParam(order);
    url = "/order/query";
    console.log("QueryOrder : " + param);
    return sendOrderJsonAjax(url, param);
}

/**
 * 插入新建订单
 * @param {List} order 列表类型对象,每一个对象都是一个子订单
 */
function insertOrder(orderL) {
    if (orderL == null) {
        return;
    }
    //param = buildParamList(order);
    jsonList = [];
    for (var i = 0 ; i < orderL.length; i++) {
        combineOrder = $.extend({}, defaultSetting, orderL[i]);
        param = 
        '{'
        + '"orderid":"' + combineOrder.orderid + '",'
        + '"viceid":"' + combineOrder.viceid + '",'
        + '"warehourseid":"' + combineOrder.tablename + '",'
        + '"warehoursename":"' + combineOrder.warehoursename + '",'
        + '"clientid":"' + combineOrder.clientid + '",'
        + '"clientname":"' + combineOrder.clientname + '",'
        + '"principalid":"' + combineOrder.principalid + '",'
        + '"principalname":"' + combineOrder.principalname + '",'
        + '"itemid":"' + combineOrder.itemid + '",'
        + '"itemname":"' + combineOrder.itemname + '",'
        + '"itemnum":"' + combineOrder.itemnum + '",'  //货品数量
        + '"perprice":"' + combineOrder.perprice + '",'
        + '"sumprice":"' + combineOrder.sumprice + '",'
        + '"ordersumprice":"' + combineOrder.ordersumprice + '",'
        + '"gather":"' + combineOrder.gather + '",'
        + '"change":"' + combineOrder.change + '",'
        + '"margin":"' + combineOrder.margin + '",'
        + '"createtime":"' + combineOrder.createtime + '",'
        + '"checktime":"' + combineOrder.checktime + '",'
        + '"gathertime":"' + combineOrder.gathertime + '",'
        + '"returntime":"' + combineOrder.returntime + '",'
        + '"postime":"' + combineOrder.postime + '",'
        + '"status":"' + combineOrder.status + '",'
        + '"type":"' + combineOrder.type + '",'
        + '"exception":"' + combineOrder.exception + '",'
        + '"note":"' + combineOrder.note + '"}';
        jsonList.push(param);
    }
    param = '[';
    for (var i = 0 ; i < jsonList.length-1; i++) {
        param += (jsonList[i] + ',');
    }
    param += (jsonList[jsonList.length-1] + ']');
    url = "/order/insert";
    console.log("InsertOrder : " + param);
    return sendOrderJsonAjax(url, param);
}

/**
 * 更新订单信息
 * @param {List} order 子订单列表 
 */
function updateOrder(order) {
    if (order == null) {
        return;
    }
    param = buildParamList(order);
    console.log("UpdataOrder : " + param);
    url = "/order/update";
    return sendOrderJsonAjax(url, param);
}

//删除订单
function deleteOrder(id) {
    if (id == "") {
        return;
    }
    param = 
        '{"viceid":"' + id.toString() + '"}';
    console.log("DeleteOrder : " + param);
    url = "/order/delete";
    return sendOrderJsonAjax(url, param);
}

//将订单审核通过
function checkOrder(id) {
    if (id == "") {
        return;
    }
    param =
        '{"viceid":"' + id.toString() + '"}';
    url = "/order/check";
    console.log("CheckOrder : " + param);
    return sendOrderJsonAjax(url, param);
}

//将订单付款
function payOrder(order) {
    if (id == "") {
        return;
    }
    param = buildParam(order);
    url = "/order/pay";
    console.log("PayOrder : " + param);
    return sendOrderJsonAjax(url, param);
}

//将订单退货
function returnOrder(tid, tprincipalid, texception, tnote) {
    if (id == "") {
        return;
    }
    param = buildParam(order);
    url = "/order/return";
    console.log("ReturnOrder : " + param);
    return sendOrderJsonAjax(url, param);
}

function buildParam(order) {
    combineOrder = $.extend({}, defaultSetting, order);
    param =
        '{'
        + '"orderid":"' + combineOrder.orderid + '",'
        + '"viceid":"' + combineOrder.viceid + '",'
        + '"warehorseid":"' + combineOrder.warehorseid + '",'
        + '"clientid:"' + combineOrder.clientid + '",'
        + '"principalid":"' + combineOrder.principalid + '",'
        + '"itemid":"' + combineOrder.itemid + '",'
        + '"itemnum":"' + combineOrder.itemnum + '",'  //货品数量
        + '"perprice":"' + combineOrder.perprice + '",'
        + '"sumprice":"' + combineOrder.sumprice + '",'
        + '"ordersumprice":"' + combineOrder.ordersumprice + '",'
        + '"gather":"' + combineOrder.gather + '",'
        + '"change":"' + combineOrder.change + '",'
        + '"margin":"' + combineOrder.margin + '",'
        + '"createtime":"' + combineOrder.createtime + '",'
        + '"checktime":"' + combineOrder.checktime + '",'
        + '"gathertime":"' + combineOrder.gathertime + '",'
        + '"returntime":"' + combineOrder.returntime + '",'
        + '"postime":"' + combineOrder.postime + '",'
        + '"status":"' + combineOrder.status + '",'
        + '"type":"' + combineOrder.type + '",'
        + '"exception":"' + combineOrder.exception + '",'
        + '"note":"' + combineOrder.note + '"}';
        return param;
}

function buildParamList(orderL) {
    jsonList = [];
    for (var i = 0 ; i < orderL.length; i++) {
        combineOrder = $.extend({}, defaultSetting, orderL[i]);
        param = 
        '{'
        + '"orderid":"' + combineOrder.orderid + '",'
        + '"viceid":"' + combineOrder.viceid + '",'
        + '"warehorseid":"' + combineOrder.warehorseid + '",'
        + '"clientid:"' + combineOrder.clientid + '",'
        + '"principalid":"' + combineOrder.principalid + '",'
        + '"itemid":"' + combineOrder.itemid + '",'
        + '"itemnum":"' + combineOrder.itemnum + '",'  //货品数量
        + '"perprice":"' + combineOrder.perprice + '",'
        + '"sumprice":"' + combineOrder.sumprice + '",'
        + '"ordersumprice":"' + combineOrder.ordersumprice + '",'
        + '"gather":"' + combineOrder.gather + '",'
        + '"change":"' + combineOrder.change + '",'
        + '"margin":"' + combineOrder.margin + '",'
        + '"createtime":"' + combineOrder.createtime + '",'
        + '"checktime":"' + combineOrder.checktime + '",'
        + '"gathertime":"' + combineOrder.gathertime + '",'
        + '"returntime":"' + combineOrder.returntime + '",'
        + '"postime":"' + combineOrder.postime + '",'
        + '"status":"' + combineOrder.status + '",'
        + '"type":"' + combineOrder.type + '",'
        + '"exception":"' + combineOrder.exception + '",'
        + '"note":"' + combineOrder.note + '"}';
        jsonList.push(param);
    }
    param = '[';
    for (var i = 0 ; i < jsonList.length-1; i++) {
        param += (jsonList[i] + ',');
    }
    param += (jsonList[jsonList.length-1] + ']');
    console.log("order param", param);
    return param;
}