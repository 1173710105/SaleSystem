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
            param = '{"id":"' + account + '","password":"'
                + password + '"}';
        } else if (type == "shop-manager") {
            url = url + "teacher/login"
            destination = destination + "ShopManager/HomeIndex.html"
            param = '{"id":"' + account + '","password":"' + password
                + '"}';
        } else {
            url = url + "student/login"
            destination = destination + "GeneralManager/HomeIndex.html"
            param = '{"id":"' + account + '","password":"' + password
                + '"}';
        }
        if (account == null || account == "") {
            alert("账户不能为空");
            return;
        }
        $.ajax({
            url: url,
            data: param,
            type: "post",
            dataType: "text",
            contentType: "application/json;charset=UTF-8",
            success: function (str) {
                if (str == "true") {
                    //填充cookie
                    //会话 sessionid
                    //账号 id
                    //用户名 name
                    //职位 position
                    top.location.href = destination;
                } else if (str == "false") {
                    alert("密码错误，请重新输入");
                } else {
                    alert("没有此账号")
                }
            },
            error: function () {
            }
        });
    });

$('.input input').on('focus', function () {
    $(this).parent().addClass('focus');
});

$('.input input').on('blur', function () {
    if ($(this).val() === '')
        $(this).parent().removeClass('focus');
});