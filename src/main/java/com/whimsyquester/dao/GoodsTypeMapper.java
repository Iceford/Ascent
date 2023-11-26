/*
 * @Description: 定义了一个Java接口GoodsTypeMapper,用于访问数据库中的商品类型
 * @FilePath: \src\main\java\com\whimsyquester\dao\GoodsTypeMapper.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-06 15:12:53
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved. 
 */
package com.whimsyquester.dao;

import java.util.List;
import com.whimsyquester.po.GoodsType;
import com.whimsyquester.po.GoodsTypeCustom;

public interface GoodsTypeMapper {

	// 获取商品类型的信息列表
	List<GoodsTypeCustom> goodsIndex() throws Exception;

	// 根据传入的id删除商品类型信息
	int admin_del_type(Integer id) throws Exception;

	// 添加管理员类别
	int AdminaddType(GoodsType type) throws Exception;

	// 根据传入的id获取对应的管理员类型
	GoodsType AdminGetIdType(Integer id) throws Exception;

	// 更新管理员类型
	int AdminUpdateType(GoodsType type) throws Exception;

}

