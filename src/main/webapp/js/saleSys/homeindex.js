
window.onload = function() {
    //TODO 添加职位过滤
    var position = $('#type').val();
    if(postion != getCookie("position")) {
        alert("");
        window.location.href = "../login.html";
        return;
    }
    // if (getCookie("sessionid") == "") {
    // //登录
    // alert("未登录,请登录后操作");
    // window.location.href = "../login.html";
    // return;
    // }
}
