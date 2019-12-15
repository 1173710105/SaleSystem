//仓库对象操作

defaultSetting = {
    id : '',
    name : '',
    location : '',
    principalid : ''
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

//通过id查找仓库
function queryWarehourseById(id) {
    if (id == "") {
        return;
    }
    param = 
       '{"id":"' + id + '"}';
    url = "/warehourse/queryById";
    return sendJsonAjax(url, param);
}

//通过条件筛选仓库
function queryWarehourse(warehourse) {
    if (warehourse == null) {
        return null;
    }
    combineWarehourse = $.extend({},defaultSetting, warehourse);
    param = 
       '{'
        + '"id":"' + combineWarehourse.id + '",'
        + '"name":"' + combineWarehourse.name + '",'
        + '"location:"' + combineWarehourse.location + '",'
        + '"principalid":"' + combineWarehourse.principalid + '"}';
    url = "/warehourse/query";
    return sendJsonAjax(url, param);
}

//增加仓库
function addWarehourse(warehourse) {
    if (warehourse == null) {
        return null;
    }
    combineWarehourse = $.extend({},defaultSetting, warehourse);
    param = 
       '{'
        + '"id":"' + combineWarehourse.id + '",'
        + '"name":"' + combineWarehourse.name + '",'
        + '"location:"' + combineWarehourse.location + '",'
        + '"principalid":"' + combineWarehourse.principalid + '"}';
    url = "/warehourse/add";
    return sendJsonAjax(url, param);
}

//删除仓库
function deleteWarehourse(id) {
    if (id == "") {
        return null;
    }
    param = 
       '{"id":"' + id + '"}';
    url = "/warehourse/delete";
    return sendJsonAjax(url, param);
}

//更新仓库
function updateWarehourse(warehourse) {
    if (warehourse == null) {
        return null;
    }
    combineWarehourse = $.extend({},defaultSetting, warehourse);
    param = 
       '{'
        + '"id":"' + combineWarehourse.id + '",'
        + '"name":"' + combineWarehourse.name + '",'
        + '"location:"' + combineWarehourse.location + '",'
        + '"principalid":"' + combineWarehourse.principalid + '"}';
    url = "/warehourse/update";
    return sendJsonAjax(url, param);
}