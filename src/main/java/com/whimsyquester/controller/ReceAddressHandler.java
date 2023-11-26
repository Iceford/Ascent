/*
 * @Description: 基于Spring MVC框架的收货地址控制器类,用于处理与收货地址服务的请求
 * @FilePath: \src\main\java\com\whimsyquester\controller\ReceAddressHandler.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-07 11:02:21
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved.
 */
package com.whimsyquester.controller;

import com.whimsyquester.po.ReceAddress;
import com.whimsyquester.service.inter.ReceAddressInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 标识该类是一个控制器
public class ReceAddressHandler {
    // 使用@Autowired注解将ReceAddressInter类型的"receAddress"属性注入到该类中
    @Autowired
    private ReceAddressInter receAddress;

    // 使用@RequestMapping注解将请求映射到"/getByIdaddress.do"路径上,使用"produces"属性设置响应的MIME类型"text/html;charset=UTF-8;",以确保响应文的编码正确
    @RequestMapping(value = "/getByIdaddress.do", produces = "text/html;charset=UTF-8;")
    @ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
    // 用于根据收货地址ID查询收货地址信息,并将结果以字符串形式返回给客户端
    public String getByIdAddress(Integer id) throws Exception {
        String address = receAddress.getByIdAddress(id);
        return address;
    }

    // 使用@RequestMapping注解将请求映射到"/updateAddress.do"路径上
    @RequestMapping("/updateAddress.do")
    @ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
    // 用于更新收货地址信息,并将结果以字符串形式返回给客户端
    public String updateAddress(ReceAddress address) throws Exception {
        String ads = receAddress.updateAddress(address);
        return ads;
    }
}

