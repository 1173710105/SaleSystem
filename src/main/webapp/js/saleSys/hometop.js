/**
 * 用于首页顶部处理用户名显示和退出登录功能
 */
window.onload = function(){
    fillTopInfo();
}

function fillTopInfo() {
    //判断职位,显示不同欢迎语
    var position = getCookie("position");
    if (position == "staff") {
        $('#greeting').html("欢迎店员" + getCookie('name'));
    } else if(position == "shop-manager") {
        $('#greeting').html("欢迎店长" + getCookie('name'));
    } else if (position == "general-manager") {
        $('#greeting').html("欢迎经理" + getCookie('name'));
    }
}