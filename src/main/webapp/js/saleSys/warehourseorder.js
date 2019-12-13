//进货出货单操作

defaultSetting = {
    id : '',  //仓库单id
    sourceid : '',
    targetid : '',
    senderprincipalid : '',
    receiverprincipalid : '',
    sourcetype : '',
    targettype : '',
    sumprice : '',
    pricetype : '',
    status : '',
    itemid : '',
    itemnum : '',
    perprice : '',
    sumprice : '',
    pricetype : ''
}

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

//通过id搜索仓库单
function queryWarehourseOrderById(id) {
    if (id == "") {
        return;
    }
    param = '{"id":"' + id + '"}';
    url = "";
    sendJsonAjax(url, param);
}

//过滤条件搜索,结果为list
function queryWarehourseOrder(worder) {
    if (worder == null) {
        return;
    }
    combineWorder = $.extend({}, defaultSetting, worder);
    param = 
        '{'
        + '"id":"' + combineWorder.id + '",'
        + '"sourceid":"' + combineWorder.sourceid + '",'
        + '"targetid":"' + combineWorder.targetid + '",'
        + '"senderprincipalid":"' + combineWorder.senderprincipalid + '",'
        + '"receiverprincipalid":"' + combineWorder.receiverprincipalid + '",'
        + '"sourcetype":"' + combineWorder.sourcetype + '",'
        + '"targettype":"' + combineWorder.targettype + '",'
        + '"sumprice":"' + combineWorder.sumprice + '",'
        + '"pricetype":"' + combineWorder.pricetype + '",'
        + '"status":"' + combineWorder.status+ '",'
        + '"itemid":"' + combineWorder.itemid + '",'
        + '"itemnum":"' + combineWorder.itemnum + '",'
        + '"perprice":"' + combineWorder.perprice + '",'
        + '"sumprice":"' + combineWorder.sumprice + '"}';
    url = "";
    console.log("query warehourseorder: " + param);
    return sendJsonAjax(url, param);
}

//插入仓库单
function insertWarehourseOrder(worder) {
    if (worder == null) {
        return;
    }
    jsonList = [];
    for (var i = 0 ; i < worder.length; i++) {
        combineWorder = $.extend({}, defaultSetting, worder[i]);
        param = 
        '{'
        + '"id":"' + combineWorder.id + '",'
        + '"sourceid":"' + combineWorder.sourceid + '",'
        + '"targetid":"' + combineWorder.targetid + '",'
        + '"senderprincipalid":"' + combineWorder.senderprincipalid + '",'
        + '"receiverprincipalid":"' + combineWorder.receiverprincipalid + '",'
        + '"sourcetype":"' + combineWorder.sourcetype + '",'
        + '"targettype":"' + combineWorder.targettype + '",'
        + '"sumprice":"' + combineWorder.sumprice + '",'
        + '"pricetype":"' + combineWorder.pricetype + '",'
        + '"status":"' + combineWorder.status+ '",'
        + '"itemid":"' + combineWorder.itemid + '",'
        + '"itemnum":"' + combineWorder.itemnum + '",'
        + '"perprice":"' + combineWorder.perprice + '",'
        + '"sumprice":"' + combineWorder.sumprice + '"}';
        jsonList.push(param);
    }
    param = '[';
    for (var i = 0 ; i < jsonList.length-1; i++) {
        param += (jsonList[i] + ',');
    }
    param += (jsonList[jsonList.length-1] + ']');
    url = "";
    console.log("insert new warehourseorder: " + param);
    return sendJsonAjax(url, param);
}


//更新仓库单
function updateWarehourseOrder(worder) {
    if (worder == null) {
        return;
    }
    jsonList = [];
    for (var i = 0 ; i < worder.length; i++) {
        combineWorder = $.extend({}, defaultSetting, worder[i]);
        param = 
        '{'
        + '"id":"' + combineWorder.id + '",'
        + '"sourceid":"' + combineWorder.sourceid + '",'
        + '"targetid":"' + combineWorder.targetid + '",'
        + '"senderprincipalid":"' + combineWorder.senderprincipalid + '",'
        + '"receiverprincipalid":"' + combineWorder.receiverprincipalid + '",'
        + '"sourcetype":"' + combineWorder.sourcetype + '",'
        + '"targettype":"' + combineWorder.targettype + '",'
        + '"sumprice":"' + combineWorder.sumprice + '",'
        + '"pricetype":"' + combineWorder.pricetype + '",'
        + '"status":"' + combineWorder.status+ '",'
        + '"itemid":"' + combineWorder.itemid + '",'
        + '"itemnum":"' + combineWorder.itemnum + '",'
        + '"perprice":"' + combineWorder.perprice + '",'
        + '"sumprice":"' + combineWorder.sumprice + '"}';
        jsonList.push(param);
    }
    param = '[';
    for (var i = 0 ; i < jsonList.length-1; i++) {
        param += (jsonList[i] + ',');
    }
    param += (jsonList[jsonList.length-1] + ']');
    url = "";
    console.log("update warehourseorder: " + param);
    return sendJsonAjax(url, param);
}

//删除仓库单
function deleteWarehourseOrder(id) {
    if(id == "") {
        return;
    }
    param = '{"id":"' + id + '"}';
    url = "";
    return sendJsonAjax(url, param);
}

//将仓库单设置为审核中状态
function applyWarehourseOrder(id) {
    if(id == "") {
        return;
    }
    param = '{"id":"' + id + '"}';
    url = "";
    return sendJsonAjax(url, param);
}

//将仓库单设置为通过状态
function passWarehourseOrder(id) {
    if(id == "") {
        return;
    }
    param = '{"id":"' + id + '"}';
    url = "";
    return sendJsonAjax(url, param);
}