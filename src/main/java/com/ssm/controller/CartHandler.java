/*
 * @Description: 基于Java Spring MVC框架的控制器类，用于处理购物车相关的请求
 * @FilePath: \src\main\java\com\ssm\controller\CartHandler.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-06 23:33:39
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.GoodsCart;
import com.ssm.service.inter.CartServiceInter;

@Controller // 标识该类为控制器类

public class CartHandler {
	// 使用@Autowired注解来自动装配一个CartServiceInter类型的对象cartInter
	@Autowired
	private CartServiceInter cartInter;

	@RequestMapping("/addCrat.do") // 指示处理的请求路径为/addCrat.do
	@ResponseBody // 使用@ResponseBody注解来指示返回的是一个字符串，而不是一个视图

	// 用于处理添加商品到购物车的请求
	public String addCrat(GoodsCart cart) throws Exception {
		// 调用cartInter对象的addCart方法来将商品添加到购物车中,最后将addCart方法的返回值作为字符串返回给客户端
		return cartInter.addCart(cart);
	}

	// 使用@RequestMapping注解来指示处理的请求路径为/getUserIdC.do
	// 使用produces属性来指定响应的内容类型为text/html;charset=UTF-8
	@RequestMapping(value = "/getUserIdC.do", produces = "text/html;charset=UTF-8;")
	@ResponseBody // 使用@ResponseBody注解来指示返回的是一个字符串，而不是一个视图

	// 用于处理获取购物车中某个用户的所有商品的请求
	public String getUserIdC(Integer id) throws Exception {
		// 接收一个Integer类型的id参数并调用cartInter对象的findUserIdC方法来获取该用户的所有商品信息
		return cartInter.findUserIdC(id);
	}

	@RequestMapping(value = "/delByid.do") // 使用@RequestMapping注解来指示处理的请求路径为/delByid.do
	@ResponseBody // 使用@ResponseBody注解来指示返回的是一个字符串，而不是一个视图

	// 用于处理删除购物车中某个商品的请求
	public String delByid(Integer id) throws Exception {
		return cartInter.delByid(id);
	}

	// 使用@RequestMapping注来指示处理的请求路径为/delByIdsA.do
	@RequestMapping(value = "/delByIdsA.do")
	@ResponseBody // 使用@ResponseBody注解来指示返回的是一个字符串，而不是一个视图
	
	// 用于处理删除购物车中多个商品的请求
	public String delByIdsA(String ids) throws Exception {
		return cartInter.delByIdS(ids);
	}

}
