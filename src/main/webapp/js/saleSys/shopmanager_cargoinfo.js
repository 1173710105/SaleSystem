//店长管理货品信息

tempCargoList = [];

window.onload = function() {
    //加载货品
    var cargoList = null;
    var cargoList = this.queryCargo({id : ''});
    tempCargoList = cargoList;
    loadCargoList(cargoList);
}

//搜索处理
$('#search-btn').click(function () {
    var s_cargoname = $('#search-cargo-name').val().toString();
    var s_cargoid = $('#search-cargo-id').val().toString();
    var s_cargotype = $('#search-cargo-type').val();
    cargo = {
        id : s_cargoid,
        name : s_cargoname,
        type : s_cargotype
    }
    var queryList = queryCargo(cargo);
    loadOrderList(queryList);
});

//添加货品
$('#add-btn').click(function() {
    $('#cargoModal').modal('show'); //show modal
});

//保存货品
$('#save-btn').click(function() {
    //添加新货品
    if ($('#cargo-id').val() == "") {
        
    } 
    //编辑货品
    else {

    }
})

//编辑货品
$('#edit-btn').click(function() {
    var cargoid = $(this).val();
    var cargo;
    for (var i = 0; i < cargoList.length; i++) {
        if (cargoList[i].id == cargoid) {
            cargo = cargoList[i];
            break;
        }
    }
    $('#cargoModal').modal('show'); //show modal
    //填充信息
    $('#cargo-id').val(cargo.id);
    $('#cargo-name').val(cargo.name);
    $('#cargo-type').val(cargo.type);
    $('#cargo-owner').val(cargo.specification);
    $('#retail-price').val(cargo.retailprice);
    $('#purchase-price').val(cargo.purchaseprice);
    $('#wholesale-price').val(cargo.wholesaleprice);
})

//删除货品
$('#delete_btn').click(function () {
    var r = confirm("是否删除？");
    if (r == true) {
        //实现
        alert("删除成功");
    }
});


//加载货品信息
function loadCargoList(cargoList) {
    var editTable = document.getElementById("cargo-tbody");
    for (var i = 0; i < cargoList.length; i++) {
        //增加表格
        var tr = document.createElement("tr");
        tr.setAttribute("id", cargoList[i].id);
        var td0 = document.createElement("td");
        td0.innerHTML = cargoList[i].id;
        var td1 = document.createElement("td");
        td1.innerHTML = cargoList[i].name;
        var td2 = document.createElement("td");
        td2.innerHTML = cargoList[i].type;
        var td3 = document.createElement("td");
        td3.innerHTML = cargoList[i].purchaseprice;
        var td4 = document.createElement("td");
        td4.innerHTML = cargoList[i].retailprice;
        var td5 = document.createElement("td");
        td5.innerHTML = cargoList[i].wholesaleprice;
        var td6 = document.createElement("td");
        td6.innerHTML = cargoList[i].specification;
        var td7 = document.createElement("td");  //update time
        td7.innerHTML = cargoList[i].time;
        var td8 = document.createElement("td");
        var editButton = document.createElement("button");
        editButton.type = "button";
        editButton.id = "edit-btn";
        editButton.setAttribute("value", cargoList[i].id); //将货品id封装在value中
        editButton.className = "btn btn-sm btn-primary";
        editButton.innerHTML = "编辑";
        td8.appendChild(editButton);

        var deleButton = document.createElement("button");
        deleButton.type = "button";
        deleButton.id = "delete-btn";
        deleButton.setAttribute("value", cargoList[i].id); //将货品id封装在value中
        deleButton.className = "btn btn-sm btn-danger";
        deleButton.innerHTML = "删除";
        td8.appendChild(deleButton);

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
