//保存盘点列表，{cargoId : cargo object}
var checkStockMap = new Map();
var tempStockMap = new Map();

window.onload = function () {
    this.refreshStockList();
}

//搜索
$('#search-btn').click(function () {
    refreshStockList();
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
        refreshStockList();
    }
});

//触发盘点文本框
$(document).on('blur', '#check-input', function () {
    var checknum = $(this).val();
//    console.log($(this));
//    var id = $(this).attr("itemid");
//    if (checknum == "") {
//        if (checkStockMap.get(id) != null) {
//            delete checkStockMap[id];
//            for (var i = 0, len = checkStockMap.length; i < len; i++) {
//                if (!checkStockMap[i] || checkStockMap[i] == '') {
//                    checkStockMap.splice(i, 1);
//                    len--;
//                    i--;
//                }
//            }
//            return;
//        } else {
//            return;
//        }
//    }
    checkStockMap.set("1", {
        hourseid: "1", //仓库id
        itemid: "1",
        itemname: "苏菲", //货品名称
        itemnum: checknum
    });
//    console.log("Add new check : " + checkStockMap.get(id));
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
        td2.innerHTML = sl[i].type;
        var td3 = document.createElement("td");
        td3.innerHTML = sl[i].specification;
        var td4 = document.createElement("td");
        td4.innerHTML = sl[i].itemnum;
        var td5 = document.createElement("td");
        checkinput = document.createElement('input');
        checkinput.className = "form-control";
        checkinput.setAttribute("placeholder", "最新盘点");
        checkinput.setAttribute("id", "check-input");
        checkinput.setAttribute("itemid", sl[i].itemid);
        checkinput.setAttribute("hourseid", sl[i].hourseid);
        td5.appendChild(checkinput);
        var td6 = document.createElement("td");
        td6.innerHTML = sl[i].time;

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

function cleanStockList() {
    document.getElementById("inventory-tbody").innerHTML = "";
}

function refreshStockList() {
    cleanStockList();
    var stype = $('#search-cargo-type').val();
    if (stype == "任意") {
        stype = '';
    }
    loadStockList(queryStock({
        itemid: $('#search-cargo-id').val(),
        itemname: $('#search-cargo-name').val(),
        type: stype,
        hourseid: getCookie("warehourseid")  //获取仓库id
    }));
}
