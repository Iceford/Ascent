/*
 * @Description: 
 * @FilePath: \src\main\webapp\js\goodsList.js
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-08 00:06:17
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved. 
 */
$(function () {
	var rod = "";
	$.ajax({
		url: "/Ascent/roundGoods.do",
		type: "get",
		dataType: "json",
		success: function (m) {
			suiji(m)
			$('#suiji').append(rod)
		}

	})

	function suiji(arry) {
		for (var i in arry) {
			rod += "<li>"
			rod += "<a href='detail.html?id=" + arry[i]["id"] + "'><img src='../images/" + arry[i]["goods_img"] + "'></a>"
			rod += "<h4><a href='detail.html?id=" + arry[i]["id"] + "'>" + arry[i]["goods_name"] + "</a></h4>"
			rod += "<div class='prize'>￥" + arry[i]["goods_price"] + "</div></li>"
		}
	}

})