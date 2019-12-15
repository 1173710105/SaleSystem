//店长对象操作

defaultSetting = {
    id : '',
    password : '',
    hourseid : '',
    name : '',
    gender : '',
    phone : '',
    email : '',
    label : ''
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

//通过id查找店长
function queryManagerById(id) {
    if (id == "") {
        return;
    }
    param = 
       '{"id":"' + id + '"}';
    url = "/shopmanager/queryById";
    return sendJsonAjax(url, param);
}

//通过条件筛选店长
function queryManager(manager) {
    if (manager == null) {
        return null;
    }
    combineManager = $.extend({},defaultSetting, manager);
    param = 
       '{'
        + '"id":"' + combineManager.id + '",'
        + '"name":"' + combineManager.name + '",'
        + '"gender:"' + combineManager.gender + '",'
        + '"phone":"' + combineManager.phone + '",'
        + '"email":"' + combineManager.email + '",'
        + '"label":"' + combineManager.label + '",'
        + '"hourseid":"' + combineManager.hourseid + '"}';
    url = "/shopmanager/query";
    return sendJsonAjax(url, param);
}

//增加店长
function insertManager(manager) {
    if (manager == null) {
        return null;
    }
    combineManager = $.extend({},defaultSetting, manager);
    param = 
       '{'
        + '"id":"' + combineManager.id + '",'
        + '"name":"' + combineManager.name + '",'
        + '"gender:"' + combineManager.gender + '",'
        + '"phone":"' + combineManager.phone + '",'
        + '"email":"' + combineManager.email + '",'
        + '"label":"' + combineManager.label + '",'
        + '"hourseid":"' + combineManager.hourseid + '"}';
    url = "/shopmanager/insert";
    return sendJsonAjax(url, param);
}

//删除店长
function deleteManager(id) {
    if (id == "") {
        return null;
    }
    param = 
       '{"id":"' + id + '"}';
    url = "/shopmanager/delete";
    return sendJsonAjax(url, param);
}

//更新店长
function updateManager(manager) {
    if (manager == null) {
        return null;
    }
    combineClient = $.extend({},defaultSetting, manager);
    param = 
    '{'
    + '"id":"' + combineClient.id + '",'
    + '"name":"' + combineClient.name + '",'
    + '"gender:"' + combineClient.gender + '",'
    + '"phone":"' + combineClient.phone + '",'
    + '"email":"' + combineClient.email + '",'
    + '"hourseid":"' + combineClient.hourseid + '"}';
    url = "/shopmanager/update";
    return sendJsonAjax(url, param);
}

//通过店长查找管理仓库id
function queryWareIdByManagerId(id) {
    if (id == "") {
        return null;
    }
    param = 
       '{"id":"' + id + '"}';
    url = "/shopmanager/queryWare";
    return sendJsonAjax(url, param);
}