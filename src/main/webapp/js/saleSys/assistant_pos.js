//POS机操作
window.onload = function() {
    // if (getCookie("sessionid") == "") {
    // //登录
    // alert("未登录,请登录后操作");
    // window.location.href = "../login.html";
    // return;
    // }
}

$("#cargo-id").blur(function() {
    var cargoId = $(this).val();
    cargo = queryCargoById(cargoId);
    if (cargo == null) {
        return;
    }
    console.log(cargoId);
    document.getElementById('cargo-name').value = cargo.name;
});
