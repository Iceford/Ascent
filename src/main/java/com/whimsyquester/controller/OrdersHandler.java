/*
 * @Description: 基于Spring MVC框架的订单控制器类,用于处理与订单相关的请求
 * @FilePath: \src\main\java\com\whimsyquester\controller\OrdersHandler.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-07 10:35:58
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved.
 */
package com.whimsyquester.controller;

import com.whimsyquester.service.inter.OrdersServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;

@Controller // 标识该类是一个控制器
public class OrdersHandler {
    // 使用@Autowired注解自动注入OrdersServiceInter的实例
    @Autowired
    private OrdersServiceInter ordersServiceInter;

    // 使用@RequestMapping注解将请求映射到"/getCounts.do"路径上
    @RequestMapping("/getCounts.do")
    @ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
    // 用于获取订单数量,并将结果以字符串形式返回给客户端
    public String getCounts(Integer num) throws Exception {
        return ordersServiceInter.getCounts(num);
    }

    // 使用@RequestMapping注解将请求映射到"/FenyeLists.do"路径上,使用"produces"属性设置响应的MIME类型"text/html;charset=UTF-8;",以确保响应文的编码正确
    @RequestMapping(value = "/FenyeLists.do", produces = "text/html;charset=UTF-8;")
    @ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
    // 用于分页获取订单列表,并将结果以字符串形式返回给客户端
    public String FenyeLists(Integer page, Integer shiro_id) throws Exception {
        return ordersServiceInter.FenyeList(page, shiro_id);
    }

    // 使用@RequestMapping注解将请求映射到"/delByOrderId.do"路径上
    @RequestMapping("/delByOrderId.do")
    @ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
    // 用于删除订单,并将结果以字符串形式返回给客户端
    public String delByOrderId(Integer id) throws Exception {
        return ordersServiceInter.delByidOrders(id);
    }

    // 使用@RequestMapping注解将请求映射到"/pay_order.do"路径上
    @RequestMapping("/pay_order.do")
    @ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
    // 用于支付订单,并将结果以字符串形式返回给客户端
    public String pay_order(Integer id) throws Exception {
        return ordersServiceInter.PayOrders(id);
    }

    // 使用@RequestMapping注解将请求映射到"/paysDing.do"路径上
    @RequestMapping("/paysDing.do")
    @ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
    // 用于添加订单,并将结果以字符串形式返回给客户端
    public String paysDing(@RequestBody String lists) throws Exception {
        lists = URLDecoder.decode(lists, "utf-8");// 解码以避免出现乱码
        return ordersServiceInter.addOrders(lists);
    }

    // 使用@RequestMapping注解将HTTP请求映射到"/adminDaiPays.do"路径上,使用"produces"属性设置响应的MIME类型"text/html;charset=UTF-8;",以确保响应文的编码正确
    @RequestMapping(value = "/adminDaiPays.do", produces = "text/html;charset=UTF-8;")
    @ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
    // 用于查询待支付订单,并将结果以字符串形式返回给客户端
    public String adminDaiPays(Integer status) throws Exception {
        return ordersServiceInter.adminDaipays(status);
    }

    // 使用@RequestMapping注解将HTTP请求映射到"/adminDaiDels.do"路径上,使用"produces"属性设置响应的MIME类型"text/html;charset=UTF-8;",以确保响应文的编码正确
    @RequestMapping(value = "/adminDaiDels.do", produces = "text/html;charset=UTF-8;")
    @ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
    // 用于删除订单,并将结果以字符串形式返回给客户端
    public String adminDaiDels(Integer id, Integer shiro_id) throws Exception {
        // 首先检查"id"和"shiro_id"是否为null
        if (id == null || shiro_id == null) {
            // 如果其中任何一个为null,则返回一个JavaScript脚本,该脚本在客户端弹出一个警告框,然后将页面重定向到"/Ascent/admin/orders_dai.html"路径
            return "<script>alert('非法请求');location.href='/Ascent/admin/orders_dai.html';</script>";
        } else {
            // 如果"id"和"shiro_id"都不为null,则将它们传递给ordersServiceInter.adminDelsOrders()方法进行处理
            return ordersServiceInter.adminDelsOrders(id, shiro_id);
        }
    }

    // 使用@RequestMapping注解将HTTP请求映射到"/adminlogisticsOrdes.do"路径上,使用"produces"属性设置响应的MIME类型"text/html;charset=UTF-8;",以确保响应文的编码正确
    @RequestMapping(value = "/adminlogisticsOrdes.do", produces = "text/html;charset=UTF-8;")
    @ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
    // 用于查询物流信息,并将结果以字符串形式返回给客户端
    public String adminlogisticsOrdes(String status) throws Exception {
        return ordersServiceInter.adminLogistics(status);
    }

    // 使用@RequestMapping注解将HTTP请求映射到"/adminfahuoOrdes.do"路径上,使用"produces"属性设置响应的MIME类型"text/html;charset=UTF-8;",以确保响应文的编码正确
    @RequestMapping(value = "/adminfahuoOrdes.do", produces = "text/html;charset=UTF-8;")
    @ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
    // 用于发货,并将结果以字符串形式返回给客户端
    public String adminfahuoOrdes(Integer id) throws Exception {
        // 检查"id"是否为null
        if (id == null) {
            // 如果"id"为null,则返回一个JavaScript脚本,该脚本在客户端弹出一个警告框,然后将页面重定向到"/Ascent/admin/orders_weifa.html"路径
            return "<script>alert('非法请求');location.href='/Ascent/admin/orders_weifa.html';</script>";
        } else {
            // 如果"id"不为null,则将其传递给ordersServiceInter.adminFaOrdes()方法进行处理
            boolean flag = ordersServiceInter.adminFaOrdes(id);
            if (flag) {
                // 则返回一个JavaScript脚本,该脚本在客户端弹出一个提示框,显示"发货成功",然后将页面重定向到"/Ascent/admin/ordersifa.html"路径
                return "<script>alert('发货成功');location.href='/Ascent/admin/orders_weifa.html';</script>";
            } else {
                // 如果ordersServiceInter.adminFaOrdes()方法返回false,则返回一个JavaScript脚本,该脚本在客户端弹出一个提示框,显示"发货失败",然后将页面重定向到"/Shop-SS/admin/orders_weifa.html"路径
                return "<script>alert('发货失败');location.href='/Ascent/admin/orders_weifa.html';</script>";
            }
        }
    }

    // 使用@RequestMapping注解将HTTP请求映射到"/AdminGtByorderId.do"路径上,使用"produces"属性设置响应的MIME类型"text/html;charset=UTF-8;",以确保响应文的编码正确
    @RequestMapping(value = "/AdminGtByorderId.do", produces = "text/html;charset=UTF-8;")
    @ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
    // 用于查询订单信息,并将结果以字符串形式返回给客户端
    public String AdminGtByorderId(Integer id) throws Exception {
        return ordersServiceInter.adminGetords(id);
    }
}

