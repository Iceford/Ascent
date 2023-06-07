/*
 * @Description: Java接口,定义了订单相关的服务接口
 * @FilePath: \src\main\java\com\ssm\service\inter\OrdersServiceInter.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-06 17:27:17
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.service.inter;

public interface OrdersServiceInter {

	// 查询订单总数:该方法接收一个Integer类型的参数num,返回一个String的值表示订单总数。
	String getCounts(Integer num) throws Exception;

	// 分页查询订单信息:该方法接收一个Integer类型的参数page和Integer类型的参数order_userid,返回一个String类型的值表示查询到的订单信息的JSON格式字符串
	String FenyeList(Integer page, Integer order_userid) throws Exception;

	// 删除订单:该方法接收一个Integer类型的参数id,返回一个String类型的值表示订单的结果
	String delByidOrders(Integer id) throws Exception;

	// 支付订单:该方法接收一个Integer类型的参数id,返回一个String类型的值表示支付订单的结果
	String PayOrders(Integer id) throws Exception;

	// 添加订单:该方法接收一个String类型的参数lists,返回一个String类型的值表示添加订单的结果
	String addOrders(String lists) throws Exception;

	// 查询待支付订单:该方法接收一个Integer类型的参数status,返回一个String类型的值表示查询到的待支付订单信息的JSON格式
	String adminDaipays(Integer status) throws Exception;

	// 查询物流信息:该方法接收一个String类型的参数status,返回一个String类型的值表示查询到的物流信息的JSON格式字符串
	String adminLogistics(String status) throws Exception;

	// 删除订单:该方法接收一个Integer类型的参数id和一个Integer类型的参数shiro_id,返回一个String类型的值表示删除订单的结果
	String adminDelsOrders(Integer id, Integer shiro_id) throws Exception;

	// 用于发货:该方法接收一个Integer类型的参数id,返回一个boolean类型的值表示发货的结果
	boolean adminFaOrdes(Integer id) throws Exception;

	// 用于查询订单信息:该方法接收一个Integer类型的参数id,返回一个String类型的值表示查询到的订单信息的JSON格式字符串
	String adminGetords(Integer id) throws Exception;

}
