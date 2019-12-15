//库存对象及其操作
defaultSetting = {
    hourseid : '',
    itemid : '',
    itemname : '',
    itemnum : '',
}

function sendJsonAjax(url, param) {
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

//通过仓库id查找库存
function queryStockByWarehourseId(thourseid) {
    if(thourseid == "") {
        return;
    }
    stock = {
        hourseid : thourseid 
    }
    param = buildParam(stock);
    url = "";
    console.log("QueryStockByWareId : ", param);
    return sendJsonAjax(url, param);
}

//通过条件过滤查找库存
function queryStock(stock) {
    if(stock == null) {
        return;
    }
    url = ''
    param = buildParam(stock);
    console.log("QueryStock : ", param);
    return sendJsonAjax(url, param);
}

//修改库存，更新盘点
//stock是list格式
function updateStock(stockL) {
    if(stockL == null) {
        return;
    }
    param = buildParamList(stockL);
    url = "";
    console.log("UpdataStock : ", param);
    return sendJsonAjax(param, url);
}

function buildParam(stock) {
    combineStock = $.extend({}, defaultSetting, stock);
    param = 
        '{"hourseid":"' + combineStock.hourseid + '",'
        + '"itemid":"' + combineStock.itemid + '",'
        + '"itemname":"' + combineStock.itemname + '",'
        + '"itemnum":"' + combineStock.itemnum + '"}';
    return param;
}

function buildParamList(stockL) {
    jsonList = [];
    for(var i = 0; i < stockL.length; i++) {
        combineStock = $.extend({}, defaultSetting, stockL[i]);
        param = 
        '{"hourseid":"' + combineStock.hourseid + '",'
        + '"itemid":"' + combineStock.itemid + '",'
        + '"itemname":"' + combineStock.itemname + '",'
        + '"itemnum":"' + combineStock.itemnum + '"}';
        jsonList.push(param);
    }
    param = '[';
    for (var i = 0 ; i < jsonList.length-1; i++) {
        param += (jsonList[i] + ',');
    }
    param += (jsonList[jsonList.length-1] + ']');
    return param;
}