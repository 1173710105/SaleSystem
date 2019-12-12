//客户对象操作

defaultSetting = {
    id : '',
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

//通过id查找客户
function queryClientById(id) {
    if (id == "") {
        return;
    }
    param = 
       '{"id":"' + id + '"}';
    url = "";
    return sendJsonAjax(url, param);
}

//通过条件筛选客户
function queryClient(client) {
    if (client == null) {
        return null;
    }
    combineClient = $.extend({},defaultSetting, client);
    param = 
       '{'
        + '"id":"' + combineClient.id + '",'
        + '"name":"' + combineClient.name + '",'
        + '"gender:"' + combineClient.gender + '",'
        + '"phone":"' + combineClient.phone + '",'
        + '"email":"' + combineClient.email + '",'
        + '"label":"' + combineClient.label + '"}';
    url = "";
    return sendJsonAjax(url, param);
}

//增加客户
function insertClient(client) {
    if (client == null) {
        return null;
    }
    combineClient = $.extend({},defaultSetting, client);
    param = 
       '{'
        + '"id":"",'
        + '"name":"' + combineClient.name + '",'
        + '"gender:"' + combineClient.gender + '",'
        + '"phone":"' + combineClient.phone + '",'
        + '"email":"' + combineClient.email + '",'
        + '"label":"' + combineClient.label + '"}';
    url = "";
    return sendJsonAjax(url, param);
}

//删除客户
function deleteClient(id) {
    if (id == "") {
        return null;
    }
    param = 
       '{"id":"' + id + '"}';
    url = "";
    return sendJsonAjax(url, param);
}

//更新客户
function updateClient(client) {
    if (client == null) {
        return null;
    }
    combineClient = $.extend({},defaultSetting, client);
    param = 
       '{'
        + '"id":"' + combineClient.id + '",'
        + '"name":"' + combineClient.name + '",'
        + '"gender:"' + combineClient.gender + '",'
        + '"phone":"' + combineClient.phone + '",'
        + '"email":"' + combineClient.email + '",'
        + '"label":"' + combineClient.label + '"}';
    url = "";
    return sendJsonAjax(url, param);
}
