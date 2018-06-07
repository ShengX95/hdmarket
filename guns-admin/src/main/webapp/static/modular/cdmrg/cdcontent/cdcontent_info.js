/**
 * 初始化信用卡管理详情对话框
 */
var CdcontentInfoDlg = {
    cdcontentInfoData : {}
};

/**
 * 清除数据
 */
CdcontentInfoDlg.clearData = function() {
    this.cdcontentInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CdcontentInfoDlg.set = function(key, val) {
    this.cdcontentInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CdcontentInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CdcontentInfoDlg.close = function() {
    parent.layer.close(window.parent.Cdcontent.layerIndex);
}

/**
 * 收集数据
 */
CdcontentInfoDlg.collectData = function() {
    this
    .set('id')
    .set('limitTime')
    .set('detail')
    .set('title')
    .set('url')
    .set('showOrder')
    .set('type')
    .set('createTime')
    .set('tourl');
}

/**
 * 提交添加
 */
CdcontentInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/cdcontent/add", function(data){
        Feng.success("添加成功!");
        window.parent.Cdcontent.table.refresh();
        CdcontentInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.cdcontentInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CdcontentInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/cdcontent/update", function(data){
        Feng.success("修改成功!");
        window.parent.Cdcontent.table.refresh();
        CdcontentInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.cdcontentInfoData);
    ajax.start();
}

$(function() {
    $("#type").val($("#typeValue").val());
    var avatarUp = new $WebUpload("url");
    avatarUp.setUploadBarId("progressBar");
    avatarUp.init();
});
