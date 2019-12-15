//员工对象操作

defaultSetting = {
    id : '',
    password : '',
    hourseid : '',
    name : '',
    gender : '',
    phone : '',
    email : '',
    tablename : ''
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

//通过id查找员工
function queryStaffById(id, tablename) {
    if (id == "") {
        return;
    }
    param = 
       '{"id":"' + id + '",'
       + '"tablename":"' + tablename + '"}';
    url = "/staff/queryById";
    return sendJsonAjax(url, param);
}

//通过条件筛选员工
function queryStaff(staff) {
    if (staff == null) {
        return null;
    }
    combineStaff = $.extend({},defaultSetting, staff);
    param = 
       '{'
        + '"id":"' + combineStaff.id + '",'
        + '"name":"' + combineStaff.name + '",'
        + '"gender:"' + combineStaff.gender + '",'
        + '"phone":"' + combineStaff.phone + '",'
        + '"email":"' + combineStaff.email + '",'
        + '"tablename":"' + combineStaff.tablename + '",'
        + '"hourseid":"' + combineStaff.hourseid + '"}';
    url = "/staff/query";
    return sendJsonAjax(url, param);
}

//增加员工
function insertStaff(staff) {
    if (staff == null) {
        return null;
    }
    combineStaff = $.extend({},defaultSetting, staff);
    param = 
    '{'
    + '"id":"' + combineStaff.id + '",'
    + '"name":"' + combineStaff.name + '",'
    + '"gender:"' + combineStaff.gender + '",'
    + '"phone":"' + combineStaff.phone + '",'
    + '"email":"' + combineStaff.email + '",'
    + '"tablename":"' + combineStaff.tablename + '",'
    + '"hourseid":"' + combineStaff.hourseid + '"}';
    url = "/staff/add";
    return sendJsonAjax(url, param);
}

//删除员工
function deleteStaff(id) {
    if (id == "") {
        return null;
    }
    param = 
       '{"id":"' + id + '"}';
    url = "/staff/delete";
    return sendJsonAjax(url, param);
}

//更新员工
function updateStaff(staff) {
    if (staff == null) {
        return null;
    }
    combineStaff = $.extend({},defaultSetting, staff);
    param = 
    '{'
    + '"id":"' + combineStaff.id + '",'
    + '"name":"' + combineStaff.name + '",'
    + '"gender:"' + combineStaff.gender + '",'
    + '"phone":"' + combineStaff.phone + '",'
    + '"email":"' + combineStaff.email + '",'
    + '"tablename":"' + combineStaff.tablename + '",'
    + '"hourseid":"' + combineStaff.hourseid + '"}';
    url = "/staff/update";
    return sendJsonAjax(url, param);
}