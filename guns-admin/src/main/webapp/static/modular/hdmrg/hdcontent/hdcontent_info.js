/**
 * 初始化货代管理详情对话框
 */
var HdcontentInfoDlg = {
    hdcontentInfoData : {}
};

/**
 * 清除数据
 */
HdcontentInfoDlg.clearData = function() {
    this.hdcontentInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
HdcontentInfoDlg.set = function(key, val) {
    this.hdcontentInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
HdcontentInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
HdcontentInfoDlg.close = function() {
    parent.layer.close(window.parent.Hdcontent.layerIndex);
}

/**
 * 收集数据
 */
HdcontentInfoDlg.collectData = function() {
    this
    .set('id')
    .set('deadline')
    .set('detail')
    .set('limitTime')
    .set('rate')
    .set('title')
    .set('url')
    .set('showOrder')
    .set('type');
}

/**
 * 提交添加
 */
HdcontentInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/hdcontent/add", function(data){
        Feng.success("添加成功!");
        window.parent.Hdcontent.table.refresh();
        HdcontentInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.hdcontentInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
HdcontentInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/hdcontent/update", function(data){
        Feng.success("修改成功!");
        window.parent.Hdcontent.table.refresh();
        HdcontentInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.hdcontentInfoData);
    ajax.start();
}

$(function() {
    $("#type").val($("#typeValue").val());
});
