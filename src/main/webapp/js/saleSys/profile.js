//个人信息页面
window.onload = function () {
    refreshProfile();
}

var tempPerson;

function refreshProfile() {
    $('#name').val(getCookie("principalname"));
    if (getCookie("type") == "clerk") {
        var staff = queryStaffById(getCookie("principalid"));
        tempPerson = staff;
        $('#gender').val(staff.gender);
        $('#id').val(staff.id);
        $('#position').val((getCookie("type") == "clerk") ? "店员" : (getCookie("type") == "shop-manager") ? "店长" : "总经理");
        $('#rep').val(getCookie("#warehoursename"));
        $('#phone').val(staff.phone);
        $('#email').val(staff.email);
    } else if (getCookie("type") == "shop-manager") {
        var shopmanager = queryManagerById(getCookie("principalid"));
        tempPerson = shopmanager;
        $('#gender').val(shopmanager.gender);
        $('#id').val(shopmanager.id);
        $('#position').val((getCookie("type") == "clerk") ? "店员" : (getCookie("type") == "shop-manager") ? "店长" : "总经理");
        $('#rep').val(getCookie("#warehoursename"));
        $('#phone').val(shopmanager.phone);
        $('#email').val(shopmanager.email);
    } else if (getCookie("type") == "general-manager") {
        var general = queryGManagerById(getCookie("principalid"));
        tempPerson = general;
        $('#gender').val(general.gender);
        $('#id').val(general.id);
        $('#position').val((getCookie("type") == "clerk") ? "店员" : (getCookie("type") == "shop-manager") ? "店长" : "总经理");
        $('#rep').val(getCookie("#warehoursename"));
        $('#phone').val(general.phone);
        $('#email').val(general.email);
    }
}

function loadModal() {
    $('#modal-id').val(tempPerson.id);
    $('#modal-name').val(tempPerson.name);
    $('#modal-gender').val(tempPerson.gender);
    $('#modal-phone').val(tempPerson.phone);
    $('#modal-email').val(tempPerson.email);
}

$('#edit-btn').click(function () {
    $('#profileModal').modal('show');
    loadModal();
});

$('#save-btn').click(function () {
    var obj = {
        id: $('#modal-id').val(),
        name: $('#modal-name').val(),
        gender: $('#modal-gender').val(),
        phone: $('#modal-phone').val(),
        email: $('#modal-email').val(),
        hourseid: getCookie("warehourseid")
    }
    $('#profileModal').modal('hide');

    (getCookie("type") == "clerk") ?
        (alert(updateStaff(obj)).info)
        : (getCookie("type") == "shop-manager") ?
            (alert(updateManager(obj)).info)
            : (alert(updateGManager(obj)).info);
});

$('#check-pwd').blur(function() {
    if($('#new-pwd').val() != $('#check-pwd').val()) {
        alert("两次密码应一致");
    }
});

$('#modify-btn').click(function() {
    if($('#new-pwd').val() != $('#check-pwd').val()) {
        alert("两次密码应一致");
        return;
    }
    var obj = {
        id : getCookie("principalid"),
        password : $('#new-pwd').val()
    }
    (getCookie("type") == "clerk") ?
        (alert(changeCPwd(obj)).info)
        : (getCookie("type") == "shop-manager") ?
            (alert(changeSPwd(obj)).info)
            : (alert(changeGPwd(obj)).info);
});