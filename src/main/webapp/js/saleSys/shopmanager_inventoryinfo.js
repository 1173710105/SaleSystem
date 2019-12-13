//保存盘点列表，{cargoId : cargo object}
var checkStockMap = new Map();

window.onload = function () {
    var stockList = this.queryStockByWarehourseId(""); //仓库id
    loadStockList(stockList);
}

//搜索
$('#search-btn').click(function () {
    stock = {
        itemid: $('search-cargo-id'),
        itemname: $('search-cargo-name'),
        type: $('search-cargo-type'),
        hourseid: ""  //获取仓库id
    }
    loadStockList(queryStock(stock));
});

//更新盘点,（为0时删除/）
$('#update-btn').click(function () {
    var r = confirm("是否更新盘点？");
    if (r == true) {
        templ = [];
        for (var id in checkStockMap) {
            stock = {
                hourseid: checkStockMap.get(id).hourseid,
                itemid: checkStockMap.get(id).itemid,
                itemname: checkStockMap.get(id).itemname,
                itemnum: checkStockMap.get(id).itemnum
            }
            templ.push(stock);
        }
        updateStock(templ);
        alert("更新完成");
    }
});

//触发盘点文本框
$('#check-input').blur(function() {
    var checknum = $(this).val();
    var id = $(this).attr("itemid");
    checkStockMap.set(id, {
        hourseid : '', //仓库id
        itemid : id,
        itemname : '', //货品名称
        itemnum : checknum
    });
    console.log("Add new check : " + checkStockMap.get(id));
});

//加载库存列表
function loadStockList(sl) {
    var editTable = document.getElementById("inventory-tbody");
    for (var i = 0; i < sl.length; i++) {
        var tr = document.createElement("tr");
        tr.setAttribute("id", sl[i].itemid);
        var td0 = document.createElement("td");
        td0.innerHTML = sl[i].itemid;
        var td1 = document.createElement("td");
        td1.innerHTML = sl[i].itemname;  //请求后台货物
        var td2 = document.createElement("td");
        td2.innerHTML = sl[i].itemspecification;
        var td3 = document.createElement("td");
        td3.innerHTML = sl[i].itemnum;
        var td4 = document.createElement("td");
        checkinput = document.createElement('input');
        checkinput.className = "form-control";
        checkinput.setAttribute("placeholder", "最新盘点");
        checkinput.setAttribute("id", "check-input");
        checkinput.setAttribute("itemid", sl[i].itemid);
        checkinput.setAttribute("hourseid", sl[i].hourseid);
        td4.appendChild(checkinput);
        var td5 = document.createElement("td");
        td5.innerHTML = sl[i].time;

        tr.appendChild(td0);
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
        editTable.appendChild(tr);
    }
}