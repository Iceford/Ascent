/*
 * @Description: 
 * @FilePath: \src\main\webapp\js\Js\GoodsList_2.js
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-05 16:08:03
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved. 
 */
$(function () {

	var str = ""
	var counts = 0

	$.ajax({
		url: "/Ascent/AdminGetCounts.do",
		type: "get",
		dataType: "json",
		success: function (m) {
			counts = m.count
			pages_();//防止每次刷新时,值不能及时赋值进去

		}
	});

	goodsPage(0)


	function goodsPage(n) {
		$.ajax({
			url: "/Ascent/adminListPage.do",
			type: "post",
			data: {
				"num": n
			},
			dataType: "json",
			success: function (m) {
				console.log(m)
				lists_(m)
				$('#goods').append(str)
			}

		})

	}



	function lists_(arry) {
		var num = 1
		for (var i in arry) {
			str += "<tr align='center' class='d godlist'>"
			str += "<td>" + (num++) + "</td>"
			str += "<td>" + arry[i]["goods_name"] + "</td>"

			str += "<td>" + arry[i]["goodsType"]["type_name"] + "</td>"

			str += "<td><a href='goodsType_update.html?goods_type=" + arry[i]["goodsType"]["id"] + "&id=" + arry[i]["id"] + "'>转移</a></td>"
			str += "</tr>"
		}

	}

	function pages_() {
		layui.use('laypage', function () {
			var laypage = layui.laypage;
			//执行一个laypage实例
			laypage.render({
				elem: 'page' //注意,这里的 test1 是 ID,不用加 # 号
				, count: counts //数据总数,从服务端得到
				, limit: 8
				, groups: 3
				, jump: function (obj, first) {
					if (!first) {
						$('.godlist').text('');
						str = "";
						goodsPage((obj.curr - 1) * 8);
					}
				}
			});
		});
	}

})