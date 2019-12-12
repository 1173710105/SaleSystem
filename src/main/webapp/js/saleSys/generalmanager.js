//总经理对象操作

defaultSetting = {
    id : '',
    password : '',
    hourseid : '',
    name : '',
    gender : '',
    phone : '',
    email : ''
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

//通过id查找总经理
function queryGManagerById(id) {
    if (id == "") {
        return;
    }
    param = 
       '{"id":"' + id + '"}';
    url = "";
    return sendJsonAjax(url, param);
}
