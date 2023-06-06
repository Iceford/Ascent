/*
 * @Description: 定义了一个Java接口OrdersMapper,用于访问数据库中的商品订单信息
 * @FilePath: \src\main\java\com\ssm\dao\OrdersMapper.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-06 15:37:09
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved.
 */
package com.ssm.dao;

import com.ssm.po.GoodsOrders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {

    // 查询商品订单总数
    int getCount(Integer num) throws Exception;

    // 分页查询商品订单信息
    List<GoodsOrders> FenyeList(@Param("page") Integer page, @Param("order_userid") Integer order_userid)
            throws Exception;

    // 根据订单id删除商品订单信息
    int deleteByidOrders(Integer id) throws Exception;

    // 支付订单，传入订单ID，返回一个整数表示支付结果
    int PayOrders(Integer id) throws Exception;

    // 添加订单，传入一个GoodsOrders对象，返回一个整数值表示添加结果
    int addOrdersMappers(GoodsOrders goodsOrders) throws Exception;

    // 管理员获取待支付或等待支付的订单列表，传入订单状态，返回一个GoodsOrders对象列表
    List<GoodsOrders> adminDaiOrWaitPay(Integer status) throws Exception;

    // 管理员获取等待物流的订单列表，传入订单状态，返回一个GoodsOrders对象列表
    List<GoodsOrders> adminlogisticsWait(String status) throws Exception;

    // 管理员发货，传入订单ID，返回一个整数值表示发货结果
    int adminFahuoOrders(Integer id) throws Exception;

    // 管理员根据订单ID获取订单信息，传入订单ID，返回一个Goods对象列表
    List<GoodsOrders> adminGetByorder_id(Integer id) throws Exception;

}
