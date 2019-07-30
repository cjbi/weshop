var util = require('../../../utils/util.js');
var api = require('../../../config/api.js');
var app = getApp();
var backUrl = '/pages/index/index';
var backParams = {};
Page({
  data: {

  },
  onLoad: function(options) {
    //返回的页面
    backUrl = options.backUrl;
    //返回的参数
    let obj = JSON.parse(options.backParamJson);
    backParams = Object.keys(obj).map(function (key) {
      return encodeURIComponent(key) + "=" + encodeURIComponent(obj[key]);
    }).join("&");
    // 页面初始化 options为页面跳转所带来的参数
    // 页面渲染完成

  },
  onReady: function() {

  },
  onShow: function() {
    // 页面显示
  },
  onHide: function() {
    // 页面隐藏

  },
  onUnload: function() {
    // 页面关闭

  },
  //js核心代码：其中利用backtype来确认授权登录后跳转回那个页面
  bindGetUserInfo: function(e) {

    return util.login().then((res) => {
      //登录远程服务器
      util.request(api.AuthLoginByWeixin, {
        code: res,
        userInfo: e.detail.userInfo
      }, 'POST').then(res => {

        if (res.code == 200) {
          //存储用户信息
          wx.setStorageSync('userInfo', JSON.stringify(res.data.userInfo));
          wx.setStorageSync('token', res.data.token);
          //返回上一页面
          wx.redirectTo({
            url: backUrl + '?' + backParams,
          })
        }
      })
    });
  },
  navigateBack: function(e) {
    if(getCurrentPages().length>1) {
      wx.navigateBack({});
    } else {
      wx.switchTab({
        url: '/pages/index/index',
      })
    }
  },
})