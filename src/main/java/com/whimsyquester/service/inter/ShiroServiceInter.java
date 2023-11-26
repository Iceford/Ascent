/*
 * @Description: Java接口,定义了权限相关的服务接口
 * @FilePath: \src\main\java\com\whimsyquester\service\inter\ShiroServiceInter.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-06 17:29:34
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved. 
 */
package com.whimsyquester.service.inter;

public interface ShiroServiceInter {

	// 查询所有信息:该方法没有参数,返回一个String类型的值表示查询到的所有权限信息的JSON格式字符串
	String GetsShiros() throws Exception;

	// 更新权限:该方法接收一个Integer类型的参数shiroId和一个Integer类型的参数userId,返回一个boolean类型的值表示更新用户权限的结果
	boolean AdminUpdateShi(Integer shiroId, Integer userId) throws Exception;

}

