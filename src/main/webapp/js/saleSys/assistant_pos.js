//POS机操作
window.onload = function () {
    // if (getCookie("sessionid") == "") {
    // //登录
    // alert("未登录,请登录后操作");
    // window.location.href = "../login.html";
    // return;
    // }
}

//订单货品暂存列表
cargoList = [];
//订单货品数量暂存列表
cargoNum = [];

$("#cargo-id").blur(function () {
    var cargoId = $(this).val();
    cargo = queryCargoById(cargoId);
    if (cargo == null) {
        //提示处理
        return;
    }
    cargoList.push(cargo);
    console.log(cargoId);
    document.getElementById('cargo-name').value = cargo.name;
    document.getElementById('cargo-retail-price').value = cargo.retailprice;
});

//添加按钮,点击将货品添加至订单表格中
$('#add-btn').click(function () {
    var cargo = cargoList[cargoList.length - 1];
    if (document.getElementById('cargo-num').value == "") {
        //提示处理
        
        return;
    }
    cargoNum.push(parseInt(document.getElementById('cargo-num').value));
    var totalPrice = "123";
    var totalPrice = parseFloat(cargo.retailprice)
        * parseInt(document.getElementById('cargo-num').val());
    var editTable = document.getElementById("temp-cargo-list");
    var tr = document.createElement("tr");
    var td0 = document.createElement("td");
    td0.innerHTML = cargo.name;
    var td1 = document.createElement("td");
    td1.innerHTML = cargo.id;
    var td2 = document.createElement("td");
    td2.innerHTML = document.getElementById('cargo-num').val();
    var td3 = document.createElement("td");
    td3.innerHTML = cargo.retailprice.toString();
    var td4 = document.createElement("td");
    td4.innerHTML = totalPrice.toString();
    tr.appendChild(td0);
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    editTable.appendChild(tr);
    updateTotalPrice(); //Update total price
});

//更新总价格
function updateTotalPrice() {
    var totalPrice = 0;
    for(var i = 0; i < cargoList.length; i++) {
        totalPrice += parseFloat(cargoList[i].retailprice) * cargoNum[i];
    }
    document.getElementById('total-price').value = totalPrice.toString();
}

//更新实收
$("#actual-recive").blur(function () {
    var totalPrice = parseFloat(document.getElementById('total-price').value);
    var actualPrice = parseFloat(document.getElementById('actual-recive').value);
    var change = actualPrice - totalPrice;
    document.getElementById('change').value = change;
});

//客户名称
$("#client-id").blur(function () {
    var clientId = $(this).val();
    client = queryClientById(clientId);
    if (client == null) {
        //提示处理
        return;
    }
    console.log(clientId);
    document.getElementById('client-name').value = client.name;
});

/**
 * 结清功能,发送订单数据,清空界面
 */
$('#submit-btn').click(function() {
    if ($('#client-id').val() == "") {
        //提示
        return;
    }
    //整合订单
    //订单基本信息
    var s_clientid = $('#client-id').val();
    var s_warehourseid = 1001; //仓库id
    var s_principalid = getCookie("id");
    var s_sumprice = $('#total-price').val();
    var s_gather = $("#actual-recive").val();
    var s_change = $('#change').val();
    var s_margin = calculateMargin(cargoList, cargoNum, 1); //利润
    var s_type = 1; //retail
    var s_status = 5;
    orderTempL = [];
    //货品信息
    for (var i = 0; i < cargoList.length; i++) {
        c = {
            clientid : s_clientid,
            warehourseid : s_warehourseid,
            principalid : s_principalid,
            sumprice : s_sumprice,
            gather : s_gather,
            change : s_change,
            margin : s_margin,
            type : s_type,
            status : status,
            //货品
            itemid : cargoList[i].id,
            itemnum : cargoNum[i],
            perprice : cargoList[i].retailprice,
            sumprice : cargoNum[i] * cargoList[i].retailprice,
        }
        orderTempL.push(c);
    }
    //调用insert
    insertOrder(orderTempL);

    //清空内容
    document.getElementById('client-id').value = "";
    document.getElementById('client-name').value = "";
    document.getElementById('cargo-id').value = "";
    document.getElementById('cargo-name').value = "";
    document.getElementById('cargo-retail-price').value = "";
    document.getElementById('cargo-num').value = "";
    document.getElementById('temp-cargo-list').innerHTML = "";
});
