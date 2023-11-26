/*
 * @Description: Java接口,定义了商品类型相关的服务接口
 * @FilePath: \src\main\java\com\whimsyquester\service\inter\TypeServiceInter.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-06 17:31:02
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved. 
 */
package com.whimsyquester.service.inter;

import com.whimsyquester.po.GoodsType;

public interface TypeServiceInter {

	// 查询商品类型信息:该方法没有参数,返回一个String类型的值表示查询到的商品类型信息的JSON格式字符串
	String goodsIndex() throws Exception;

	// 删除商品类型:该方法接收一个Integer类型的参数id和一个Integer类型的参数shiro_id,返回一个String类型的值表示删除商品类型的结果
	String admin_delType(Integer id, Integer shiro_id) throws Exception;

	// 添加商品类型:该方法接收一个GoodsType类型的参数type,返回一个boolean类型的值添加商品类型的结果
	boolean AdminAddType(GoodsType type) throws Exception;

	// 根据商品类型ID查询商品类型信息:该方法接收一个Integer类型的参数id,返回一个String类型的值表示查询到的商品类型信息的JSON格式。
	String AdminGetIdType(Integer id) throws Exception;

	// 更新商品类型信息:该方法接收一个GoodsType类型的参数type,返回一个boolean类型的值表示更新商品类型信息的结果
	boolean AdminUpdateTypes(GoodsType type) throws Exception;

}

