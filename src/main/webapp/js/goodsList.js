/*
 * @Description: 
 * @FilePath: \src\main\webapp\js\goodsList.js
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-08 00:06:17
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
$(function () {
	var rod = "";
	$.ajax({
		url: "/Shop-SSM/roundGoods.do",
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