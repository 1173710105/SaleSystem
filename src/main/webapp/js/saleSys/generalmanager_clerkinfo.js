window.onload = function () {
    this.refreshClerkList();
    this.document.getElementById('search-rep').innerHTML = '<option value="">未分配</option>' + this.buildWMenuOptionNoBaseHTML();
    this.document.getElementById('clerk-rep').innerHTML = '<option value="">无</option>' + this.buildWMenuOptionNoBaseHTML();
    this.tempRep = this.queryWarehourseMenu();
}

var tempRep;
var tempClerkMap = new Map();
var tempManagerMap = new Map();
var preRep;

function cleanModal() {
    $('#modal-title').innerHTML = "店员编辑";
}

//加载列表
function loadClerkList(cl) {
    var editTable = document.getElementById("clerk-tbody");
    editTable.innerHTML = "";
    for (var i = 0; i < cl.length; i++) {
        var tr = document.createElement("tr");
        tr.setAttribute("id", cl[i].id);
        var td0 = document.createElement("td");
        td0.innerHTML = cl[i].id;
        var td1 = document.createElement("td");
        td1.innerHTML = cl[i].name;
        var td2 = document.createElement("td");
        td2.innerHTML = cl[i].gender;
        var td3 = document.createElement("td");
        td3.innerHTML = cl[i].phone;
        var td4 = document.createElement("td");
        td4.innerHTML = cl[i].email;
        var td5 = document.createElement("td");
        td5.innerHTML = tempRep.get(cl[i].hourseid);
        var td6 = document.createElement("td");
        td6.innerHTML = cl[i].position == "staff" ? "店员" : "店长";
        var td7 = document.createElement("td");
        var editButton = document.createElement("button");
        editButton.type = "button";
        editButton.id = "edit-btn";
        editButton.setAttribute("value", cl[i].id); //将id封装在value中
        editButton.className = "btn btn-sm btn-primary";
        editButton.innerHTML = "编辑";

        var deleButton = document.createElement("button");
        deleButton.type = "button";
        deleButton.id = "delete-btn";
        deleButton.setAttribute("value", cl[i].id); //将id封装在value中
        deleButton.className = "btn btn-sm btn-danger";
        deleButton.innerHTML = "删除";

        detailButton.type = "button";
        detailButton.id = "delete-btn";
        detailButton.setAttribute("value", cl[i].id); //将id封装在value中
        detailButton.className = "btn btn-sm btn-danger";
        detailButton.innerHTML = "删除";

        if (cl[i].position == "shop-manager") {
            td7.appendChild(editButton);
            td7.appendChild(deleteButton);
        } else if (cl[i].position == "staff") {
            td7.appendChild(detailButton);
        }
        tr.appendChild(td0);
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
        tr.appendChild(td6);
        tr.appendChild(td7);

        editTable.appendChild(tr);
    }
}

function cleanList() {
    document.getElementById("clerk-tbody").innerHTML = "";
}

function refreshClerkList() {
    cleanList();
    clerk = {
        id: $('#search-id').val(),
        name: $('#search-name').val(),
        phone: $('#search-phone').val(),
        email: $('#search-email').val(),
        hourseid: $('#search-rep').val()
    }
    var clerkList = [];
    if ($('#search-position').val() == "staff") {
        var tl = queryStaff(clerk);
        for (var i in tl) {
            tl[i][position] = "staff";
        }
        clerkList.concat(tl);
    } else if ($('#search-position').val() == "shop-manager") {
        var tl = queryManager(clerk);
        for (var i in tl) {
            tl[i][position] = "shop-manager";
        }
        clerkList.concat(tl);
    } else if ($('#search-position').val() == "") {
        var tl = queryStaff(clerk);
        for (var i in tl) {
            tl[i][position] = "staff";
        }
        clerkList.concat(tl);
        tl = queryManager(clerk);
        for (var i in tl) {
            tl[i][position] = "shop-manager";
        }
        clerkList.concat(tl);
    }
    for (var i = 0; i < clerkList.length; i++) {
        this.tempClerkMap.set(clerkList[i].id.toString(), clerkList[i]);
    }
    loadClerkList(clerkList);
}

//搜索
$('#search-btn').click(function () {
    refreshClerkList();
});

//弹出添加店长
$('#add-btn').click(function () {
    $('#clerkModal').modal('show'); //show modal
    modal.find('.modal-title').text("添加店长");
    $('.modal-footer')[0].style.display = "block";
    document.getElementById('clerk-rep').removeAttribute("readonly");
});

//编辑
$(document).on('click', '#edit-btn', function () {
    $('#clerkModal').modal('show'); //show modal
    modal.find('.modal-title').text("编辑店长");
    $('.modal-footer')[0].style.display = "block";
    document.getElementById('clerk-rep').removeAttribute("readonly");

    var clerk = tempClerkMap.get($(this).val());
    $('#clerk-id').val(clerk.id);
    $('#clerk-name').val(clerk.name);
    $('#clerk-gender').val(clerk.gender);
    $('#clerk-phone').val(clerk.phone);
    $('#clerk-email').val(clerk.email);
    $('#clerk-rep').val(clerk.hourseid);
});

//店员详情
$(document).on('click', '#detail-btn', function () {
    $('#clerkModal').modal('show'); //show modal
    modal.find('.modal-title').text("店员详情");
    $('.modal-footer')[0].style.display = "none";
    document.getElementById('clerk-rep').setAttribute("readonly", "readonly");

    var clerk = tempClerkMap.get($(this).val());
    $('#clerk-id').val(clerk.id);
    $('#clerk-name').val(clerk.name);
    $('#clerk-gender').val(clerk.gender);
    $('#clerk-phone').val(clerk.phone);
    $('#clerk-email').val(clerk.email);
    $('#clerk-rep').val(clerk.hourseid);
    $('#clerk-position').val("staff");
});

$("#clerk-rep").change(function () {
    preRep = $(this).val();
});

//保存模态框内容
$('#save-btn').click(function () {
    if ($('#clerk-id').val() == "" && $('#clerk-rep').val() != "") {
        var clerk = {
            id: $('#clerk-id').val(),
            name: $('#clerk-name').val(),
            gender: $('#clerk-gender').val(),
            phone: $('#clerk-phone').val(),
            email: $('#clerk-email').val(),
            hourseid: ''
        }
        //先插入店长，在更新映射关系
        insertManager(clerk);
        clerk = {
            id: $('#clerk-id').val(),
            hourseid: $('#clerk-rep').val()
        }
        //更新
        var info;
        if ((info = assignManager(clerk)) != "任命成功") {
            alert(info);
        }
        $('#clerkModal').modal('hide');
    } else {
        var clerk = {
            id: $('#clerk-id').val(),
            name: $('#clerk-name').val(),
            gender: $('#clerk-gender').val(),
            phone: $('#clerk-phone').val(),
            email: $('#clerk-email').val(),
            hourseid: ''
        }
        updateManager(clerk);
        //更新
        if (preRep != $('#clerk-rep').val()) {
            clerk = {
                id: $('#clerk-id').val(),
                hourseid: $('#clerk-rep').val()
            }
            var info;
            if ((info = assignManager(clerk)) != "任命成功") {
                alert(info);
            }
        }
        $('#clerkModal').modal('hide');
    }
    refreshClerkList();
});

//删除
$(document).on('click', '#delete-btn', function () {
    if (confirm("是否删除？")) {
        //实现
        deleteManager(
            {
                id: $(this).val(),
                hourseid: tempClerkMap.get($(this).val().hourseid)
            });
        refreshClerkList();
    }
});

//清除模态框内容
$('body').on('hidden.bs.modal', '.modal', function () {
    $('#clerk-form').reset();
});