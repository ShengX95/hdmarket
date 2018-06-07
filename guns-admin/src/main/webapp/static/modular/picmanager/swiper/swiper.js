/**
 * 图片展示管理管理初始化
 */
var Swiper = {
    id: "SwiperTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Swiper.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '展示顺序', field: 'showorder', visible: true, align: 'center', valign: 'middle'},
            {title: '图片介绍', field: 'title', visible: true, align: 'center', valign: 'middle'},
            {title: '图片URL', field: 'url', visible: true, align: 'center', valign: 'middle'},
            {title: '跳转URL', field: 'tourl', visible: true, align: 'center', valign: 'middle'},
            {title: '类型', field: 'typeName', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'openName', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Swiper.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Swiper.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加图片展示管理
 */
Swiper.openAddSwiper = function () {
    var index = layer.open({
        type: 2,
        title: '添加图片展示管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/swiper/swiper_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看图片展示管理详情
 */
Swiper.openSwiperDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '图片展示管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/swiper/swiper_update/' + Swiper.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除图片展示管理
 */
Swiper.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/swiper/delete", function (data) {
            Feng.success("删除成功!");
            Swiper.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("swiperId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询图片展示管理列表
 */
Swiper.search = function () {
    var queryData = {};
    queryData['type'] = $("#type").val();
    queryData['open'] = $("#open").val();
    Swiper.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Swiper.initColumn();
    var table = new BSTable(Swiper.id, "/swiper/list", defaultColunms);
    table.setPaginationType("client");
    Swiper.table = table.init();
});
