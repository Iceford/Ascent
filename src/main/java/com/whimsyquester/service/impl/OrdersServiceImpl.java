/*
 * @Description: 实现了接口OrdersServiceInter的Java类,用于对订单进行增删改查的操作
 * @FilePath: \src\main\java\com\whimsyquester\service\impl\OrdersServiceImpl.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-06 22:36:07
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved.
 */
package com.whimsyquester.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.whimsyquester.dao.OrdersMapper;
import com.whimsyquester.enums.Shiros;
import com.whimsyquester.po.GoodsOrders;
import com.whimsyquester.service.inter.OrdersServiceInter;
import com.whimsyquester.util.Time;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersServiceImpl implements OrdersServiceInter {

    // 使用了@Autowired注解,自动装配了OrdersMapper类的实例
    @Autowired
    private OrdersMapper orderMapper;

    // 实现了getCounts方法,用于查询订单总数
    @Override
    public String getCounts(Integer num) throws Exception {
        // 通过调用OrdersMapper中的getCount方法,查询指定状态的订单总数
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("state", orderMapper.getCount(num));
        // 将结果转换为JSON格式返回
        return JSON.toJSONString(map);
    }

    // 实现了FenyeList方法,用于查询订单列表并分页显示
    @Override
    public String FenyeList(Integer page, Integer shiro_id) throws Exception {
        // 通过调用OrdersMapper中的FenyeList方法,查询指定状态的订单列表
        List<GoodsOrders> lists = orderMapper.FenyeList(page, shiro_id);
        // 将结果转换为JSON格式返回
        return JSON.toJSONString(lists);
    }

    // 实现了delByidOrders方法,用于删除指定id的订单
    @Override
    public String delByidOrders(Integer id) throws Exception {
        // 通过调用OrdersMapper中的deleteByidOrders方法,删除指定id的订单
        Map<String, String> map = new HashMap<String, String>();
        int num = orderMapper.deleteByidOrders(id);
        if (num > 0) {
            map.put("state", "1");
        } else {
            map.put("state", "-1");
        }
        // 将结果转为JSON格式返回
        return JSON.toJSONString(map);
    }

    // 实现了PayOrders方法,用于支付指定id的订单
    @Override
    public String PayOrders(Integer id) throws Exception {
        // 通过调用OrdersMapper中的PayOrders方法,支付指定id的订单
        Map<String, String> map = new HashMap<String, String>();
        int num = orderMapper.PayOrders(id);
        if (num > 0) {
            map.put("state", "1");
        } else {
            map.put("state", "-1");
        }
        // 将结果转为JSON格式返回
        return JSON.toJSONString(map);
    }

    // 实现了addOrders方法,用于添加订单信息
    @Override
    public String addOrders(String lists) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        // 将传入的字符串lists截取掉前面的"lists=",得到一个JSON格式的字符串
        String jsonSubStr = lists.substring(6);
        int sum = 1;
        // 将JSON字符串转换为JSONArray,遍历JSONArray中的每个JSONObject
        JSONArray array = JSONArray.parseArray(jsonSubStr);
        for (int i = 0; i < array.size(); i++) {
            // 每个JSONObject转换为GoodsOrders对象
            JSONObject userJson = JSONObject.parseObject(array.getString(i));
            GoodsOrders goodsOrders = JSON.toJavaObject(userJson, GoodsOrders.class);
            // 设置订单日期、订单编号和订单状态
            goodsOrders.setOrder_date(Time.getTimes());
            goodsOrders.setOrder_code(Time.getTimeCode());
            goodsOrders.setOrder_state("未发货");// 默认未发货
            // 通过调用OrdersMapper中的addOrdersMappers方法,添加订单信息
            int num = orderMapper.addOrdersMappers(goodsOrders);
            sum = num;
        }
        if (sum > 0) {
            map.put("state", "1");
        } else {
            map.put("state", "-1");
        }
        // 将结果转换为JSON格式返回
        return JSON.toJSONString(map);
    }

    // 实现了adminDaipays方法,用于查询待支付或已支付的订单列表
    @Override
    public String adminDaipays(Integer status) throws Exception {
        // 通过调OrdersMapper中的adminDaiOrWaitPay方法,查询指定状态的订单列表
        List<GoodsOrders> lists = orderMapper.adminDaiOrWaitPay(status);
        // 将结果转换为JSON格式返回
        return JSON.toJSONString(lists);
    }

    // 实现了adminDelsOrders方法,用于删除指定id的订单
    @Override
    public String adminDelsOrders(Integer id, Integer shiro_id) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        // 如果当前用户不是超级管理员,则返回-1
        if (shiro_id != Shiros.SuperAdmin.getCode()) {
            map.put("state", "-1");// 权限不够
        } else {
            // 否则通过调用OrdersMapper中的deleteByidOrders方法,删除指定id的订单
            int num = orderMapper.deleteByidOrders(id);
            if (num > 0) {
                map.put("state", "1");// 删除成功
            }
        }
        // 将结果转换为JSON格式返回
        return JSON.toJSONString(map);
    }

    // 实现了adminLogistics方法,用于查询待发货的订单列表
    @Override
    public String adminLogistics(String status) throws Exception {
        // 通过调用OrdersMapper中的adminlogisticsWait方法,查询指定状态的订单列表
        List<GoodsOrders> lists = orderMapper.adminlogisticsWait(status);
        // 将结果转换为JSON格式返回
        return JSON.toJSONString(lists);
    }

    // 实现了adminFaOrdes方法,用于查询指定id的发货订单
    @Override
    public boolean adminFaOrdes(Integer id) throws Exception {
        boolean bol = false;
        // 如果传入的id为空,则返回false
        if (id == null) {
            bol = false;
        } else {
            // 否则,通过调用OrdersMapper中的adminFahuoOrders方法,发货指定id的订单,并返回发货结果
            int num = orderMapper.adminFahuoOrders(id);
            bol = num > 0;
        }
        return bol;
    }

    // 实现了adminGetords方法,用于查询指定id的订单详情
    @Override
    public String adminGetords(Integer id) throws Exception {
        // 通过调用OrdersMapper中的adminGetByorder_id方法,查询指定id的订单详情
        List<GoodsOrders> lists = orderMapper.adminGetByorder_id(id);
        // 将结果转换为JSON格式返回
        return JSON.toJSONString(lists);
    }

}

