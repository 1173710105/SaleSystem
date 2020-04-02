//店长进货页面
window.onload = function () {
    
	this.document.getElementById('order-source-position').innerHTML = this.buildWMenuOptionHTML(); 
	this.document.getElementById('search-order-source').innerHTML = '<option value="">任意</option>' + this.buildWMenuOptionHTML(); 
	this.document.getElementById('order-stock-position').innerHTML = this.buildWMenuOptionHTML(); 
    tempRep = queryWarehourseMenu();
    this.refreshCargoStockList();
}

//订货单和id映射表
var tempWareOrderMap = new Map();
//订单货品暂存列表,新建订单时增加货品对象放在该列表中，编辑订单时，将订单中
//所有货品加载到该列表中，对该列表修改，结束时写回发送到update函数
//cargoList只封装warehourseitem
var cargoMap = new Map();
//订单货品数量暂存列表
var cargoNumMap = new Map();
var tempCargo;
var preCargoId; //保存之前在货品框中货品id
var tempRep;


//加载进货信息
function loadWarehourseOrderList(worderList) {
	console.log("woiweo", worderList);
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
        td2.innerHTML = tempRep.get(worderList[i].targetid.toString());
        var td3 = document.createElement("td");
        td3.innerHTML = tempRep.get(worderList[i].sourceid.toString());
        var td4 = document.createElement("td");
        td4.innerHTML = worderList[i].principalname;
        var td5 = document.createElement("td");
        td5.innerHTML = getType(worderList[i].type);
        var td6 = document.createElement("td");
        td6.innerHTML = getStatus(worderList[i].status);
        var td7 = document.createElement("td");
        td7.innerHTML = worderList[i].createtime;
        var td8 = document.createElement("td");
        //未申请
        //添加编辑按钮,发起申请按钮,删除按钮
        if (worderList[i].status == "1") {
            var editButton = document.createElement("button");
            editButton.type = "button";
            editButton.id = "edit-btn";
            editButton.setAttribute("value", worderList[i].id); //将货品id封装在value中
            editButton.className = "btn btn-sm btn-primary";
            editButton.innerHTML = "编辑";
            td8.appendChild(editButton);

            var applyButton = document.createElement("button");
            applyButton.type = "button";
            applyButton.id = "apply-btn";
            applyButton.setAttribute("value", worderList[i].id); //将货品id封装在value中
            applyButton.className = "btn btn-sm btn-primary";
            applyButton.innerHTML = "发起申请";
            td8.appendChild(applyButton);

            var deleButton = document.createElement("button");
            deleButton.type = "button";
            deleButton.id = "delete-btn";
            deleButton.setAttribute("value", worderList[i].id); //将货品id封装在value中
            deleButton.className = "btn btn-sm btn-danger";
            deleButton.innerHTML = "删除";
            td8.appendChild(deleButton);
        }
        //审核中且源地址为子仓（包括总仓），我方发起的申请
        //添加详情按钮
        else if (worderList[i].status == "2" && worderList[i].principalid.toString() == getCookie("warehourseid")) {
            var detailButton = document.createElement("button");
            detailButton.type = "button";
            detailButton.id = "detail-btn";
            detailButton.setAttribute("value", worderList[i].id); //将货品id封装在value中
            detailButton.className = "btn btn-sm btn-primary";
            detailButton.innerHTML = "详情";
            td8.appendChild(detailButton);
        }
        //审核中且源地址为子仓（包括总仓），对方发起的申请
        //添加详情，审核
        else if (worderList[i].status == "2" && worderList[i].principalid.toString() != getCookie("principalid")) {
            var detailButton = document.createElement("button");
            detailButton.type = "button";
            detailButton.id = "detail-btn";
            detailButton.setAttribute("value", worderList[i].id); //将货品id封装在value中
            detailButton.className = "btn btn-sm btn-primary";
            detailButton.innerHTML = "详情";
            td8.appendChild(detailButton);

            var detailButton = document.createElement("button");
            detailButton.type = "button";
            detailButton.id = "check-btn";
            detailButton.setAttribute("value", worderList[i].id); //将货品id封装在value中
            detailButton.className = "btn btn-sm btn-primary";
            detailButton.innerHTML = "审核";
            td8.appendChild(detailButton);
        }
        //审核通过
        //添加详情按钮
        else if (worderList[i].status == "4") {
            var detailButton = document.createElement("button");
            detailButton.type = "button";
            detailButton.id = "detail-btn";
            detailButton.setAttribute("value", worderList[i].id); //将货品id封装在value中
            detailButton.className = "btn btn-sm btn-primary";
            detailButton.innerHTML = "详情";
            td8.appendChild(detailButton);
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

//加载模态框
function loadModal(type, order) {
    $('#type').val(type);
    var modal = $("#stockAddModal");
    console.log(modal);
    switch (type) {
        case "add": {
            $('.div-oid')[0].style.display = "none";
            $('.modal-footer')[0].style.display = "";
            $('.save-btn')[0].style.display = "";
            modal.find('.modal-title').text("添加进货");
            
            $('#order-principal').val(getCookie("principalname"));
            break;
        }
        case "edit": {
            $('.div-oid')[0].style.display = "";
            $('.modal-footer')[0].style.display = "";
            $('.save-btn')[0].style.display = "";
            modal.find('.modal-title').text("编辑进货");

            $('#order-id').val(order.id);
            $('#order-stock-position').val(order.targetid);
            $('#order-source-position').val(order.sourceid);
            $('#order-principal').val(order.principalname);
            //填充表格
            document.getElementById('type').setAttribute("type", type);
            loadModalTable(order.items);
            break;
        }
        case "detail": {
            $('.div-oid')[0].style.display = "";
            $('.modal-footer')[0].style.display = "none";
            $('.save-btn')[0].style.display = "none";
            modal.find('.modal-title').text("进货详情");

            $('#order-id').val(order.id);
            $('#order-stock-position').val(order.targetid);
            $('#order-source-position').val(order.sourceid);
            $('#order-principal').val(order.principlename);
            //填充表格
            document.getElementById('type').setAttribute("type", type);
            loadModalTable(order.items);
            break;
        }
    }
}

function loadModalTable(items) {
    var editTable = document.getElementById("temp-worder-tbody");
    editTable.innerHTML = "";
    for (var i = 0; i < items.length; i++) {
        cargoMap.set(items[i].itemid.toString(), items[i]);
        cargoNumMap.set(items[i].itemid.toString(), items[i].itemnum); //填充货品数量
        var tr = document.createElement("tr");
        tr.setAttribute("id", "temp-tr");
        tr.setAttribute("value", items[i].itemid);
        var td0 = document.createElement("td");
        td0.innerHTML = items[i].itemname;//name;
        var td1 = document.createElement("td");
        td1.innerHTML = items[i].itemid;//code;
        var td2 = document.createElement("td");
        td2.innerHTML = items[i].itemnum;//num;
        var td3 = document.createElement("td");
        td3.innerHTML = items[i].perprice;//single;
        var td4 = document.createElement("td");
        td4.innerHTML = items[i].sumprice;//sum;

        tr.appendChild(td0);
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        if ($('#type').val() == "add"
            || $('#type').val() == "edit") {
            var td5 = document.createElement("td");
            deleButton = document.createElement("button");
            deleButton.type = "button";
            deleButton.id = "temp-delete-btn";
            deleButton.setAttribute("value", items[i].itemid); //将仓库单货品id封装在value中
            deleButton.className = "btn btn-sm btn-danger";
            deleButton.innerHTML = "删除";
            td5.appendChild(deleButton);
            tr.appendChild(td5);
        }
        editTable.appendChild(tr);
    }

}

//搜索
$('#search-btn').click(function () {
    refreshCargoStockList();
});

//添加进货
$('#add-btn').click(function () {
    $('#stockAddModal').modal('show'); //show modal
    loadModal("add", null);
});

//编辑进货
$(document).on('click', '#edit-btn', function () {
    $('#stockAddModal').modal('show'); //show modal
    var id = $(this).val();
    loadModal("edit", tempWareOrderMap.get(id));
});

//进货详细
$(document).on('click', '#detail-btn', function () {
    $('#stockAddModal').modal('show'); //show modal
    var id = $(this).val();
    loadModal("detail", tempWareOrderMap.get(id));
});



//获取模态框内点选单元格的值,更新货品信息栏
$(document).on('click', '#temp-tr', function () {
    var td = event.srcElement; // 通过event.srcElement 获取激活事件的对象 td
    //填充订单参数
    var cargoid = this.getAttribute("value");
    preCargoId = cargoid;
    console.log("qqqqqq", cargoMap);
    console.log("eee", cargoid);
    console.log("23232", cargoMap.get(cargoid));
    showCargo(cargoMap.get(cargoid));
});

//删除订单
$(document).on('click', '#delete-btn', function () {
    var r = confirm("是否删除？");
    if (r == true) {
        var orderid = $(this).val();
        deleteWarehourseOrder(orderid);
        alert("删除成功");
        refreshCargoStockList();
    }
});

//删除货品
//删除暂存列表中货品
$(document).on('click', '#temp-delete-btn', function () {
    var cargoid = $(this).val();
    cargoMap.delete(cargoid);
    var l = [];
    cargoMap.forEach(function(value, key) {
    	l.push(value);
    })
    console.log("aaaddd", l);
    loadModalTable(l);
});

//修改货品id，请求新货品数据，移除货品列表之前的货品
$('#cargo-id').blur(function () {
    tempcargo = queryCargoById($(this).val(), getCookie("warehourseid"));
    if (tempcargo == null) {
        alert("货品不存在");
        return;
    }
    $('#cargo-name').val(tempcargo.name);
    $('#cargo-id').val(tempcargo.id);
    $('#cargo-purchase-price').val(tempcargo.purchaseprice);
    $('#cargo-total-price').val(
        parseFloat($('#cargo-purchase-price').val()) * parseInt($('#cargo-num').val()));
});

$('#cargo-num').blur(function () {
    $('#cargo-total-price').val(
        parseFloat($('#cargo-purchase-price').val()) * parseInt($('#cargo-num').val()));
})

//添加货品到订货单
$('#add-cargo-btn').click(function () {
    var cargoid = this.getAttribute("value");
    //由于map性质，一种货品只对应一条记录，所以子列表是唯一的
    if (cargoMap.has(cargoid)) {
        //修改数量，更新货品列表货品数量信息，总价信息
        if (cargoid == preCargoId) {
            cargoMap.get(cargoid).itemnum = $('#cargo-num').val();
            cargoMap.get(cargoid).perprice = $('#cargo-purchase-price').val();
            cargoMap.get(cargoid).sumprice = $('#cargo-total-price').val();
        }
        //改变了id且该id存在于货品列表中，则替换map中对应值，删去之前的货品对象
        else {
            cargoMap.get(cargoid).itemnum = $('#cargo-num').val();
            cargoMap.get(cargoid).perprice = $('#cargo-purchase-price').val();
            cargoMap.get(cargoid).sumprice = $('#cargo-total-price').val();
            cargoMap.delete(preCargoId);
        }
    } else {
        //不存在对应货品，新增记录插入到map中
    	var object = {
                itemid: tempcargo.id,
                itemname: tempcargo.name,
                itemnum: $('#cargo-num').val(),
                perprice: tempcargo.purchaseprice,
                sumprice: $('#cargo-total-price').val()
            };
        cargoMap.set(tempcargo.id.toString(), object);
    }

    //更新缓存
    var l = [];
    cargoMap.forEach(function(value, key) {
    	l.push(value);
    })
    var sump;
    cargoMap.forEach(function(value, key) {
        sump += parseFloat(value.perprice) * parseInt(value.itemnum);
    });
    $('#total-price').val("进货总价: " + sump);
    loadModalTable(l);
});

//发起申请
$(document).on('click', '#apply-btn', function () {
    var r = confirm("是否发起申请，发起后单据不可修改？");
    if (r == true) {
        alert(applyWarehourseOrder($(this).val()).info);
        refreshCargoStockList();
    }
});

//审核申请
$(document).on('click', "#check-btn", function () {
    var r = confirm("是否同意转仓请求？");
    if (r == true) {
    	var worder = tempWareOrderMap.get($(this).val());
        alert(passWarehourseOrder({
        	id : worder.id,
        	sourceid : worder.sourceid,
        	targetid : worder.targetid
        }).info);
        refreshCargoStockList();
    }
});

//保存,编辑保存,插入保存
$('#save-btn').click(function () {
    //判断货源地与目的地是否相同
    if($('#order-source-position').val() == getCookie("warehourseid")) {
        alert("货源地与目的地不能为同一地址");
        return;
    }
    if(cargoMap.size == 0) {
        alert("进货单货品列表不能为空");
        return;
    }
    //统一将暂存列表中货品写入
    var cargoObjectList = [];
    var sump = 0;
    cargoMap.forEach(function(value, key) {
    	sump += parseFloat(value.perprice) * parseInt(value.itemnum);
    });
    //新建订单
    cargoMap.forEach(function(value, key) {
    	cargoObjectList.push({
            id: $('#order-id').val(),  //仓库单id
            sourceid: $('#order-source-position').val(),
            sourcename: '',                                 //填充名称
            targetid: getCookie("warehourseid"),
            targetname: getCookie("warehoursename"),
            principalid: getCookie("principalid"),
            principalname: getCookie("principalname"),
            type: 2,
            createtime: '',
            checktime: '',
            status: 1,
            ordersumprice: sump,

            itemid: value.itemid,
            itemnum: value.itemnum,
            itemname: value.itemname,
            perprice: value.perprice,
            sumprice: value.sumprice
        })
    });
    $('#stockAddModal').modal('hide');
    if ($('#type').val() == "add") {
        alert(insertWarehourseOrder(cargoObjectList).info);
    } else if ($("#type").val() == "edit") {
        alert(updateWarehourseOrder(cargoObjectList).info);
    }
    //清空缓存list
    refreshCargoStockList();
});

//显示模态框中货品信息
function showCargo(cargo) {
    $('#cargo-name').val(cargo.itemname);
    $('#cargo-id').val(cargo.itemid);
    $('#cargo-num').val(cargo.itemnum);
    $('#cargo-purchase-price').val(cargo.perprice);
    $('#cargo-total-price').val(cargo.sumprice);
}

//******************************************************/
//清除模态框内容
$('body').on('hidden.bs.modal', '.modal', function () {
    // $(this).removeData('bs.modal');
    window.location.reload();
});

function cleanCargoStockList() {
    tempWareOrderMap.clear();
    cargoMap.clear();
    document.getElementById("worder-tbody").innerHTML = "";
}

function refreshCargoStockList() {
	document.getElementById('stock-amount').innerHTML = getCargoStockAmount(getCookie("warehourseid")).in;
	document.getElementById('stock-deliver-amount').innerHTML = getCargoStockAmount(getCookie("warehourseid")).out;
    cleanCargoStockList();
    worder = {
        id: $('#search-order-id').val(),
        sourceid: $('#search-order-source').val(),
        status: $('#search-status').val(),
        targetid: getCookie("warehourseid")
    }
    var queryList = queryWarehourseOrder(worder);
    console.log("23e89er", queryList);
    for (var i = 0; i < queryList.length; i++) {
        tempWareOrderMap.set(queryList[i].id.toString(), queryList[i]);
    }
    loadWarehourseOrderList(queryList);
}

function getStatus(status) {
    var cs = status.toString();
    if (cs == "1") {
        return "未申请";
    } else if (cs == "2") {
        return "申请中";
    } else if (cs == "4") {
        return "已通过";
    }
}

function getType(type) {
    if (type.toString() == "1") {
        return "进货";
    } else if(type.toString() == "2") {
        return "转仓";
    }
}

