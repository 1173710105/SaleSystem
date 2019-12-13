var tempClerkMap = new Map();

window.onload = function () {
    var clerkList = queryClient({ id: "" });
    for (var i = 0; i < clerkList.length; i++) {
        this.tempClerkMap.set(clerkList[i].id, clerkList[i]);
    }
}

//搜索
$('#search-btn').click(function () {
    //判断合法
    //搜索
    clerk = {
        id: $('#search-id').val(),
        name: $('#search-name').val(),
        phone: $('#search-phone').val(),
        email: $('#search-email').val(),
    }
    var cl = queryClient(clerk);
    for (var i = 0; i < cl.length; i++) {
        this.tempClerkMap.set(cl[i].id, cl[i]);
    }
    loadClerkList(cl);
});

//添加
$('#add-btn').click(function() {
    $('#clerkModal').modal('show'); //show modal
    $('#modal-title').innerHTML = "店员添加";
});

//编辑
$('#edit-btn').click(function() {
    $('#clerkModal').modal('show'); //show modal
    $('#modal-title').innerHTML = "店员编辑";
    var clerk = tempClerkMap.get($(this).id);
    $('client-id').val(clerk.id);
    $('clerk-name').val(client.name);
    $('clerk-gender').val(client.gender);
    $('clerk-phone').val(client.phone);
    $('clerk-email').val(client.email);
    $('clerk-rep').val(client.hourseid);
    $('clie-position').val("店员");
});


//保存模态框内容
$('#save-btn').click(function() {
    clerk = {
        id : $('clerk-id').val(),
        name : $('clerk-name').val(),
        gender : $('clerk-gender').val(),
        phone : $('clerk-phone').val(),
        email : $('clerk-email').val(),
        hourseid : $('clerk-rep').val()
    }
    if($('clerk-id').val() == "") {
        insertStaff(clerk);
    } else {
        updateStaff(clerk);
    }
});

//删除
$('#delete-btn').click(function() {
    var r = confirm("是否删除？");
    if (r == true) {
        //实现
        deleteStaff({id : $('client-id').val()});
        alert("删除成功");
    }
});

//加载列表
function loadClerkList(cl) {
    var editTable = document.getElementById("clerk-tbody");
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
        td5.innerHTML = cl[i].hourseid;
        var td6 = document.createElement("td");
        td6.innerHTML = "店员";
        var td7 = document.createElement("td");
        var editButton = document.createElement("button");
        editButton.type = "button";
        editButton.id = "edit-btn";
        editButton.setAttribute("value", cl[i].id); //将货品id封装在value中
        editButton.className = "btn btn-sm btn-primary";
        editButton.innerHTML = "编辑";
        td7.appendChild(editButton);
        var deleButton = document.createElement("button");
        deleButton.type = "button";
        deleButton.id = "delete-btn";
        deleButton.setAttribute("value", cl[i].id); //将货品id封装在value中
        deleButton.className = "btn btn-sm btn-danger";
        deleButton.innerHTML = "删除";
        td7.appendChild(deleButton);

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