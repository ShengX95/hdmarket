/**
 * 初始化图片展示管理详情对话框
 */
var SwiperInfoDlg = {
    swiperInfoData : {}
};

/**
 * 清除数据
 */
SwiperInfoDlg.clearData = function() {
    this.swiperInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SwiperInfoDlg.set = function(key, val) {
    this.swiperInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SwiperInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SwiperInfoDlg.close = function() {
    parent.layer.close(window.parent.Swiper.layerIndex);
}

/**
 * 收集数据
 */
SwiperInfoDlg.collectData = function() {
    this
    .set('id')
    .set('title')
    .set('url')
    .set('open')
    .set('tourl')
    .set('showorder')
    .set('type');
}

/**
 * 提交添加
 */
SwiperInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/swiper/add", function(data){
        Feng.success("添加成功!");
        window.parent.Swiper.table.refresh();
        SwiperInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.swiperInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SwiperInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/swiper/update", function(data){
        Feng.success("修改成功!");
        window.parent.Swiper.table.refresh();
        SwiperInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.swiperInfoData);
    ajax.start();
}

$(function() {
    $("#open").val($("#openValue").val());
    $("#type").val($("#typeValue").val());
    var avatarUp = new $WebUpload("url");
    avatarUp.setUploadBarId("progressBar");
    avatarUp.init();
});
