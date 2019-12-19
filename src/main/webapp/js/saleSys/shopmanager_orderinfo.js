//缓存映射，每加载一个list，将里面order对象转为map存入
//规定，新建订单将以key “temp” 表示
var tempOrderMap = new Map();

window.onload = function () {
    refreshOrderList();
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
        td4.innerHTML = getCheckStatus(ol[i]);
        var td5 = document.createElement("td");
        td5.innerHTML = getPayStatus(ol[i]);
        var td6 = document.createElement("td");
        td6.innerHTML = ol[i].margin;
        var td7 = document.createElement("td");
        td7.innerHTML = ol[i].principalname;
        var td8 = document.createElement("td");
        td8.innerHTML = ol[i].warehoursename;
        var td9 = document.createElement("td");
        td9.innerHTML = ol[i].createtime;
        var td10 = document.createElement("td");
        //草稿
        //添加审核按钮,编辑按钮,删除按钮
        if (ol[i].status == "1") {
            var editButton = document.createElement("button");
            editButton.type = "button";
            editButton.id = "check-btn";
            editButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            editButton.className = "btn btn-sm btn-primary";
            editButton.innerHTML = "审核";
            td10.appendChild(editButton);

            var applyButton = document.createElement("button");
            applyButton.type = "button";
            applyButton.id = "edit-btn";
            applyButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            applyButton.className = "btn btn-sm btn-primary";
            applyButton.innerHTML = "编辑";
            td10.appendChild(applyButton);

            var deleButton = document.createElement("button");
            deleButton.type = "button";
            deleButton.id = "delete-btn";
            deleButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            deleButton.className = "btn btn-sm btn-danger";
            deleButton.innerHTML = "删除";
            td10.appendChild(deleButton);
        }
        //审核中
        //添加详情按钮
        else if (ol[i].status == "2") {
            var editButton = document.createElement("button");
            editButton.type = "button";
            editButton.id = "detail-btn";
            editButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            editButton.className = "btn btn-sm btn-primary";
            editButton.innerHTML = "详情";
            td10.appendChild(editButton);
        }
        //已审核，未付款
        //添加详情按钮，付款按钮，退货按钮
        else if (ol[i].status == "4") {
            var editButton = document.createElement("button");
            editButton.type = "button";
            editButton.id = "detail-btn";
            editButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            editButton.className = "btn btn-sm btn-primary";
            editButton.innerHTML = "详情";
            td10.appendChild(editButton);

            var applyButton = document.createElement("button");
            applyButton.type = "button";
            applyButton.id = "pay-btn";
            applyButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            applyButton.className = "btn btn-sm btn-primary";
            applyButton.innerHTML = "付款";
            td10.appendChild(applyButton);

            var deleButton = document.createElement("button");
            deleButton.type = "button";
            deleButton.id = "return-btn";
            deleButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            deleButton.className = "btn btn-sm btn-danger";
            deleButton.innerHTML = "退货";
            td10.appendChild(deleButton);
        }
        //已审核，已付款
        //添加详情按钮，退货按钮
        else if (ol[i].status == "5") {
            var editButton = document.createElement("button");
            editButton.type = "button";
            editButton.id = "detail-btn";
            editButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            editButton.className = "btn btn-sm btn-primary";
            editButton.innerHTML = "详情";
            td10.appendChild(editButton);

            var deleButton = document.createElement("button");
            deleButton.type = "button";
            deleButton.id = "return-btn";
            deleButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            deleButton.className = "btn btn-sm btn-danger";
            deleButton.innerHTML = "退货";
            td10.appendChild(deleButton);
        }
        //已退货
        //添加详情按钮
        else if (ol[i].status == "6" || ol[o].status == "7") {
            var editButton = document.createElement("button");
            editButton.type = "button";
            editButton.id = "detail-btn";
            editButton.setAttribute("value", ol[i].id); //将货品id封装在value中
            editButton.className = "btn btn-sm btn-primary";
            editButton.innerHTML = "详情";
            td10.appendChild(editButton);
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
        tr.appendChild(td9);
        tr.appendChild(td10);
        editTable.appendChild(tr);
    }
}

//刷新模态框，传入list对象,这里对象是转化后的map
function loadMadal(ol) {
    var common = ol[0];
    var status = common.get("status").toString();
    $('#order-id').val(common.get("orderid"));
    $('#client-id').val(common.get("clientid"));
    $('#client-name').val(common.get("clientname"));
    $('#order-type').val(common.get("type"));
    $('#order-position').val(common.get("warehoursename"));
    $('#principal-name').val(common.get("principalname"));

    if(status != "1") {
        $('.temp-add-btn')[0].setAttribute("style","display:none;");
        $('.modal-footer')[0].setAttribute("style","display:none;")
        //$('.save-btn')[0].setAttribute("style","display:;")
    } else {
        $('.temp-add-btn')[0].setAttribute("style","display:block;");
        $('.modal-footer')[0].setAttribute("style","display:block;")
        //$('.save-btn')[0].setAttribute("style","display:none;")
    }

    var editTable = document.getElementById("temp-cargo-tbody");
    
    for (key in ol) {
        var tr = document.createElement("tr");
        tr.setAttribute("id", "temp-tr");
        tr.setAttribute("cid", ol[key].get("itemid"));
        var td0 = document.createElement("td");
        td0.innerHTML = ol[key].get("itemname");
        var td1 = document.createElement("td");
        td1.innerHTML = ol[key].get("itemid");
        var td2 = document.createElement("td");
        td2.innerHTML = ol[key].get("itemnum");
        var td3 = document.createElement("td");
        td3.innerHTML = ol[key].get("perprice");
        var td4 = document.createElement("td");
        td4.innerHTML = ol[key].get("sumprice");
        var td5 = document.createElement("td");
        var deleButton = document.createElement("button");
        deleButton.type = "button";
        deleButton.id = "temp-delete-btn";
        deleButton.setAttribute("value", ol[key].get("itemid")); //将货品id封装在value中
        deleButton.className = "btn btn-sm btn-danger";
        deleButton.innerHTML = "删除";
        td5.appendChild(deleButton);
        tr.appendChild(td0);
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        if(status == "1") {
            tr.appendChild(td5);
        }
        editTable.appendChild(tr);
    }

    //是否显示退货备注
    if (status == "6" || status == "7") {
        $('.return-note')[0].setAttribute("style","display:block;")
        $('#order-note').val(common.get("note"));
    } else {
        $('.return-note')[0].setAttribute("style","display:none;")
    }
}

//条件搜索
$('#search-btn').click(function () {
    refreshOrderList();
});

//弹出添加订单
$('#add-order-btn').click(function () {
    $('#orderModifyModal').modal('show');
    $('.return-note')[0].setAttribute("style","display:none;");
    $('#principal-name').val(getCookie("principalname"));
    $('#order-postion').val(getCookie("warehoursename")); //获得仓库
});


//审核订单
$(document).on('click', '#check-btn', function () {
    var r = confirm("是否审核通过？");
    if (r == true) {
        var id = $(this).val();
        var reply = checkOrder({
        	orderid : id,
        	warehourseid : getCookie("warehourseid"),
        	principalid : getCookie("principalid"),
        	principalname : getCookie("principalname")
        });
        alert(reply.info);
        refreshOrderList();
    }
});

//订单付款
//Map<orderid : List<Map<key:value>>>
$('#ac-pay-btn').click(function () {
    var sgather = $('#pay-actual-charge').val();
    var schange = $('#pay-change').val();
    order = {
        orderid: $('#pay-order-id').val(),
        warehourseid : getCookie("warehourseid"),
        warehoursename : getCookie("warehoursename"),
        principalid : getCookie("principalid"),
        principalname : getCookie("principalname"),
        change: schange,
        gather: sgather
    }
    alert(payOrder(order).info);
    refreshOrderList();
    $('#orderPayModal').modal('hide');
});

//实时更新找回价格
$('#pay-actual-charge').blur(function () {
    var actual = parseFloat($('#pay-actual-charge').val());
    var total = parseFloat($('#pay-total-price').val());
    if (actual < total) {
        $('#pay-change').val("实付不足");
        return;
    }
    $('#pay-change').val(actual - total);
});

//订单删除
$(document).on('click', '#delete-btn', function () {
    var r = confirm("是否删除？");
    if (r == true) {
        var orderid = $(this).val();
        deleteOrder({
        	orderid : orderid,
        	warehourseid : getCookie("warehourseid")
        });
        alert("删除成功");
        refreshOrderList();
    }
});

//货品删除
$(document).on('click', '#temp-delete-btn', function () {
    var cl;
    if ($('#order-id').val() == "") {
        cl = tempOrderMap.get("temp");
    } else {
        cl = tempOrderMap.get($('#order-id').val());
    }
    var itemid = $(this).val();
    for (var i = 0; i < cl.length; i++) {
        if (cl[i].get("itemid") == itemid) {
            cl.splice(i, 1);
        }
    }
    console.log("aaa", cl);
    loadMadal(cl);
});


//订单退货
$('#ack-return-btn').click(function () {
	console.log("qqq", $('#return-note').val());
    alert(returnOrder({
        orderid : $('#return-order-id').val(),
        warehourseid : getCookie("warehourseid"),
        principalid : getCookie("principalid"),
//        note : $('#return-note').val(),
        note : "testnote",
        exception : ""
    }).info);
    $('#saleReturnModal').modal('hide');
    refreshOrderList();
});

//弹出订单详情
$(document).on('click', '#detail-btn', function () {
    $('#orderModifyModal').modal('show');
    var orderid = $(this).val();
    loadMadal(tempOrderMap.get(orderid));
});

//弹出编辑订单
$(document).on('click', '#edit-btn', function () {
    $('#orderModifyModal').modal('show');
    var orderid = $(this).val();
    loadMadal(tempOrderMap.get(orderid));
});

//弹出订单付款
$(document).on('click', '#pay-btn', function () {
    $('#orderPayModal').modal('show');
    var orderid = $(this).val();
    var order = tempOrderMap.get(orderid);
    console.log("zzzzz : ", order);
    $('#pay-order-id').val(orderid);
    $('#pay-client-name').val(order[0].get("clientname"));
    $('#pay-pricinpal-name').val(order[0].get("principalname"));
    $('#pay-total-price').val(order[0].get("sumprice"));
    var editTable = document.getElementById("temp-pay-cargo-tbody");
    editTable.innerHTML = "";
    for (var i = 0; i < order.length; i++) {
        var tr = document.createElement("tr");
        tr.setAttribute("id", order[i].get("id"));
        var td0 = document.createElement("td");
        td0.innerHTML = order[i].get("itemname");
        var td1 = document.createElement("td");
        td1.innerHTML = order[i].get("itemid");
        var td2 = document.createElement("td");
        td2.innerHTML = order[i].get("itemnum");
        var td3 = document.createElement("td");
        td3.innerHTML = order[i].get("perprice");
        var td4 = document.createElement("td");
        td4.innerHTML = order[i].get("sumprice");
        tr.appendChild(td0);
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        editTable.appendChild(tr);
    }
});

//弹出订单退货
$(document).on('click', '#return-btn', function () {
    var orderid = $(this).val();
    $('#saleReturnModal').modal('show');
    $('#return-order-id').val(tempOrderMap.get(orderid)[0].get("orderid"));
    $('#return-client-name').val(tempOrderMap.get(orderid)[0].get("clientname"));
    $('#return-pricipal-name').val(tempOrderMap.get(orderid)[0].get("principalname"));
    //判断是否付款
    if (tempOrderMap.get(orderid)[0].get("status") == '3') {
        $('#payed-state').val("0");
    } else if (tempOrderMap.get(orderid)[0].get("status") == '4') {
        $('#payed-state').val("1");
    }
    $('#return-total-price').val(tempOrderMap.get(orderid)[0].get("totalprice"));
});

$('#client-id').blur(function() {
    var clientid = $(this).val();
    var client = queryClientById(clientid);
    if(client == null) {
        alert("客户不存在");
        return;
    }
    $('#client-name').val(client.name);
    $('#client-id').val(client.id);
});

$('#cargo-id').blur(function() {
    var itemid = $(this).val();
    var item = queryCargoById(itemid, getCookie("warehourseid"));
    if(item == null) {
        alert("货品不存在");
        return;
    }
    $('#cargo-name').val(item.name);
    $('#cargo-id').val(item.id);
    $('#cargo-num').val("");
    $('#cargo-perprice').val(item.wholesaleprice);
    $('#cargo-total-price').val("");
});

$('#cargo-num').blur(function () {
    var perprice = parseFloat($('#cargo-perprice').val());
    var itemnum = parseInt($('#cargo-num').val());
    $('#cargo-total-price').val(perprice * itemnum);
});

//保存订单货品修改
$('#temp-add-btn').click(function () {
    var orderid = $('#order-id').val();
    var cargoid = $('#cargo-id').val();
    var ol;
    //新增订单
    if (orderid == "") {
        ol = tempOrderMap.get("temp");
        //新增订单，添加list
        if (ol == null) {
            l = [];
            tempOrderMap.set("temp", l);
            ol = l;
        }
        //编辑订单
    } else {
        ol = tempOrderMap.get(orderid);
    }
    //查找是否存在货品，存在修改，不存在添加
    var torder;
    for (var i =0 ; i< ol.length;i++) {
        if (ol[i].get("itemid") == cargoid) {
            torder = ol[i];
            break;
        }
    }
    //插入记录
    if (torder == null) {
        var cid = $('#cargo-id').val();
        var cargo = queryCargoById(cid, getCookie("warehourseid"));
        var m = new Map();
        m.set("warehourseid", getCookie("warehourseid"));
        m.set("warehoursename", getCookie("warehoursename"));
        m.set("itemid", cargo.id);
        m.set("itemname", cargo.name);
        m.set("itemnum", $('#cargo-num').val());
        m.set("perprice", cargo.wholesaleprice);
        m.set("sumprice", $('#cargo-total-price').val());
        m.set("status", "1");
        ol.push(m);
    }
    //修改记录，只能修改数量
    else {
        torder.set("itemnum", $('#cargo-num').val());
        torder.set("sumprice", $('#cargo-total-price').val());
    }
    console.log("Modify cargo : ", ol[ol.length-1]);
    var editTable = document.getElementById("temp-cargo-tbody");
    editTable.innerHTML = "";
    for(var i in ol) {
        var tr = document.createElement("tr");
        tr.setAttribute("id", "temp-tr");
        tr.setAttribute("cid", ol[i].get("itemid"));
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
        deleButton.setAttribute("value", ol[i].get("itemid")); //将货品id封装在value中
        deleButton.className = "btn btn-sm btn-danger";
        deleButton.innerHTML = "删除";
        td5.appendChild(deleButton);
        tr.appendChild(td0);
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        var status = ol[i].get("status");
        console.log("stasa", status);
        if(status == "1") {
            tr.appendChild(td5);
        }
        editTable.appendChild(tr);
    }
    console.log("temp add", ol);
});

//保存订单
$('#save-btn').click(function () {
    var order;
    if ($('#order-id').val() == "") {
        var client = queryClientById($('#client-id').val());
        order = tempOrderMap.get("temp");
        var totalprice = 0;
        for (var i=0;i<order.length;i++) {
            totalprice += parseFloat(order[i].get("sumprice"));
        }
        for (var i=0; i< order.length;i++) {
            order[i].set("warehourseid", getCookie("warehourseid"));
            order[i].set("warehoursename", getCookie("warehoursename"));
            order[i].set("clientid", client.id);
            order[i].set("clientname", client.name),
            order[i].set("principalid", getCookie("principalid"));
            order[i].set("principalname", getCookie("principalname"));
            order[i].set("status", 1);
            order[i].set("totalprice", totalprice);
            order[i].set("type", 2);
        }
    } else {
        order = tempOrderMap.get($('#order-id').val());
        //修改总价 totalprice
        var totalprice = 0;
        for (var i=0; i< order.length;i++) {
            totalprice += parseFloat(order[i].get("sumprice"));
        }
        for (var i=0; i< order.length;i++) {
            order[i].set("totalprice", totalprice);
        }
    }
    l = [];
    for (var i = 0; i < order.length; i++) {
        suborder = {
            orderid: order[i].get("orderid"),
            warehourseid: order[i].get("warehourseid"),
            warehoursename: order[i].get("warehoursename"),
            clientid: order[i].get("clientid"),
            clientname: order[i].get("clientname"),
            principalid: order[i].get("principalid"),
            principalname: order[i].get("principalname"),
            createtime: order[i].get("createtime"),
            status: order[i].get("status"),
            totalprice: order[i].get("totalprice"),
            type: order[i].get("type", order.type),
            margin: order[i].get("margin"),
            note: order[i].get("note"),
            exception: order[i].get("exception"),
            itemid: order[i].get("itemid"),
            itemname: order[i].get("itemname"),
            itemnum: order[i].get("itemnum"),
            perprice: order[i].get("perprice"),
            sumprice: order[i].get("sumprice"),
            ordersumprice : order[i].get("totalprice")
        }
        l.push(suborder);
    }
    console.log("manager save order : ", l);
    if ($('#order-id').val() == "") {
        alert(insertOrder(l).info);
    } else {
        alert(updateOrder(l).info);
    }
    $('#orderModifyModal').modal('hide');
});

//获取模态框内点选单元格的值,更新货品信息栏
$(document).on('click', '#temp-tr', function () {
    var td = event.srcElement; // 通过event.srcElement 获取激活事件的对象 td
    console.log("行号：" + (td.parentElement.rowIndex) + "，列号：" + td.cellIndex);
    //填充订单参数
    var itemid = $(this).attr("cid");
    var order;
    if ($('#order-id').val() == "") {
        order = tempOrderMap.get("temp");
    } else {
        order = tempOrderMap.get($('#order-id').val());
    }
    for(var i = 0; i < order.length; i++) {
    	if(order[i].get("itemid").toString() == itemid) {
    		showCargo(order[i]);
    		break;
    	}
    }
});

$("#search-check-status").change(function () {
    if ($(this).val() == "未审核") {
        $('#search-pay option')[0].style.display = "none";
        $('#search-pay option')[1].style.display = "";
        $("#search-pay").val("未付款");
        $('#search-pay option')[2].style.display = "none";
    } else if ($(this).val() == "审核中") {
        $('#search-pay option')[0].style.display = "none";
        $('#search-pay option')[1].style.display = "";
        $("#search-pay").val("未付款");
        $('#search-pay option')[2].style.display = "none";
    } else if ($(this).val() == "已审核") {
        $('#search-pay option')[0].style.display = "";
        $("#search-pay").val("任意");
        $('#search-pay option')[1].style.display = "";
        $('#search-pay option')[2].style.display = "";
    } else if ($(this).val() == "已退货") {
        $('#search-pay option')[0].style.display = "";
        $("#search-pay").val("任意");
        $('#search-pay option')[1].style.display = "";
        $('#search-pay option')[2].style.display = "";
    } else if ($(this).val() == "任意") {
    	$('#search-pay option')[0].style.display = "";
        $("#search-pay").val("任意");
        $('#search-pay option')[1].style.display = "";
        $('#search-pay option')[2].style.display = "";
    }
});

//清空表格
function cleanOrderList() {
    document.getElementById("order-tbody").innerHTML = "";
    tempOrderMap.clear();
}

//刷新表格
function refreshOrderList() {
    cleanOrderList();
    var staff;
    if($("#search-principal-id").val() == "") {
    	staff = {
    		id : '',
    		name : ''
    	}
    }
    var pays = $('#search-pay').val();
    var checks = $('#search-check-status').val();
    var sstatus = [];
    if (checks == "任意" && pays == "任意") {
        sstatus.push("");
    } else if (checks == "任意" && pays == "未付款") {
        sstatus.push("1");
        sstatus.push("2")
        sstatus.push("4");
        sstatus.push("7")
    } else if (checks == "任意" && pays == "已付款") {
        sstatus.push("5");
        sstatus.push("6");
    }
    else if (checks == "未审核") {
        sstatus.push("1");
    } else if (checks == "审核中") {
        sstatus.push("2");
    } else if (checks == "已审核" && pays == "任意") {
        sstatus.push("4");
        sstatus.push("5");
    } else if (checks == "已审核" && pays == "未付款") {
        sstatus.push("4");
    } else if (checks == "已审核" && pays == "已付款") {
        sstatus.push("5");
    } else if (checks == "已退货" && pays == "任意") {
        sstatus.push("6");
        sstatus.push("7");
    } else if (checks == "已退货" && pays == "未付款") {
        sstatus.push("6");
    } else if (checks == "已退货" && pays == "已付款") {
        sstatus.push("7");
    }
    var queryList = [];
    console.log("sstatus : ", sstatus);
    if(sstatus[0] == "") {
    	queryList = queryOrder({
    		orderid: $('#search-order-id').val(),
                clientid: $('#search-client-id').val(),
                warehourseid: getCookie("warehourseid"),
                warehoursename: getCookie("warehoursename"),
                principalid: $("#search-principal-id").val(),
                principalname: '',
                type : $('#search-cargo-type').val(),
                status : ''
    	});
    } else {
		    	for (var i =0; i < sstatus.length; i++) {
		    		var t = queryOrder({
						orderid : $('#search-order-id').val(),
						clientid : $('#search-client-id').val(),
						warehourseid : getCookie("warehourseid"),
						warehoursename : getCookie("warehoursename"),
						principalid : $("#search-principal-id").val(),
						principalname : '',
						type : $('#search-cargo-type').val(),
						status : sstatus[i]
					});
		    		for(var j = 0; j < t.length; j++) {
		    			if(t[j] == null) continue;
		    			queryList.push(t[j]);
		    		}
		}
    }
    console.log("Build queryList : ", queryList);
    for (var i = 0; i < queryList.length; i++) {
        tempOrderMap.set(queryList[i].id.toString(), object2map(queryList[i]));
    }
    console.log("Build temporder Map : ", tempOrderMap);
    
    loadOrderList(queryList);
}

function showCargo(suborder) {
    $('#cargo-name').val(suborder.get("itemname"));
    $('#cargo-id').val(suborder.get("itemid"));
    $('#cargo-num').val(suborder.get("itemnum"));
    $('#cargo-perprice').val(suborder.get("perprice"));
    $('#cargo-total-price').val(suborder.get("sumprice"));
}

//数据转换，将接收数据转换为list<map>，每一个map是一个子列表
//将单个对象转换
/**
 * 
 * @param {Object} order 接收到的sendorder对象
 */
function object2map(order) {
    var l = [];
    for (var i = 0; i < order.items.length; i++) {
        var m = new Map();
        m.set("orderid", order.id);
        m.set("warehourseid", order.warehourseid);
        m.set("warehoursename", order.warehoursename);
        m.set("clientid", order.clientid);
        m.set("clientname", order.clientname);
        m.set("principalid", order.principalid);
        m.set("principalname", order.principalname);
        m.set("createtime", order.createtime);
        m.set("status", order.status.toString());
        m.set("totalprice", order.sumprice.toString());
        m.set("type", order.type);
        m.set("margin", order.margin.toString());
        m.set("note", order.note);
        m.set("exception", order.exception);
        m.set("itemid", order.items[i].itemid);
        m.set("itemname", order.items[i].itemname);
        m.set("itemnum", order.items[i].itemnum);
        m.set("perprice", order.items[i].perprice);
        m.set("sumprice", order.items[i].sumprice);
        l.push(m);
    }
    return l;
}

//清除模态框内容
$('body').on('hidden.bs.modal', '.modal', function () {
    // $(this).removeData('bs.modal');
    window.location.reload();
});

function getCheckStatus(order) {
    var cs = status2checkstatus(order.status.toString());
    if(cs == 0) {
        return "未审核";
    } else if(cs == 1) {
        return "审核中";
    } else if(cs == 2) {
        return "已审核";
    } else if(cs == 3) {
        return  "已退货";
    }
};

function getPayStatus(order) {
    var ps = status2paystatus(order.status.toString());
    if(ps == 0) {
        return "未付款";
    } else if(ps == 1) {
        return "已付款";
    } 
};