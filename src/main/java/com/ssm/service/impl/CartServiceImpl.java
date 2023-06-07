/*
 * @Description: 实现了接口CartServiceInter的Java类,用于对购物车进行增删改查的操作
 * @FilePath: \src\main\java\com\ssm\service\impl\CartServiceImpl.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-06 22:11:57
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.ssm.dao.CartMapper;
import com.ssm.po.GoodsCart;
import com.ssm.service.inter.CartServiceInter;

public class CartServiceImpl implements CartServiceInter {

	// 使用了@Autowired注解,自动装配CartMapper类的实例
	@Autowired
	private CartMapper carts;

	// 实现了addCart方法,用于向购物车中添加商品
	@Override
	public String addCart(GoodsCart cart) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		// 对传入的参数cart进行非空判断
		if (cart != null) {
			// 调用CartMapper中的findGetName方法,查询购物车中是否已经存在该商品
			GoodsCart cartId = carts.findGetName(cart.getUsers_id(), cart.getGoods_name());
			// 如果不存在,则调用CartMapper中的addCart方法,将商品添加到购物车中
			if (cartId == null) {
				int num = carts.addCart(cart);
				if (num > 0) {
					map.put("state", "1");
				} else {
					map.put("state", "0");
				}
			} else if (cartId != null) {
				// 如果已经存在,则将传入的商品数量与购物车中已有的商品数量相加
				cart.setId(cartId.getId());
				cart.setGoods_num(cartId.getGoods_num() + cart.getGoods_num());
				// 调用CartMapper中的updateByid方法,更新购物车中该商品的数量
				int nums = carts.updateByid(cart);
				if (nums > 0) {
					map.put("state", "1");
				} else {
					map.put("state", "0");
				}
			}
		} else {
			System.out.println("");
		}
		return JSON.toJSONString(map);
	}

	// 实现findUserIdC方法,用于查询某个用户的购物车中的所有商品
	@Override
	public String findUserIdC(Integer id) throws Exception {
		// 通过调用CartMapper中的findByUserId方法,查询该用户的所有购物车商品
		List<GoodsCart> lists = carts.findByUserId(id);
		// 将结果转换为JSON格式返回
		return JSON.toJSONString(lists);
	}

	// 实现delByid方法,用于删除购物车中的某个商品通过调用CartMapper中的delByid方法,删除购物车中指定id的商品
	@Override
	public String delByid(Integer id) throws Exception {
		Map<String, String> map = new HashMap<>();
		int num = carts.delByid(id);
		if (num > 0) {
			map.put("state", "1");
		} else {
			map.put("state", "0");
		}
		return JSON.toJSONString(map);
	}

	// 实现了delByIdS方法,用于批量删除购物车中的商品
	@Override
	public String delByIdS(String strs) {
		// 将传入的字符串strs按照逗号分隔,得到一个字符串数组
		String[] str = strs.split(",");
		// 调用CartMapper中的delByIdsArry方法,批量删除购物车中指定id的商品
		int num = carts.delByIdsArry(str);
		Map<String, String> map = new HashMap<>();
		if (num > 0) {
			map.put("state", "1");
		} else {
			map.put("state", "0");
		}
		return JSON.toJSONString(map);
	}

}