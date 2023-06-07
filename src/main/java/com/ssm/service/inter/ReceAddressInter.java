/*
 * @Description: Java接口,定义了收货地址相关的服务接口
 * @FilePath: \src\main\java\com\ssm\service\inter\ReceAddressInter.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-06 17:29:12
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.service.inter;

import com.ssm.po.ReceAddress;

public interface ReceAddressInter {

	// 根据收货地址ID查询收货地址信息:该方法接一个Integer类型的参数id,返回一个String类型的值表示查询到的收货地址信息的JSON格式字符串
	String getByIdAddress(Integer id) throws Exception;

	// 更新收货地址信息:该方法接收一个ReceAddress类型的参数address,返回一个String类型的值表示更新收货地址信息的结果
	String updateAddress(ReceAddress address) throws Exception;

}
