//缓存映射
var tempOrderMap = new Map();

window.onload = function () {
    var historyList = queryOrder({ sourceid: getCookie("id") });//TODO 获取门店id
    // loadWarehourseOrderList(historyList);
    // for (var i = 0; i < historyList.length; i++) {
    //     tempWareOrderMap.set(historyList[i].id, historyList[i]);
    // }
}

//刷新订单列表，传入请求的list对象
function loadOrderList(ol) {
    var editTable = document.getElementById("order-tbody");
    for (var i = 0; i < ol.length; i++) {
        //增加表格
        var tr = document.createElement("tr");
        tr.setAttribute("id", ol[i].id);
        var td0 = document.createElement("td");
        td0.innerHTML = ol[i].id;
        var td1 = document.createElement("td");
        td1.innerHTML = ol[i].type;
        var td2 = document.createElement("td");
        td2.innerHTML = ol[i].clientname;
        var td3 = document.createElement("td");
        td3.innerHTML = ol[i].sumprice;
        var td4 = document.createElement("td");
        td4.innerHTML = ol[i].status;
        var td5 = document.createElement("td");
        td5.innerHTML = ol[i].principalname;
        var td6 = document.createElement("td");
        td6.innerHTML = ol[i].warehoursename;
        var td7 = document.createElement("td");
        td7.innerHTML = ol[i].createtime;
        var td8 = document.createElement("td");
        //草稿
        //添加审核按钮,编辑按钮,删除按钮
        if (ol[i].status == "1") {
            var editButton = document.createElement("button");
            editButton.type = "button";
            editButton.id = "check-btn";
            editButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            editButton.className = "btn btn-sm btn-primary";
            editButton.innerHTML = "审核";
            td8.appendChild(editButton);

            var applyButton = document.createElement("button");
            applyButton.type = "button";
            applyButton.id = "edit-btn";
            applyButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            applyButton.className = "btn btn-sm btn-primary";
            applyButton.innerHTML = "编辑";
            td8.appendChild(applyButton);

            var deleButton = document.createElement("button");
            deleButton.type = "button";
            deleButton.id = "delete-btn";
            deleButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            deleButton.className = "btn btn-sm btn-danger";
            deleButton.innerHTML = "删除";
            td8.appendChild(deleButton);
        }
        //已审核，未付款
        //添加详情按钮，付款按钮，退货按钮
        else if (ol[i].status == "") {
            var editButton = document.createElement("button");
            editButton.type = "button";
            editButton.id = "detail-btn";
            editButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            editButton.className = "btn btn-sm btn-primary";
            editButton.innerHTML = "详情";
            td8.appendChild(editButton);

            var applyButton = document.createElement("button");
            applyButton.type = "button";
            applyButton.id = "pay-btn";
            applyButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            applyButton.className = "btn btn-sm btn-primary";
            applyButton.innerHTML = "付款";
            td8.appendChild(applyButton);

            var deleButton = document.createElement("button");
            deleButton.type = "button";
            deleButton.id = "return-btn";
            deleButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            deleButton.className = "btn btn-sm btn-danger";
            deleButton.innerHTML = "退货";
            td8.appendChild(deleButton);
        }
        //已审核，已付款
        //添加详情按钮，退货按钮
        else if (ol[i].status == "") {
            var editButton = document.createElement("button");
            editButton.type = "button";
            editButton.id = "detail-btn";
            editButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            editButton.className = "btn btn-sm btn-primary";
            editButton.innerHTML = "详情";
            td8.appendChild(editButton);

            var deleButton = document.createElement("button");
            deleButton.type = "button";
            deleButton.id = "return-btn";
            deleButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            deleButton.className = "btn btn-sm btn-danger";
            deleButton.innerHTML = "退货";
            td8.appendChild(deleButton);
        }
        //已退货
        //添加详情按钮
        else if (ol[i].status == "") {
            var editButton = document.createElement("button");
            editButton.type = "button";
            editButton.id = "detail-btn";
            editButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            editButton.className = "btn btn-sm btn-primary";
            editButton.innerHTML = "详情";
            td8.appendChild(editButton);
        }
        tr.appendChild(td0);
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
        tr.appendChild(td6);
        tr.appendChild(td7);
        tr.appendChild(td8);
        editTable.appendChild(tr);
    }
}

//刷新模态框，传入list对象
function loadMadal(ol, type) {
    var common = ol[0];
    $('#client-id').val(common.get("clientid"));
    $('#client-name').val(common.get("clientname"));
    $('#order-type').val(common.get("type"));
    $('#order-position').val(common.get("warehoursename"));
    $('#principal-name').val(common.get("principalname"));

    var editTable = document.getElementById("temp-cargo-tbody");
    for (cargo in ol) {
        var tr = document.createElement("tr");
        tr.setAttribute("id", ol[i].get("id"));
        var td0 = document.createElement("td");
        td0.innerHTML = ol[i].get("itemname");
        var td1 = document.createElement("td");
        td1.innerHTML = ol[i].get("itemid");
        var td2 = document.createElement("td");
        td2.innerHTML = ol[i].get("itemnum");
        var td3 = document.createElement("td");
        td3.innerHTML = ol[i].get("perprice");
        var td4 = document.createElement("td");
        td4.innerHTML = ol[i].get("sumprice");
        var td5 = document.createElement("td");
        var deleButton = document.createElement("button");
        deleButton.type = "button";
        deleButton.id = "temp-delete-btn";
        deleButton.setAttribute("value", ol[i].get("id")); //将货品id封装在value中
        deleButton.className = "btn btn-sm btn-danger";
        deleButton.innerHTML = "删除";
        td5.appendChild(deleButton);
        tr.appendChild(td0);
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
        editTable.appendChild(tr);
    }
}

//条件搜索
$('#search-btn').click(function() {
    var order = {
        id : $('#search-order-id').val(),
        clientid : $('#search-client-id').val(),
        type : $('#search-cargo-type').val(),
        paystatus : $('#search-pay').val(),
        checkstatus : $('#search-status').val(),
    }
    var queryList = queryOrder(order);
    loadOrderList(queryList);
});

//添加订单
$('#add-order-btn').click(function() {
    $('#orderModifyModal').modal('show');
    $('#principal-name').val(getCookie("name"));
    $('#order-postion').val(getCookie("warehourseid")); //获得仓库
});


//审核订单
$('#check_btn').click(function () {
    var r = confirm("是否审核通过？");
    if (r == true) {
        var id = $(this).val();
        checkOrder(id);
        alert("审核通过");
    }
});

//订单付款
//Map<orderid : List<Map<key:value>>>


//订单删除
$('#delete_btn').click(function () {
    var r = confirm("是否删除？");
    if (r == true) {
        
        alert("删除成功");
    }
});

//订单退货

//弹出订单详情

//弹出编辑订单

//弹出订单付款
$('#pay-btn').click(function() {
    $('#orderPayModal').modal('show');
    var orderid = $(this).val();
    var order = tempOrderMap.get(orderid);
    $('#pay-client-name').val(order[0].get("clientname"));
    $('#pay-pricinpal-name').val(order[0].get("pricinpalname"));
    $('#pay-total-price').val(order[0].get("sumprice"));
    var editTable = document.getElementById("temp-cargo-tbody");
    for (cargo in order) {
        var tr = document.createElement("tr");
        tr.setAttribute("id", ol[i].get("id"));
        var td0 = document.createElement("td");
        td0.innerHTML = ol[i].get("itemname");
        var td1 = document.createElement("td");
        td1.innerHTML = ol[i].get("itemid");
        var td2 = document.createElement("td");
        td2.innerHTML = ol[i].get("itemnum");
        var td3 = document.createElement("td");
        td3.innerHTML = ol[i].get("perprice");
        var td4 = document.createElement("td");
        td4.innerHTML = ol[i].get("sumprice");
        tr.appendChild(td0);
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        editTable.appendChild(tr);
    }
});

//弹出订单退货

//保存订单货品修改

//保存订单

//数据转换，将接收数据转换为list<map>
//将单个对象转换
function object2map(order) {

}