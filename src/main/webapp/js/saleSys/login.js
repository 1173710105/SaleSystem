/**
 * login function, use for login
 * login.html
 */

window.onload = function () {
}

$("#login-btn").click(
    function () {
        var account = $("#account").val();
        var password = $("#password").val();
        var param;
        var url = "http://localhost:8080/exam/"; //TODO waiturl
        var destination = "" //网页跳转
        var type = $('#type').val();

        if (type == "clerk") {
            //TODO 登陆器
            url = url + "administrator/login"
            destination = destination + "ShopAssistant/HomeIndex.html"
            param = 
                '{"id":"' + account + '",'
                + '"password":"' + password + '",'
                + '"type":"clerk"}';
        } else if (type == "shop-manager") {
            url = url + "teacher/login"
            destination = destination + "ShopManager/HomeIndex.html"
            param = 
            '{"id":"' + account + '",'
            + '"password":"' + password + '",'
            + '"type":"shop-manager"}';
        } else {
            url = url + "student/login"
            destination = destination + "GeneralManager/HomeIndex.html"
            param = 
            '{"id":"' + account + '",'
            + '"password":"' + password + '",'
            + '"type":"general-manager"}';
        }
        if (account == null || account == "") {
            alert("账户不能为空");
            return;
        }
         
        loginajax = $.ajax({
            url: url,
            data: param,
            async: false,
            type: "post",
            dataType: "text",
            contentType: "application/json;charset=UTF-8",
            success: function (str) {
                if (str == "true") {
                    
                } else if (str == "wrongpwd") {
                    alert("密码错误，请重新输入");
                    return;
                } else {
                    alert("没有此账号");
                    return;
                }
            },
            error: function () {
            }
        });
        var secondrequest = 
            '{"id":"' + account +'"}';
        dataajax = $.ajax({
            url: url,
            data: secondrequest,
            async: false,
            type: "post",
            dataType: "text",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                if (data != null) {
                    //填充cookie
                    //会话 sessionid
                    //账号 id
                    //职位 position
                    setCookie("id", account);
                    setCookie("position", type);
                    setCookie("warehourseid", data.warehourseid);
                    setCookie("warehoursename", data.warehoursename);
                    setCookie("warehourselocation", data.warehourselocation);
                    setCookie("pricipalid", data.pricipalid);
                    setCookie("pricipalname", data.principalname);
                    setCookie("saleorderitemtable", data.saleorderitemtable);
                    setCookie("saleordercommontable", data.saleorderitemtable);
                    setCookie("stafftable", data.stafftable);
                    setCookie("warehoursedetailtable", data.warehoursedetailtable);
                    setCookie("itemtable", data.itemtable);
                    setCookie("time", data.time);
                } else {
                    alert("请求失败");
                }
            },
            error: function () {
            }
        });
        var thirdrequest = 
            '{"id":"' + account +'",'
            + '"tablename":"' + getCookie("stafftable") + '"}';
        dataajax = $.ajax({
            url: url,
            data: thirdrequest,
            async: false,
            type: "post",
            dataType: "text",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                if (data != null) {
                    //填充cookie
                    //用户名 name
                    setCookie("name", data.name);
                } else {
                    alert("请求失败");
                }
            },
            error: function () {
            }
        });
        $.when(loginajax, dataajax, personalajax).done(function() {
            top.location.href = destination;
        });
    });

$('.input input').on('focus', function () {
    $(this).parent().addClass('focus');
});

$('.input input').on('blur', function () {
    if ($(this).val() === '')
        $(this).parent().removeClass('focus');
});