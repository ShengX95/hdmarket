/**
 * 信用卡管理管理初始化
 */
var Cdcontent = {
    id: "CdcontentTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Cdcontent.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '额度', field: 'limitTime', visible: true, align: 'center', valign: 'middle'},
            {title: '详情', field: 'detail', visible: true, align: 'center', valign: 'middle'},
            {title: '信用卡名称', field: 'title', visible: true, align: 'center', valign: 'middle'},
            // {title: '图片URL', field: 'url', visible: true, align: 'center', valign: 'middle'},
            {title: '跳转URL', field: 'tourl', visible: true, align: 'center', valign: 'middle'},
            {title: '类型', field: 'typeName', visible: true, align: 'center', valign: 'middle'},
            {title: '展示顺序', field: 'showOrder', visible: true, align: 'center', valign: 'middle' ,sortable: true},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle' ,sortable: true},
            {title: '点击量', field: 'click', visible: true, align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Cdcontent.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Cdcontent.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加信用卡管理
 */
Cdcontent.openAddCdcontent = function () {
    var index = layer.open({
        type: 2,
        title: '添加信用卡管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/cdcontent/cdcontent_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看信用卡管理详情
 */
Cdcontent.openCdcontentDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '信用卡管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/cdcontent/cdcontent_update/' + Cdcontent.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除信用卡管理
 */
Cdcontent.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/cdcontent/delete", function (data) {
            Feng.success("删除成功!");
            Cdcontent.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("cdcontentId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询信用卡管理列表
 */
Cdcontent.search = function () {
    var queryData = {};
    queryData['name'] = $("#name").val();
    queryData['type'] = $("#type").val();
    Cdcontent.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Cdcontent.initColumn();
    var table = new BSTable(Cdcontent.id, "/cdcontent/list", defaultColunms);
    table.setPaginationType("client");
    Cdcontent.table = table.init();
});
