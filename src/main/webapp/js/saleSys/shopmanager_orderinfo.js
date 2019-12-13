window.onload = function () {
    var historyList = queryWarehourseOrder({ sourceid: getCookie("id") });//TODO 获取门店id
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
        td2.innerHTML = ol[i].clientid;
        var td3 = document.createElement("td");
        td3.innerHTML = ol[i].sourceid;
        var td4 = document.createElement("td");
        td4.innerHTML = ol[i].receiverprincipleid;
        var td5 = document.createElement("td");
        td5.innerHTML = ol[i].status;
        var td6 = document.createElement("td");
        td6.innerHTML = ol[i].createtime;
        var td7 = document.createElement("td");
        //未申请
        //添加编辑按钮,发起申请按钮,删除按钮
        if  ol[i].status == "") {
            var editButton = document.createElement("button");
            editButton.type = "button";
            editButton.id = "edit-btn";
            editButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            editButton.className = "btn btn-sm btn-primary";
            editButton.innerHTML = "编辑";
            td7.appendChild(editButton);

            var applyButton = document.createElement("button");
            applyButton.type = "button";
            applyButton.id = "apply-btn";
            applyButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            applyButton.className = "btn btn-sm btn-primary";
            applyButton.innerHTML = "发起申请";
            td7.appendChild(applyButton);

            var deleButton = document.createElement("button");
            deleButton.type = "button";
            deleButton.id = "delete-btn";
            deleButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            deleButton.className = "btn btn-sm btn-danger";
            deleButton.innerHTML = "删除";
            td7.appendChild(deleButton);
        }
        //审核中 已通过
        //添加详情按钮
        else if  ol[i].status == "" || ol[i].status == "") {
            var detailButton = document.createElement("button");
            detailButton.type = "button";
            detailButton.id = "detail-btn";
            detailButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            detailButton.className = "btn btn-sm btn-primary";
            detailButton.innerHTML = "详情";
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

//刷新模态框，传入list对象

//条件搜索

//添加订单

//审核订单
$('#check_btn').click(function () {
    var r = confirm("是否审核通过？");
    if (r == true) {
        alert("审核通过");
    }
});

//订单付款

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

//弹出订单退货

//保存订单货品修改

//保存订单

//数据转换，将接收数据转换为list<map>