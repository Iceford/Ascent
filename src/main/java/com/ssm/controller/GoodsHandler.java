/*
 * @Description: 基于Spring MVC框架的商品控制器类，用于处理商品相关的请求
 * @FilePath: \src\main\java\com\ssm\controller\GoodsHandler.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-07 09:49:31
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.controller;

import java.io.File;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.po.Goods;
import com.ssm.service.inter.GoodsServiceInter;

@Controller // 使用@Controller注解来标识该类为控制器类
public class GoodsHandler {

	// 使用@Autowired注解来自动装配GoodsServiceInter类型的对象goods
	@Autowired
	private GoodsServiceInter goods;

	// 使用@RequestMapping注解指示处理的请求路径为/getIdGoods.do
	@RequestMapping(value = "getIdGoods.do", produces = "text/html;charset=UTF-8;")
	@ResponseBody // 使用@ResponseBody注解来指示返回的是一个字符串，而不是一个视图

	// 用于处理获取某个商品的请求
	public String getIdGoods(Integer id) throws Exception {
		// 调用goods对象的roundGoods方法来获取所有商品的信息
		String gods = goods.getIdGoods(id);
		// 将roundGoods方法的返回值作为字符串返回给客户端
		return gods;
	}

	// 使用@RequestMapping注解指示处理的请求路径为/getIdGoods.do
	@RequestMapping(value = "roundGoods.do", produces = "text/html;charset=UTF-8;")
	@ResponseBody // 使用@ResponseBody注解来指示返回的是一个字符串，而不是一个视图
	// 用于处理获取某个类型的所有商品的请求
	public String roundGoods() throws Exception {
		// 调用goods对象的getTypeIdList方法来获取该类型的所有商品信息,将返回值作为字符串返回给客户端
		return goods.roundGoods();
	}

	@RequestMapping(value = "getTypeIdlist.do", produces = "text/html;charset=UTF-8;")
	@ResponseBody // 使用@ResponseBody注解来指示返回的是一个字符串，而不是一个视图
	public String getTypeIdlist(Integer id) throws Exception {
		String lists = goods.getTypeIdList(id);
		return lists;
	}

	// 使用@RequestMapping注解来指示处理的请求路径为/getByNames.do
	@RequestMapping(value = "getByNames.do", produces = "text/html;charset=UTF-8;")
	@ResponseBody // 使用@ResponseBody注解来指示返回的是一个字符串，而不是一个视图
	// 用于处理根据商品名称搜索商品的请求
	public String getByNames(String name) throws Exception {
		// 调用goods对象的secahByBanmes方法来搜索商品信息,将返回值作为字符串返回给客户端
		return goods.secahByBanmes(name);
	}

	// 使用@RequestMapping注解来指示处理的请求路径为/AdminGetCounts.do
	@RequestMapping(value = "AdminGetCounts.do")
	@ResponseBody // 使用@ResponseBody注解来指示返回的是一个字符串，而不是一个视图
	// 用于处理获取商品总数的请求
	public String AdminGetCounts() throws Exception {
		// 调用goods对象的AdminCounts方法来获取商品总数,将返回值作为字符串返回给客户端
		return goods.AdminCounts();
	}

	// 使用@RequestMapping注解来指示处理的请求路径为/adminListPage.do
	@RequestMapping(value = "adminListPage.do", produces = "text/html;charset=UTF-8;")
	@ResponseBody // 使用@ResponseBody注解来指示返回的是一个字符串，而不是一个视图
	// 用于处理获取商品列表的请求
	public String adminListPage(Integer num) throws Exception {
		// 调用goods对象的AdminManyToOne方法来获取商品列表信息,将返回值作为字符串返回给客户端
		return goods.AdminManyToOne(num);
	}

	// 使用@RequestMapping注解来指示处理的请求路径为/admindelsGood.do
	@RequestMapping(value = "adminDelgoods.do")
	@ResponseBody // 使用@ResponseBody注解来指示返回的是一个字符串，而不是一个视图
	public String adminDelgoods(Integer id, Integer shiro_id) throws Exception {
		return goods.AdmindelGoods(id, shiro_id);
	}

	// 使用@RequestMapping注解来指示处理的请求路径为/admindelsGood.do
	@RequestMapping(value = "admindelsGood.do")
	@ResponseBody // 使用@ResponseBody注解来指示返回的是一个字符串，而不是一个视图
	// 用于处理删除多个商品的请求
	public String admindelsGood(String ids, Integer shiro_id) throws Exception {
		// 调用goods对象的AdminDels方法来删除多个商品信息,将返回值作为字符串返回给客户端
		return goods.AdminDels(ids, shiro_id);
	}

	// 使用@RequestMapping注解来指示处理的请求路径为/adminUpdateGoods.do
	@RequestMapping("/adminUpdateGoods.do")
	// 用于处理修改商品信息的请求
	public void adminUpdateGoods(Goods good, HttpServletResponse response) throws Exception {
		// 调用goods的AdminupdaGoods方法来修改商品信息
		boolean flag = goods.AdminupdaGoods(good);
		if (flag) {
			// 如果修改成功将重定向到商品列表页面
			response.sendRedirect("/Shop-SSM/admin/goods_list.html");
		} else {
			// 否则将弹出一个提示框，提示修改失败
			response.setContentType("text/html;charset=utf-8");
			response.getWriter()
					.println("<script>alert('修改失败！');location.href='/Shop-SSM/admin/goods_list.html';</script>");
		}
	}

	// 使用@RequestMapping注解来指示处理的请求路径为/adminUpdateGoods.do
	@RequestMapping("/AdminaddGoods.do")
	// 用于处理添加商品信息的请求
	public void AdminaddGoods(Goods good, HttpServletResponse response, MultipartFile imgs) throws Exception {
		// 将商品信息添加到数据库中，并将商品图片保存到服务器的指定路径
		String oldImg = imgs.getOriginalFilename();// 获取图片原始名字
		if (imgs != null && oldImg != null && oldImg.length() > 0) { // 检查MultipartFile对象是否不为空且原始文件名长度大于0
			String path = "D:\\apache-tomcat-9.0.37\\webapps\\test\\"; // 图片保存的指定路径
			File file = new File(path + oldImg);
			imgs.transferTo(file);// 写入磁盘
			good.setGoods_img(oldImg);// 写入同时给图片属性赋值，以便存入数据库
		}
		// 调用goods对象的AdminAddGood方法来添加商品信息
		boolean flag = goods.AdminAddGood(good);
		if (flag) {
			// 如果添加成功,将重定向到商品列表页面
			response.sendRedirect("/Shop-SSM/admin/goods_list.html");
		} else {
			// 否则将弹出一个提示框，提示添加失败
			response.setContentType("text/html;charset=utf-8");
			response.getWriter()
					.println("<script>alert('添加失败！');location.href='/Shop-SSM/admin/goods_list.html';</script>");
		}
	}

	// 使用@RequestMapping注解来指示处理的请求路径为/adminGoodsBytype.do
	@RequestMapping("/adminGoodsBytype.do")
	// 用于处理将商品转移到其他类型的请求
	public void adminGoodsBytype(Goods god, HttpServletResponse response) throws Exception {
		// 调用goods对象的adminUpdateByTypes方法来将商品转移到其他类型
		boolean flag = goods.adminUpdateByTypes(god);
		if (flag) {
			// 如果转移成功，将重定向到商品类型更新页面
			response.sendRedirect("/Shop-SSM/admin/goods_type_update.html");
		} else {
			// 否则将弹一个提示框，提示转移失败
			response.setContentType("text/html;charset=utf-8");
			response.getWriter()
					.println("<script>alert('转移失败！');location.href='/Shop-SSM/admin/goods_list.html';</script>");
		}
	}
}
