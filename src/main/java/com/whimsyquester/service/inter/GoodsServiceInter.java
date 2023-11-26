/*
 * @Description: Java接口,定义了商品相关的服务接口
 * @FilePath: \src\main\java\com\whimsyquester\service\inter\GoodsServiceInter.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-06 17:11:03
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved. 
 */
package com.whimsyquester.service.inter;

import com.whimsyquester.po.Goods;

public interface GoodsServiceInter {

	// 根据商品ID查询商品信息:接收一个Integer类型的参数id,返回一个String类型的值表示查询到的商品信息的JSON格式字符串
	String getIdGoods(Integer id) throws Exception;

	// 随机产生商品:该方法无参数,返回一个String类型的值表示随机产生的商品信息的JSON格式字符串
	String roundGoods() throws Exception;

	// 根据商品种类ID查询商品信息并进行分页:该方法接收一个Integer类型的参数id,返回一个String类型的值表示查询到的商品信息的JSON格式字符串
	String getTypeIdList(Integer id) throws Exception;

	// 根据商品名称查询商品信息:该方法接收一个String类型的参数name,返回一个String类型的值表示查询到的商品信息的JSON格式字符串
	String secahByBanmes(String name) throws Exception;

	// 多对一查询:该方法接收一个Integer类型的参数num,返回一个String`类型的值表示查询到的商品信息的JSON格式字符串
	String AdminManyToOne(Integer num) throws Exception;

	// 查询商品总数:该方法没有参数,返回一个String类型的值表示商品总数
	String AdminCounts() throws Exception;

	// 删除商品:该方法接收一个Integer类型的参数id和一个Integer的参数shiro_id,返回一个String类型的值表示删除商品的结果
	String AdmindelGoods(Integer id, Integer shiro_id) throws Exception;

	// 批量删除商品:该方法接收一个String类型的参数ids和一个Integer类型的参数shiro_id,返回一个String类型的值表示批量删除商品的结果
	String AdminDels(String ids, Integer shiro_id) throws Exception;

	// 更新商品信息:该方法接收一个Goods类型的参数goods,返回一个boolean类型的值表示更新商品信息的结果
	boolean AdminupdaGoods(Goods goods) throws Exception;

	// 添加商品:该方法接收一个Goods类型的参数goods,返回一个boolean类型的值表示添加商品的结果
	boolean AdminAddGood(Goods goods) throws Exception;

	// 根据商品种类更新商品信息:该方法接收一个Goods类型的参数goods,返回一个boolean类型的值表示更新商品信息的结果
	boolean adminUpdateByTypes(Goods goods) throws Exception;

}

