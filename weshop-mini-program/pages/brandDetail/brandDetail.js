var util = require('../../utils/util.js');
var api = require('../../config/api.js');


var app = getApp();

Page({
    data: {
        id: 0,
        brand: {},
        goodsList: [],
        pageNum: 1,
        pageSize: 1000
    },
    onLoad: function (options) {
        // 页面初始化 options为页面跳转所带来的参数
        var that = this;
        that.setData({
            id: parseInt(options.id)
        });
        this.getBrand();
    },
    getBrand: function () {
        let that = this;
        util.request(api.BrandDetail, {id: that.data.id}).then(function (res) {
            if (res.success) {
                that.setData({
                    brand: res.data
                });

                that.getGoodsList();
            }
        });
    },
    getGoodsList() {
        var that = this;

        util.request(api.GoodsList, {brandId: that.data.id, pageNum: that.data.pageNum, size: that.data.pageSize})
            .then(function (res) {
                if (res.success) {
                    that.setData({
                        goodsList: res.data.goodsList
                    });
                }
            });
    },
    onReady: function () {
        // 页面渲染完成

    },
    onShow: function () {
        // 页面显示

    },
    onHide: function () {
        // 页面隐藏

    },
    onUnload: function () {
        // 页面关闭

    }
})