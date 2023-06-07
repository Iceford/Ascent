/*
 * @Description: 基于Spring MVC框架的商品控制器类,用于处理与商品类型相关的请求
 * @FilePath: \src\main\java\com\ssm\controller\GoodsTypeHandler.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-07 10:08:36
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.GoodsType;
import com.ssm.service.inter.TypeServiceInter;

@Controller // 标识该类是一个控制器
public class GoodsTypeHandler {
	@Autowired // 将TypeServiceInter类型的对象注入到该类中
	private TypeServiceInter typeInetr;

	// @RequestMapping注解的value属性指请求的路径,produces属性指定响应的MIME类型和字符集编码。
	@RequestMapping(value = "/getGoods.do", produces = "text/html;charset=UTF-8;")
	@ResponseBody // 使用@ResponseBody注解将返回的数据直接写入响应体中
	// 用于处理"/getGoods.do"请求,返回商品类型的JSON数据
	public String goodsIndex() throws Exception {
		String goods = typeInetr.goodsIndex();
		return goods;
	}

	// @RequestMapping注解的value属性指请求的路径
	@RequestMapping(value = "/del_types.do")
	@ResponseBody // 使用@ResponseBody注解将返回的数据直接写入响应体中
	// 用于将指定id的商品类型从数据库中删除
	public String del_types(Integer id, Integer shiro_id) throws Exception {
		return typeInetr.admin_delType(id, shiro_id);
	}

	// 使用@RequestMapping注解将请求映射到"/addType.do"路径上
	@RequestMapping(value = "/addType.do")
	// 用于将新的商品类型添加到数据库中,并根据添加结果重定向或输出响应内容
	public void addType(GoodsType type, HttpServletResponse response) throws Exception {
		// 调用typeInetr.AdminAddType(type)方法,将商品类型添加到数据库中
		boolean flag = typeInetr.AdminAddType(type);
		if (flag) {
			// 如果添加成功,则使用response.sendRedirect()重定向到"/Shop-SSM/admin/goods_sort.html"页面
			response.sendRedirect("/Shop-SSM/admin/goods_sort.html");
		} else {
			// 否则使用response.setContentType()方法设置响应的MIME类型和字符集编码
			response.setContentType("text/html;charset=utf-8");
			// 然后使用response.getWriter()方法获取输出流,输出一个JavaScript弹窗提示添加失败,并使用location.href属性将页面重定向到"/Shop-SSM/admin/add_type.html"页面
			response.getWriter()
					.println("<script>alert('添加失败！');location.href='/Shop-SSM/admin/add_type.html';</script>");
		}
	}

	// @RequestMapping注解的value属性指请求的路径,produces指定响应的MIME类型和字符集编码
	@RequestMapping(value = "/AdminGetType.do", produces = "text/html;charset=UTF-8;")
	@ResponseBody // 使用@ResponseBody注解将返回的数据直接写入响应体中
	// 用于获取指定id的商品类型,并将返回的字符串会被直接发送给客户端
	public String AdminGetType(Integer id) throws Exception {
		return typeInetr.AdminGetIdType(id);
	}

	// 使用@RequestMapping注解将请求映射到"/AdminUpdateType.do"路径上
	@RequestMapping(value = "/AdminUpdateType.do")
	// 用于将修改后的商品类型更新到数据库中,并根据更新结果重定向或输出响应内容
	public void AdminUpdateType(GoodsType type, HttpServletResponse response) throws Exception {
		// 调用typeInetr.AdminUpdateTypes(type)方法,将商品类型更新到数据库中
		boolean flag = typeInetr.AdminUpdateTypes(type);
		if (flag) {
			// 如果更新成功,则使用response()重定向到"/Shop-SSM/admin/goods_sort.html"页面
			response.sendRedirect("/Shop-SSM/admin/goods_sort.html");
		} else {
			// 否则使用response.setContentType()方法设置响应的MIME类型和字符集编码
			response.setContentType("text/html;charset=utf-8");
			// 然后使用response.getWriter()方法获取输出流,输出一个JavaScript弹窗提示修改失败,并使用location.href属性将页面重定向到"/Shop-SSM/admin/goods_sort.html"页面
			response.getWriter()
					.println("<script>alert('修改失败！');location.href='/Shop-SSM/admin/goods_sort.html';</script>");
		}
	}
}
