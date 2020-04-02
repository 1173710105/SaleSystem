var tempClientMap = new Map();

window.onload = function () {
    this.refreshPerformanceList();
}

//搜索
$('#search-btn').click(function () {
    refreshPerformanceList();
});

$("#start-date input").datetimepicker({
    language: "zh-CN",
    format: 'yyyy-mm-dd'
});


function cleanList() {
	var editTable = document.getElementById("per-tbody");
    editTable.innerHTML = "";
    
}

//刷新页面
function refreshPerformanceList() {
    cleanList();
    per = {
        warehourseid: getCookie("warehourseid"),
        warehoursename: getCookie("warehoursename"),
        principalid : $('#search-staff-id').val(),
        principalname : $('#search-staff-name').val(),
        starttime : $('#start-date').val() + " 00:00:00",
        endtime : $('#end-date').val() + " 00:00:00"
    }
    var perList = this.queryClient(client);
    console.log("refresh clientlist : ", perList);
    console.log("refresh clientType : ", typeof(perList));
    for (var i = 0; i < perList.length; i++) {
        this.tempClientMap.set(perList[i].principalid.toString(), perList[i]);
    }
    loadClientList(perList);
}

//加载列表
function loadClientList(cl) {
    var editTable = document.getElementById("client-tbody");
    for (var i = 0; i < cl.length; i++) {
        var tr = document.createElement("tr");
        tr.setAttribute("id", cl[i].id);
        var td0 = document.createElement("td");
        td0.innerHTML = cl[i].principalid;
        var td1 = document.createElement("td");
        td1.innerHTML = cl[i].principalname;
        var td2 = document.createElement("td");
        td2.innerHTML = cl[i].warehoursename;
        var td3 = document.createElement("td");
        td3.innerHTML = cl[i].orderNum;
        var td4 = document.createElement("td");
        td4.innerHTML = cl[i].clientnum;
        var td5 = document.createElement("td");
        td5.innerHTML = "";
        var td6 = document.createElement("td");
        td6.innerHTML = cl[i].performancedetail;

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