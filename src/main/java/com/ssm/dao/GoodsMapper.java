/*
 * @Description: 定义了一个Java接口GoodsMapper,用于访问数据库中的商品信息
 * @FilePath: \src\main\java\com\ssm\dao\GoodsMapper.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-05 23:12:53
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.dao;

import java.util.List;

import com.ssm.po.Goods;
import com.ssm.po.GoodsList;
import com.ssm.po.GoodsVo;

public interface GoodsMapper {

	// 以ID查询商品,接收一个Integer类型的参数id,表示商品ID,返回一个Goods类型的对象
	Goods getIdGoods(Integer id) throws Exception;

	// 随机查询两条,返回一个Goods类型的List集合
	List<Goods> roundGoods() throws Exception;

	// 以种类ID查询所有商品,接收一个Integer类型的参数id,表示商品种类ID,返回一个GoodsList类型的List集合
	List<GoodsList> getTypeIdList(Integer id) throws Exception;

	// 模糊查询商品,接收一个String类型的参数value,表示商品名称,返回一个Goods类型的List集合
	List<Goods> searchByName(String value) throws Exception;

	// 多对一查询,接收一个Integer类型的参数num,表示查询的数量,返回一个GoodsVo类型的List集合
	List<GoodsVo> AdminManyToOne(Integer num) throws Exception;

	// 查询商品总数,返回一个int类型的值
	int Admincounts() throws Exception;

	// 删除商品,接收一个Integer类型的参数id,表示商品ID,返回一个int类型的值
	int AdminDelGoods(Integer id) throws Exception;

	// 批量删除商品,接收一个String类型的数组ids,表示商品ID数组,返回一个int类型的值
	int AdminDels(String[] ids) throws Exception;

	// 修改商品信息,接收一个Goods类型的参数goods,表示商品信息,返回一个int类型的值
	int adminUpdatGoods(Goods goods) throws Exception;

	// 添加商品,接收一个Goods类型的参数goods,表示商品信息,返回一个int类型的值
	int adminAddGoods(Goods goods) throws Exception;

	// 转移商品类别,接收一个Goods类型的参数goods,表示商品信息,返回一个int类型的值
	int adminUpdateByType(Goods goods) throws Exception;
}
