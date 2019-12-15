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
    var tempdata;
    $.ajax({
        url: url,
        data: param,
        type: "post",
        dataType: "JSON",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            if (data != null) {
                console.log("ClientJson : ", data);
                tempdata = data;
            }
        },
        error: function () {
        }
    });
    return tempdata;
 }

//通过id查找客户
function queryClientById(tid) {
    if (tid == "") {
        return;
    }
    client = {
        id : tid
    }
    param = buildParam(client);
    url = "";
    console.log("QueryClientById : ", param);
    return sendJsonAjax(url, param);
}

//通过条件筛选客户
function queryClient(client) {
    if (client == null) {
        return null;
    }
    param = buildParam(client);
    console.log("QueryClient : ", param);
    url = "";
    return sendJsonAjax(url, param);
}

//增加客户
function insertClient(client) {
    if (client == null) {
        return null;
    }
    param = buildParam(client);
    url = "";
    console.log("InsertClient : ", param);
    return sendJsonAjax(url, param);
}

//删除客户
function deleteClient(client) {
    if (client.id == "") {
        return null;
    }
    param = buildParam(client);
    url = "";
    console.log("DeleteClient : ", param);
    return sendJsonAjax(url, param);
}

//更新客户
function updateClient(client) {
    if (client == null) {
        return null;
    }
    param = buildParam(client);
    url = "";
    console.log("UpdataClient : ", param);
    return sendJsonAjax(url, param);
}

function buildParam(client) {
    combineClient = $.extend({},defaultSetting, client);
    param = 
       '{'
        + '"id":"' + combineClient.id + '",'
        + '"name":"' + combineClient.name + '",'
        + '"gender:"' + combineClient.gender + '",'
        + '"phone":"' + combineClient.phone + '",'
        + '"email":"' + combineClient.email + '",'
        + '"label":"' + combineClient.label + '"}';
    return param;
}
