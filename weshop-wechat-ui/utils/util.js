var api = require('../config/api.js')

function formatTime(date) {
	var year = date.getFullYear()
	var month = date.getMonth() + 1
	var day = date.getDate()

	var hour = date.getHours()
	var minute = date.getMinutes()
	var second = date.getSeconds()


	return [year, month, day].map(formatNumber).join('-') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

function formatNumber(n) {
	n = n.toString()
	return n[1] ? n : '0' + n
}

/**
 * 封封微信的的request
 */
function request(url, data = {}, method = "GET") {
	return new Promise(function (resolve, reject) {
		wx.request({
			url: url,
			data: data,
			method: method,
			header: {
				'Content-Type': 'application/json',
				'X-Weshop-Token': wx.getStorageSync('token')
			},
			success: function (res) {
				console.log("success");
				if (res.statusCode == 200) {
					if (res.data.code == 616) {
						//需要登录后才可以操作
						var pages = getCurrentPages() //获取加载的页面
						var currentPage = pages[pages.length - 1] //获取当前页面的对象
						var url = currentPage.route //当前页面url
						var options = currentPage.options; //如果要获取url中所带的参数可以查看options
						wx.redirectTo({
							url: '/pages/auth/login/login?backUrl=/' + url + '&backParamJson=' + JSON.stringify(options)
						});
					} else {
						resolve(res.data);
					}
				} else {
					reject(res.errMsg);
				}

			},
			fail: function (err) {
				reject(err)
				console.log("failed")
			}
		})
	});
}

function get(url, data = {}) {
	return request(url, data, 'GET')
}

function post(url, data = {}) {
	return request(url, data, 'POST')
}

/**
 * 检查微信会话是否过期
 */
function checkSession() {
	return new Promise(function (resolve, reject) {
		wx.checkSession({
			success: function () {
				resolve(true);
			},
			fail: function () {
				reject(false);
			}
		})
	});
}

/**
 * 调用微信登录
 */
function login() {
	return new Promise(function (resolve, reject) {
		wx.login({
			success: function (res) {
				if (res.code) {
					resolve(res.code);
				} else {
					reject(res);
				}
			},
			fail: function (err) {
				reject(err);
			}
		});
	});
}

function getUserInfo() {
	wx.redirectTo({
		url: '/pages/auth/login/login?backurl=pages/index/index'
	});
	return;
	// return new Promise(function (resolve, reject) {
	//     wx.getUserInfo({
	//         withCredentials: true,
	//         success: function (res) {
	//             if (res.errMsg === 'getUserInfo:ok') {
	//                 resolve(res);
	//             } else {
	//                 reject(res)
	//             }
	//         },
	//         fail: function (err) {
	//             reject(err);
	//         }
	//     })
	// });
}

function redirect(url) {

	//判断页面是否需要登录
	if (false) {
		wx.redirectTo({
			url: '/pages/auth/login/login'
		});
		return false;
	} else {
		wx.redirectTo({
			url: url
		});
	}
}

function showErrorToast(msg) {
	wx.showToast({
		title: msg,
		image: '/static/images/icon_error.png'
	})
}

module.exports = {
	formatTime,
	request,
	get,
	post,
	redirect,
	showErrorToast,
	checkSession,
	login,
	getUserInfo,
}


