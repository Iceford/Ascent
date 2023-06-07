/*
 * @Description: 
 * @FilePath: \src\main\webapp\js\urlsqit.js
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:04
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-08 00:08:59
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    var context = "";
    if (r != null)
        context = r[2];
    reg = null;
    r = null;
    return context == null || context == "" || context == "undefined" ? "" : decodeURI(context);
}
/**
 * 截取url
 * 比如baidu.com?name=123
 * 获取？后面name的值
 * 就可以这样写
 * GetQueryString(name)
 */