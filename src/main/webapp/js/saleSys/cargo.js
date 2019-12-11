/**
 * 货物有关请求和操作
 */

defaultSetting = {
    id : '',
    name : '',
    type : '',
    specification : '',
    picture : '',
    retailprice : '',
    wholesaleprice : '',
    purchaseprice : ''
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

 //通过id查找货品
 function queryCargoById(id) {
    if (id == "") {
        return;
    }
    url = "";
    param = '{"id":"' + id + '"}';
    return sendJsonAjax(url, param);
 }

 //通过条件筛选.结果为List形式
 function queryCargo(cargo) {
     if (cargo == null) {
         return;
     }
     combineCargo = $.extend({},defaultSetting, cargo);
     param = 
        '{"id":"' + combineCargo.id +'",'
        + '"name":"' + combineCargo.name +'",'
        + '"type":"' + combineCargo.type +'",'
        + '"specification":"' + combineCargo.specification +'",'
        + '"picture":"' + combineCargo.picture +'",'
        + '"retailprice":"' + combineCargo.retailprice +'",'
        + '"wholesaleprice":"' + combineCargo.wholesaleprice +'",'
        + '"purchaseprice":"' + combineCargo.purchaseprice +'"}';
    url = "";
   return sendJsonAjax(url, param);
 }

 //添加货品
function addCargo(cargo) {
    if (cargo == null) {
        return;
    }
    combineCargo = $.extend({},defaultSetting, cargo);
    param = 
       '{"id":"' + combineCargo.id +'",'
       + '"name":"' + combineCargo.name +'",'
       + '"type":"' + combineCargo.type +'",'
       + '"specification":"' + combineCargo.specification +'",'
       + '"picture":"' + combineCargo.picture +'",'
       + '"retailprice":"' + combineCargo.retailprice +'",'
       + '"wholesaleprice":"' + combineCargo.wholesaleprice +'",'
       + '"purchaseprice":"' + combineCargo.purchaseprice +'"}';
   url = "";
  return sendJsonAjax(url, param);
}

 //删除货品
function deleteCargo(id) {
    if (id == "") {
        return;
    }
    url = "";
    param = '{"id":"' + id + '"}';
    return sendJsonAjax(url, param);
}

 //更新货品
function updateCargo(cargo) {
    if (cargo == null) {
        return;
    }
    combineCargo = $.extend({},defaultSetting, cargo);
    param = 
       '{"id":"' + combineCargo.id +'",'
       + '"name":"' + combineCargo.name +'",'
       + '"type":"' + combineCargo.type +'",'
       + '"specification":"' + combineCargo.specification +'",'
       + '"picture":"' + combineCargo.picture +'",'
       + '"retailprice":"' + combineCargo.retailprice +'",'
       + '"wholesaleprice":"' + combineCargo.wholesaleprice +'",'
       + '"purchaseprice":"' + combineCargo.purchaseprice +'"}';
   url = "";
  return sendJsonAjax(url, param);
}
