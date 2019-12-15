//库存对象及其操作
defaultSetting = {
    hourseid : '',
    itemid : '',
    itemname : '',
    itemnum : '',
    tablename : ''
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
                return data;
            }
            return null;
        },
        error: function () {
        }
    });
 }

//通过仓库id查找库存
function queryStockByWarehourseId(hourseid) {
    if(hourseid == "") {
        return;
    }
    param = '{"hourseid":"' + hourseid + '"}';
    url = "";
    return sendJsonAjax(url, param);
}

//通过条件过滤查找库存
function queryStock(stock) {
    if(stock == null) {
        return;
    }
    combineStock = $.extend({}, defaultSetting, stock);
    param = 
        '{"hourseid":"' + combineStock.hourseid + '",'
        + '"itemid":"' + combineStock.itemid + '",'
        + '"itemname":"' + combineStock.itemname + '",'
        + '"itemnum":"' + combineStock.itemnum + '"}';
    return sendJsonAjax(url, param);
}

//修改库存，更新盘点
//stock是list格式
function updateStock(stockL) {
    if(stockL == null) {
        return;
    }
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
    url = "";
    return sendJsonAjax(param, url);
}