/*
 * @Description: 实现了接口GoodsServiceInter的Java类,用于对商品进行增删改查的操作
 * @FilePath: \src\main\java\com\ssm\service\impl\GoodsServiceImpl.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-06 22:46:09
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.ssm.dao.GoodsMapper;
import com.ssm.enums.Shiros;
import com.ssm.po.Goods;
import com.ssm.po.GoodsList;
import com.ssm.service.inter.GoodsServiceInter;

public class GoodsServiceImpl implements GoodsServiceInter {
	// 使用@Autowired注解，自动装配GoodsMapper类的实例
	@Autowired
	private GoodsMapper goodsMapper;

	// 实现了getIdGoods方法,用于查询某个商品的详细信息
	@Override
	public String getIdGoods(Integer id) throws Exception {
		// 调用GoodsMapper中的getIdGoods方法，查询指定id的商品信息
		Goods goods = goodsMapper.getIdGoods(id);
		// 将结果转换为JSON格式返回
		return JSON.toJSONString(goods);
	}

	// 实现了roundGoods方法,用于查询所有商品的信息
	@Override
	public String roundGoods() throws Exception {
		// 调用GoodsMapper中的roundGoods方法，查询所有商品的信息，并将结果转换为JSON格式返回
		return JSON.toJSONString(goodsMapper.roundGoods());
	}

	// 实现了getTypeIdList方法,用于查询某个商品类型下的所有商品
	@Override
	public String getTypeIdList(Integer id) throws Exception {
		// 调用GoodsMapper中的getTypeIdList方法，查询指定类型下的所有商品信息
		List<GoodsList> lists = goodsMapper.getTypeIdList(id);
		// 将结果转换为JSON格式返回
		return JSON.toJSONString(lists);
	}

	// 实现了secahByBanmes方法,用于根据商品名称模糊查询商品信息
	@Override
	public String secahByBanmes(String name) throws Exception {
		// 调用GoodsMapper中的searchByName方法，查询指定名称的所有商品信息
		List<Goods> lists = goodsMapper.searchByName(name);
		// 将结果转换为JSON格式返回
		return JSON.toJSONString(lists);
	}

	// 实现了AdminManyToOne方法,用于查询所有商品的信息并分页显示
	@Override
	public String AdminManyToOne(Integer num) throws Exception {
		// 调用GoodsMapper中的AdminManyToOne方法，查询所有商品的信息，并将结果转换为JSON格式返回
		return JSON.toJSONString(goodsMapper.AdminManyToOne(num));
	}

	// 实现了AdminCounts方法,用于查询商品总数
	@Override
	public String AdminCounts() throws Exception {
		// 调用GoodsMapper中的Admincounts方法，查询商品总数
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("count", goodsMapper.Admincounts());
		// 将结果转换为JSON格式返回
		return JSON.toJSONString(map);
	}

	// 实现了AdmindelGoods方法,用于删除指定id的商品
	@Override
	public String AdmindelGoods(Integer id, Integer shiro_id) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		// 如果当前用户不是超级管理员，则返回-1
		if (shiro_id != Shiros.SuperAdmin.getCode()) {
			map.put("state", "-1");
		} else {
			// 否则通过调用GoodsMapper中的AdminDelGoods方法，删除指定id的商品
			int num = goodsMapper.AdminDelGoods(id);
			if (num > 0) {
				map.put("state", "1");
			}
		}
		// 将结果转换为JSON格式返回
		return JSON.toJSONString(map);
	}

	// 实现了AdminDels方法,用于批量删除商品
	@Override
	public String AdminDels(String ids, Integer shiro_id) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		// 如果当前用户不是超级管理员，则返回-1
		if (shiro_id != Shiros.SuperAdmin.getCode()) {
			map.put("state", "-1");
		} else {
			// 否则将传入的字符串ids按照逗号分隔，得到一个字符串数组
			String[] id = ids.split(",");
			// 调用GoodsMapper中的AdminDels方法，批量删除指定id的商品
			int num = goodsMapper.AdminDels(id);
			if (num > 0) {
				map.put("state", "1");
			}
		}
		// 将结果转换为JSON格式返回
		return JSON.toJSONString(map);
	}

	// 实现了AdminupdaGoods方法,用于更新商品信息
	@Override
	public boolean AdminupdaGoods(Goods goods) throws Exception {
		boolean bol = false;
		// 如果传入的商品信息为空或商品名称为空，则返回false
		if (goods == null) {
			bol = false;
		} else {
			// 否则通过调用GoodsMapper中的adminUpdatGoods方法，更新商品信息并返回更新结果
			int num = goodsMapper.adminUpdatGoods(goods);
			if (num > 0) {
				bol = true;
			} else {
				bol = false;
			}
		}
		return bol;
	}

	// 实现了AdminAddGood方法,用于添加商品信息
	@Override
	public boolean AdminAddGood(Goods goods) throws Exception {
		boolean bol = false;
		// 如果传入的商品信息为空或商品名称为空，则返回false
		if (goods == null || goods.getGoods_name() == null) {
			bol = false;
		} else {
			// 否则通过调用GoodsMapper中的adminAddGoods方法，添加商品信息并返回添加结果
			int num = goodsMapper.adminAddGoods(goods);
			if (num > 0) {
				bol = true;
			} else {
				bol = false;
			}
		}
		return bol;
	}

	// 实现了adminUpdateByTypes方法,用于更新商品类型信息
	@Override
	public boolean adminUpdateByTypes(Goods goods) throws Exception {
		boolean bol = false;
		// 如果传入的商品类型信息为空，则返回false
		if (goods == null) {
			bol = false;
		} else {
			// 否则通过调用GoodsMapper中的adminUpdateByType方法，更新商品类型信息并返回更新结果
			int num = goodsMapper.adminUpdateByType(goods);
			if (num > 0) {
				bol = true;
			} else {
				bol = false;
			}
		}
		return bol;
	}

}
