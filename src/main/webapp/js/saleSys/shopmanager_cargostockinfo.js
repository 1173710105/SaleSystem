//店长进货页面
window.onload = function () {
    var historyList = queryWarehourseOrder({ sourceid: getCookie("id") });//TODO 获取门店id
    // loadWarehourseOrderList(historyList);
    // for (var i = 0; i < historyList.length; i++) {
    //     tempWareOrderMap.set(historyList[i].id, historyList[i]);
    // }
}

//订货单和id映射表
var tempWareOrderMap = new Map();
//订单货品暂存列表
var cargoList = [];
//订单货品数量暂存列表
var cargoNum = [];

//加载进货信息
function loadWarehourseOrderList(worderList) {
    var editTable = document.getElementById("worder-tbody");
    for (var i = 0; i < worderList.length; i++) {
        //增加表格
        var tr = document.createElement("tr");
        tr.setAttribute("id", worderList[i].id);
        var td0 = document.createElement("td");
        td0.innerHTML = worderList[i].id;
        var td1 = document.createElement("td");
        td1.innerHTML = worderList[i].sumprice;
        var td2 = document.createElement("td");
        td2.innerHTML = worderList[i].targetid;
        var td3 = document.createElement("td");
        td3.innerHTML = worderList[i].sourceid;
        var td4 = document.createElement("td");
        td4.innerHTML = worderList[i].receiverprincipleid;
        var td5 = document.createElement("td");
        td5.innerHTML = worderList[i].status;
        var td6 = document.createElement("td");
        td6.innerHTML = worderList[i].createtime;
        var td7 = document.createElement("td");
        //未申请
        //添加编辑按钮,发起申请按钮,删除按钮
        if (worderList[i].status == "") {
            var editButton = document.createElement("button");
            editButton.type = "button";
            editButton.id = "edit-btn";
            editButton.setAttribute("value", worderList[i].id); //将货品id封装在value中
            editButton.className = "btn btn-sm btn-primary";
            editButton.innerHTML = "编辑";
            td7.appendChild(editButton);

            var applyButton = document.createElement("button");
            applyButton.type = "button";
            applyButton.id = "apply-btn";
            applyButton.setAttribute("value", worderList[i].id); //将货品id封装在value中
            applyButton.className = "btn btn-sm btn-primary";
            applyButton.innerHTML = "发起申请";
            td7.appendChild(applyButton);

            var deleButton = document.createElement("button");
            deleButton.type = "button";
            deleButton.id = "delete-btn";
            deleButton.setAttribute("value", worderList[i].id); //将货品id封装在value中
            deleButton.className = "btn btn-sm btn-danger";
            deleButton.innerHTML = "删除";
            td7.appendChild(deleButton);
        }
        //审核中 已通过
        //添加详情按钮
        else if (worderList[i].status == "" || worderList[i].status == "") {
            var detailButton = document.createElement("button");
            detailButton.type = "button";
            detailButton.id = "detail-btn";
            detailButton.setAttribute("value", worderList[i].id); //将货品id封装在value中
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

//搜索
$('#search-btn').click(function () {
    var s_orderid = $('#search-order-id').val().toString();
    var s_cargoid = $('#search-cargo-id').val().toString();
    var s_ordersource = $('#search-order-source').val();
    var s_status = $('#search-status').val();
    worder = {
        id: s_orderid,
        itemid: s_cargoid,
        sourceid: s_ordersource,
        status: s_status
    }
    var queryList = queryWarehourseOrder(worder);
    for (var i = 0; i < queryList.length; i++) {
        tempWareOrderMap.set(queryList[i].id, queryList[i]);
    }
    loadWarehourseOrderList(queryList);
});

//添加进货
$('#add-btn').click(function () {
    $('#stockAddModal').modal('show'); //show modal
    loadModal("add", null);
});

//编辑进货
$('#edit-btn').click(function () {
    $('#stockAddModal').modal('show'); //show modal
    var id = $(this).val();
    loadModal("edit", tempWareOrderMap.get(id));
});

//进货详细
$('#detail-btn').click(function () {
    $('#stockAddModal').modal('show'); //show modal
    var id = $(this).val();
    loadModal("detail", tempWareOrderMap.get(id));
});

//加载模态框
function loadModal(type, order) {
    switch (type) {
        case "add": {
            $('.div-oid')[0].style.display = "none";
            $('.modal-foot')[0].style.display = "";
            $('.save-btn')[0].style.display = "";
            break;
        }
        case "edit": {
            $('.div-oid')[0].style.display = "";
            $('.modal-foot')[0].style.display = "";
            $('.save-btn')[0].style.display = "";
            $('#order-id').val(order.id);
            $('#order-stock-position').val(order.targetid);
            $('#order-source-position').val(order.sourceid);
            $('#order-principal').val(order.receiverprincipleid);
            //填充表格
            var editTable = document.getElementById("temp-worder-tbody");
            for (var i = 0; i < 5; i++) {
                cargoList.push(); //加入暂存
                var tr = document.createElement("tr");
                tr.setAttribute("id", "temp-tr");
                var td0 = document.createElement("td");
                td0.innerHTML = "";//name;
                var td1 = document.createElement("td");
                td1.innerHTML = "";//code;
                var td2 = document.createElement("td");
                td2.innerHTML = "";//num;
                var td3 = document.createElement("td");
                td3.innerHTML = "";//single;
                var td4 = document.createElement("td");
                td4.innerHTML = "";//sum;
                var td5 = document.createElement("td");
                deleButton = document.createElement("button");
                deleButton.type = "button";
                deleButton.id = "temp-delete-btn";
                deleButton.setAttribute("value", ""); //将仓库单货品id封装在value中
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
            break;
        }
        case "detail": {
            $('.div-oid')[0].style.display = "";
            $('.modal-foot')[0].style.display = "none";
            $('.save-btn')[0].style.display = "none";
            $('#order-id').val(order.id);
            $('#order-stock-position').val(order.targetid);
            $('#order-source-position').val(order.sourceid);
            $('#order-principal').val(order.receiverprincipleid);
            //填充表格
            var editTable = document.getElementById("temp-worder-tbody");
            for (var i = 0; i < 5; i++) {
                var tr = document.createElement("tr");
                tr.setAttribute("id", "temp-tr");
                var td0 = document.createElement("td");
                td0.innerHTML = "";//name;
                var td1 = document.createElement("td");
                td1.innerHTML = "";//code;
                var td2 = document.createElement("td");
                td2.innerHTML = "";//num;
                var td3 = document.createElement("td");
                td3.innerHTML = "";//single;
                var td4 = document.createElement("td");
                td4.innerHTML = "";//sum;

                tr.appendChild(td0);
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);
                tr.appendChild(td4);
                editTable.appendChild(tr);
            }
            break;
        }
    }
}

//删除订单
$('#delete-btn').click(function () {
    var r = confirm("是否删除？");
    if (r == true) {
        alert("删除成功");
    }
});

//删除货品
//删除暂存列表中货品



//添加货品到订货单
$('#add-cargo-btn').click(function () {
    var cargoid = "0";
    var cargonum = "0";
    var cargo = null;

    cargoList.push(cargo);
    cargoNum.push(cargonum);

    var tr = document.createElement("tr");
    tr.setAttribute("id", "temp-tr");
    var td0 = document.createElement("td");
    td0.innerHTML = "";//name;
    var td1 = document.createElement("td");
    td1.innerHTML = "";//code;
    var td2 = document.createElement("td");
    td2.innerHTML = "";//num;
    var td3 = document.createElement("td");
    td3.innerHTML = "";//single;
    var td4 = document.createElement("td");
    td4.innerHTML = "";//sum;
    var td5 = document.createElement("td");
    deleButton = document.createElement("button");
    deleButton.type = "button";
    deleButton.id = "temp-delete-btn";
    deleButton.setAttribute("value", ""); //将仓库单货品id封装在value中
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
});

//发起申请
$('#apply-btn').click(function() {
    var r = confirm("是否发起申请，发起后单据不可修改？");
    if (r == true) {
        var worderId = $(this).val();
        applyWarehourseOrder(worderId);
    }
});

//保存,编辑保存,插入保存
$('#save-btn').click(function() {
    //统一将暂存列表中货品写入
    jsonList = [];
    cargoList.forEach(function(witemOrder) {
        
    });
});


