/**
 * 订单有关请求和操作
 */

defaultSetting = {
    orderid : '',
    viceid : '',
    clientid : '',
    principalid : '',
    itemnum : '',
    perprice : '',
    sumprice : '',
    margin : '',
    isscript : '',
    ischeck : '',
    isgather : '',
    isreturn : '',
    createtime : '',
    checktime : '',
    gathertime : '',
    returntime : '',
    status : '',
    exception : '',
    note : ''
};

 function sendJsonAjax(url, param) {
    $.ajax({
        url: url,
        data: param,
        type: "post",
        dataType: "text",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            if (data != null) {
                return data;
            }
            return null;
        },
        error: function () {
        }
    });
 }

 //查询订单,结果为list
 function queryOrder(order) {
    if (order == null) {
        return;
    }
    combineOrder = $.extend({},defaultSetting, order);
    param = 
       '{'
        + '"orderid":"' + combineOrder.orderid + '",'
        + '"viceid":"' + combineOrder.viceid + '",'
        + '"clientid:"' + combineOrder.clientid + '",'
        + '"principalid":"' + combineOrder.principalid + '",'
        + '"itemnum":"' + combineOrder.itemnum + '",'
        + '"perprice":"' + combineOrder.perprice + '",'
        + '"sumprice":"' + combineOrder.sumprice + '",'
        + '"margin":"' + combineOrder.margin + '",'
        + '"isscript":"' + combineOrder.isscript + '",'
        + '"ischeck":"' + combineOrder.ischeck + '",'
        + '"isgather":"' + combineOrder.isgather + '",'
        + '"isreturn":"' + combineOrder.isreturn + '",'
        + '"createtime":"' + combineOrder.createtime + '",'
        + '"checktime":"' + combineOrder.checktime + '",'
        + '"gathertime":"' + combineOrder.gathertime + '",'
        + '"returntime":"' + combineOrder.returntime + '",'
        + '"status":"' + combineOrder.status + '",'
        + '"exception":"' + combineOrder.exception + '",'
        + '"note":"' + combineOrder.note + '"}';
   url = "";
   console.log(param);
   return sendJsonAjax(url, param);
 }

 //插入新建订单
 function insertOrder(order) {
    if (order == null) {
        return;
    }
    combineOrder = $.extend({},defaultSetting, order);
    param =
        '{'
        + '"orderid":"' + combineOrder.orderid + '",'
        + '"viceid":"' + combineOrder.viceid + '",'
        + '"clientid:"' + combineOrder.clientid + '",'
        + '"principalid":"' + combineOrder.principalid + '",'
        + '"itemnum":"' + combineOrder.itemnum + '",'
        + '"perprice":"' + combineOrder.perprice + '",'
        + '"sumprice":"' + combineOrder.sumprice + '",'
        + '"margin":"' + combineOrder.margin + '",'
        + '"isscript":"' + combineOrder.isscript + '",'
        + '"ischeck":"' + combineOrder.ischeck + '",'
        + '"isgather":"' + combineOrder.isgather + '",'
        + '"isreturn":"' + combineOrder.isreturn + '",'
        + '"createtime":"' + combineOrder.createtime + '",'
        + '"checktime":"' + combineOrder.checktime + '",'
        + '"gathertime":"' + combineOrder.gathertime + '",'
        + '"returntime":"' + combineOrder.returntime + '",'
        + '"status":"' + combineOrder.status + '",'
        + '"exception":"' + combineOrder.exception + '",'
        + '"note":"' + combineOrder.note + '"}';
    url = "";
    return sendJsonAjax(url, param);
 } 

 //更新订单
 function updateOrder(order) {
    if (order == null) {
        return;
    }
    combineOrder = $.extend({},defaultSetting, order);
    param =
        '{'
        + '"orderid":"' + combineOrder.orderid + '",'
        + '"viceid":"' + combineOrder.viceid + '",'
        + '"clientid:"' + combineOrder.clientid + '",'
        + '"principalid":"' + combineOrder.principalid + '",'
        + '"itemnum":"' + combineOrder.itemnum + '",'
        + '"perprice":"' + combineOrder.perprice + '",'
        + '"sumprice":"' + combineOrder.sumprice + '",'
        + '"margin":"' + combineOrder.margin + '",'
        + '"isscript":"' + combineOrder.isscript + '",'
        + '"ischeck":"' + combineOrder.ischeck + '",'
        + '"isgather":"' + combineOrder.isgather + '",'
        + '"isreturn":"' + combineOrder.isreturn + '",'
        + '"createtime":"' + combineOrder.createtime + '",'
        + '"checktime":"' + combineOrder.checktime + '",'
        + '"gathertime":"' + combineOrder.gathertime + '",'
        + '"returntime":"' + combineOrder.returntime + '",'
        + '"status":"' + combineOrder.status + '",'
        + '"exception":"' + combineOrder.exception + '",'
        + '"note":"' + combineOrder.note + '"}';
    url = "";
 }

 //删除订单
 function deleteOrder(id) {
    if (id == "") {
        return;
    }
    order = {
        viceid : id.toString()
    }
    combineOrder = $.extend({},defaultSetting, order);
    param =
        '{'
        + '"orderid":"' + combineOrder.orderid + '",'
        + '"viceid":"' + combineOrder.viceid + '",'
        + '"clientid:"' + combineOrder.clientid + '",'
        + '"principalid":"' + combineOrder.principalid + '",'
        + '"itemnum":"' + combineOrder.itemnum + '",'
        + '"perprice":"' + combineOrder.perprice + '",'
        + '"sumprice":"' + combineOrder.sumprice + '",'
        + '"margin":"' + combineOrder.margin + '",'
        + '"isscript":"' + combineOrder.isscript + '",'
        + '"ischeck":"' + combineOrder.ischeck + '",'
        + '"isgather":"' + combineOrder.isgather + '",'
        + '"isreturn":"' + combineOrder.isreturn + '",'
        + '"createtime":"' + combineOrder.createtime + '",'
        + '"checktime":"' + combineOrder.checktime + '",'
        + '"gathertime":"' + combineOrder.gathertime + '",'
        + '"returntime":"' + combineOrder.returntime + '",'
        + '"status":"' + combineOrder.status + '",'
        + '"exception":"' + combineOrder.exception + '",'
        + '"note":"' + combineOrder.note + '"}';
    url = "";
    return sendJsonAjax(url, param);
 }

 //将订单审核通过
function checkOrder(id) {
    if (id == "") {
        return;
    }
    param = 
        '{"viceid":"' + id + '"}';
    url = "";
    return sendJsonAjax(url, param);
}

//将订单付款
function parOrder(id) {
    if (id == "") {
        return;
    }
    param = 
        '{"viceid":"' + id + '"}';
    url = "";
    return sendJsonAjax(url, param);
}

//将订单退货
function returnOrder(id, exception, note) {
    if (id == "") {
        return;
    }
    param = 
        '{"viceid":"' + id + '",'
        + '"exception":"' + exception + '",'
        + '"note":"' + note + '"}';

    url = "";
    return sendJsonAjax(url, param);
}