/**
 * 货物有关请求和操作
 */

var tempdata; 

defaultSetting = 
{
    id : '',
    name : '',
    type : '',
    specification : '',
    picture : '',
    retailprice : '',
    wholesaleprice : '',
    purchaseprice : '', //进货价
    tablename : ''
}

function sendJsonAjax(url, param) {
    $.ajax({
        url: url,
        data: param,
        type: "post",
        dataType: "JSON",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            if (data != null) {
            	console.log("cargo json receive : ", data);
            	tempdata = data;
                //return data;
            }
            return null;
        },
        error: function () {
        }
    });
 }

 //通过id查找货品
 function queryCargoById(id, tablename) {
    if (id == "") {
        return;
    }
    url = "/cargo/queryById";
    param = 
        '{"id":"' + id + '",'
        + '"tablename":"' + tablename + "}";       
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
        + '"purchaseprice":"' + combineCargo.purchaseprice +'",'
        + '"tablename":"' + combineCargo.tablename + '"}';
    url = "/cargo/query";
    $.ajaxSettings.async = false;
    sendJsonAjax(url, param);
    console.log("send cargo query : ", param);
    console.log("query cargo : " , tempdata);
    //return sendJsonAjax(url, param);
    return tempdata;
 }

 //添加货品
function insertCargo(cargo) {
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
    + '"purchaseprice":"' + combineCargo.purchaseprice +'",'
    + '"tablename":"' + combineCargo.tablename + '"}';
   url = "/cargo/insert";
  return sendJsonAjax(url, param);
}

 //删除货品
function deleteCargo(tid, ttablename) {
    if (tid == "") {
        return;
    }
    cargo = {
    		id :tid,
    		tablename : ttablename
    }
    url = "/cargo/delete";
    combineCargo = $.extend({},defaultSetting, cargo);
    param = 
    '{"id":"' + combineCargo.id +'",'
    + '"name":"' + combineCargo.name +'",'
    + '"type":"' + combineCargo.type +'",'
    + '"specification":"' + combineCargo.specification +'",'
    + '"picture":"' + combineCargo.picture +'",'
    + '"retailprice":"' + combineCargo.retailprice +'",'
    + '"wholesaleprice":"' + combineCargo.wholesaleprice +'",'
    + '"purchaseprice":"' + combineCargo.purchaseprice +'",'
    + '"tablename":"' + combineCargo.tablename + '"}';
    console.log("delete cargo : " , param);
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
    + '"purchaseprice":"' + combineCargo.purchaseprice +'",'
    + '"tablename":"' + combineCargo.tablename + '"}';
    console.log("update cargo : " , param);
   url = "/cargo/update";
  return sendJsonAjax(url, param);
}

/**
 * 计算货品毛利润
 * @param {List} cargoList 货品列表 
 * @param {List} cargoNumL 数量列表
 * @param {List} type 价格种类,1表示零售,2表示批发
 */
function calculateMargin(cargoList, cargoNumL, type) {
    var margin = 0;
    if (type == 1) {
        for (var i = 0; i < cargoList.length; i++) {
            margin += (cargoList[i].retailprice - cargoList[i].purchaseprice) * cargoNumL[i];
        }
    } else if (type == 2) {
        for (var i = 0; i < cargoList.length; i++) {
            margin += (cargoList[i].wholesaleprice - cargoList[i].purchaseprice) * cargoNumL[i];
        }
    }
    return margin;
}
