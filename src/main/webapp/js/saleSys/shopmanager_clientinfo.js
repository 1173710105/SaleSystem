var tempClientList = new Map();

window.onload = function () {
    var clientList = queryClient({ id: "" });
    for (var i = 0; i < clientList.length; i++) {
        this.tempClientList.set(clientList[i].id, clientList[i]);
    }
}

//搜索
$('#search-btn').click(function () {
    //判断
    //搜索
    client = {
        id: $('#search-client-id').val(),
        name: $('#search-client-name').val(),
        phone: $('#search-phone').val(),
        email: $('#search-email').val(),
        type: ""
    }
    var cl = queryClient(client);
    for (var i = 0; i < cl.length; i++) {
        this.tempClientList.set(cl[i].id, cl[i]);
    }
    loadClientList(cl);
});

//添加
$('#add-btn').click(function() {

    $('#modal-title').innerHTML = "用户添加";
});

//编辑
$('#edit-btn').click(function() {
    
    $('#modal-title').innerHTML = "用户编辑";
    
});


//保存模态框内容
$('#save-btn').click(function() {

});

//删除
$('#delete-btn').click(function() {

});

//加载列表
function loadClientList(cl) {
    var editTable = document.getElementById("temp-worder-tbody");
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
        td5.innerHTML = cl[i].type;
        var td6 = document.createElement("td");
        var editButton = document.createElement("button");
        editButton.type = "button";
        editButton.id = "edit-btn";
        editButton.setAttribute("value", cl[i].id); //将货品id封装在value中
        editButton.className = "btn btn-sm btn-primary";
        editButton.innerHTML = "编辑";
        td6.appendChild(editButton);
        var deleButton = document.createElement("button");
        deleButton.type = "button";
        deleButton.id = "delete-btn";
        deleButton.setAttribute("value", cl[i].id); //将货品id封装在value中
        deleButton.className = "btn btn-sm btn-danger";
        deleButton.innerHTML = "删除";
        td6.appendChild(deleButton);

        tr.appendChild(td0);
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
        tr.appendChild(td6);
        editTable.appendChild(tr);
    }
}