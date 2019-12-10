/**
 * 货物有关请求和操作
 */

 //通过id查找货品
 function queryCargoById(id) {
    if (id == "") {
        return;
    }
    url = "";
    param = '{"id":"' + id + '"}';
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
        },
        error: function () {
        }
    });
 }

 //通过条件筛选.结果为List形式
 function queryCargo(cargo) {
     if (cargo == null) {
         return;
     }
     defaultSetting = {
         id : '',
         name : '',
         type : ''
     };
     $.extend(defaultSetting, cargo);
     param = 
        '{"id":"' + defaultSetting.id + '",'
         +'"name":"' + defaultSetting.name + '",'
         +'"type":"' + defaultSetting.type + '"}';
    url = "";
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
        },
        error: function () {
        }
    });
 }

 //添加货品

 //删除货品

 //更新货品

