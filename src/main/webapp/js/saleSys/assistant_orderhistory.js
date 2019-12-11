/**
 * 店员历史订单记录
 */

window.onload = function () {
    //加载历史订单
    var orderList = null;
    //var orderList = this.queryOrder({owner : this.getCookie("id").toString()});
    loadOrderList(orderList);

}

//加载订单列表
function loadOrderList(orderList) {
    var editTable = document.getElementById("order-tbody");
    for (var i = 0; i < 5; i++) {
        //增加表格
        var tr = document.createElement("tr");
        tr.setAttribute("id", "1002");
        var td0 = document.createElement("td");
        td0.innerHTML = "10";
        var td1 = document.createElement("td");
        td1.innerHTML = "lkjlkjlkjl";
        var td2 = document.createElement("td");
        td2.innerHTML = "a2";
        var td3 = document.createElement("td");
        td3.innerHTML = "a3";
        var td4 = document.createElement("td");
        td4.innerHTML = "lkj";
        var td5 = document.createElement("td");
        td5.innerHTML = "lkj";
        var td6 = document.createElement("td");
        td6.innerHTML = tr.val;
        var td7 = document.createElement("td");
        var button = document.createElement("button");
        button.type = "button";
        button.id = "detail-btn";
        button.setAttribute("value", "1001"); //将货品id封装在value中
        button.className = "btn btn-sm btn-primary";
        button.innerHTML = "详情";
        td7.appendChild(button);
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

//POS机点击跳转
$('#pos-btn').click(function () {
    var r = confirm("是否打开POS机？");
    if (r == true) {
        window.open("PosTerminal.html")
    }
});

//搜索处理
$('#search-btn').click(function () {
    var s_viceid = $('#search-order-id').val().toString();
    var s_clientid = $('#search-client-id').val().toString();
    var s_principalid = this.getCookie("id").toString();
    order = {
        viceid : s_viceid,
        clientid : s_clientid,
        principalid : s_principalid
    }
    var queryList = queryOrder(order);
    loadOrderList(queryList);
});

//详情按钮
$(document).on('click', '#detail-btn', function () {
    console.log($(this).attr("value")); //获取按钮value
    $('#orderDetailModal').modal('show'); //show modal
    // $('#temp-cargo-list').className = "table table-hover";

    $('#client-name').val('jack');
    $('#client-id').val("12313");
    $('#cargo-sale-position').val();
    $('#owner').val();
    $('#gross-profit').innerHTML = '123';
    //填充订单货品列表
    var editTable = document.getElementById("temp-cargo-list");
    for (var i = 0; i < 5; i++) {
        var tr = document.createElement("tr");
        tr.setAttribute("id", "temp-tr");
        var td0 = document.createElement("td");
        td0.innerHTML = "10";
        var td1 = document.createElement("td");
        td1.innerHTML = "lkjlkjlkjl";
        var td2 = document.createElement("td");
        td2.innerHTML = "a2";
        var td3 = document.createElement("td");
        td3.innerHTML = "a3";
        var td4 = document.createElement("td");
        td4.innerHTML = "lkj";
        tr.appendChild(td0);
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        editTable.appendChild(tr);
    }
});

//获取模态框内点选单元格的值,更新货品信息栏
$(document).on('click', '#temp-tr', function () {
    var td = event.srcElement; // 通过event.srcElement 获取激活事件的对象 td
    console.log("行号：" + (td.parentElement.rowIndex) + "，列号：" + td.cellIndex);
    //填充订单参数
    $('#cargo-name').val("aaa");
    $('#cargo-id').val(12314);
    $('#cargo-single-price').val();
    $('#cargo-num').val();
    $('#cargo-total-price').val();
});

//清除模态框内容
$('body').on('hidden.bs.modal', '.modal', function () {
    $(this).removeData('bs.modal');
});
