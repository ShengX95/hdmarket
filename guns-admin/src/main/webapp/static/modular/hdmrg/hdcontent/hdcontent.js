/**
 * 货代管理管理初始化
 */
var Hdcontent = {
    id: "HdcontentTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Hdcontent.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '贷款名称', field: 'title', visible: true, align: 'center', valign: 'middle'},
            {title: '贷款介绍', field: 'detail', visible: true, align: 'center', valign: 'middle'},
            {title: '借款期限', field: 'deadline', visible: true, align: 'center', valign: 'middle'},
            {title: '借款额度', field: 'limitTime', visible: true, align: 'center', valign: 'middle'},
            {title: '参考利率', field: 'rate', visible: true, align: 'center', valign: 'middle'},
            {title: '跳转url', field: 'url', visible: true, align: 'center', valign: 'middle'},
            {title: '类型', field: 'typeName', visible: true, align: 'center', valign: 'middle'},
            {title: '展示顺序', field: 'showOrder', visible: true, align: 'center', valign: 'middle', sortable: true},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle' ,sortable: true},
            {title: '点击量', field: 'click', visible: true, align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Hdcontent.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Hdcontent.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加货代管理
 */
Hdcontent.openAddHdcontent = function () {
    var index = layer.open({
        type: 2,
        title: '添加货代管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/hdcontent/hdcontent_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看货代管理详情
 */
Hdcontent.openHdcontentDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '货代管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/hdcontent/hdcontent_update/' + Hdcontent.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除货代管理
 */
Hdcontent.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/hdcontent/delete", function (data) {
            Feng.success("删除成功!");
            Hdcontent.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("hdcontentId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询货代管理列表
 */
Hdcontent.search = function () {
    var queryData = {};
    queryData['name'] = $("#name").val();
    queryData['type'] = $("#type").val();
    Hdcontent.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Hdcontent.initColumn();
    var table = new BSTable(Hdcontent.id, "/hdcontent/list", defaultColunms);
    table.setPaginationType("client");
    Hdcontent.table = table.init();
});
