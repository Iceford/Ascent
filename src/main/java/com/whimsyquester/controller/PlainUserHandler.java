/*
 * @Description: 基于Spring MVC框架的用户服务控制器类,用于处理与用户相关服务的请求
 * @FilePath: \src\main\java\com\whimsyquester\controller\PlainUserHandler.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-07 10:55:57
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved. 
 */
package com.whimsyquester.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whimsyquester.po.UserP;
import com.whimsyquester.service.inter.UserServiceInter;

@Controller // 标识该类是一个控制器
public class PlainUserHandler {
	// 使用@Autowired注解自动注入UserServiceInter的实例
	@Autowired
	private UserServiceInter serviceInter;

	// 使用@RequestMapping注解将请求映射到"/login.do"路径上
	@RequestMapping("/login.do")
	@ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
	// 用于用户登录,并将结果以字符串形式返回给客户端
	public String loginUsers(String users, String password) throws Exception {
		String states = serviceInter.login(users, password);
		return states;
	}

	// 使用@RequestMapping注解将请求映射到"/updateMagess.do"路径上
	@RequestMapping("/updateMagess.do")
	// 用于更新用户信息,并将结果以字符串形式返回给客户端
	public String updateMagess(UserP userP) throws Exception {
		// 将"userP"参数传递给serviceInter.updateUsers()方法进行处理
		serviceInter.updateUsers(userP);
		// 使用"redirect"关键字将请求重定向到"/user/user_center_info.html"路径
		return "redirect:/user/user_center_info.html";
	}

	// 使用@RequestMapping注解将请求映射到"/updatePwds.do"路径上
	@RequestMapping("/updatePwds.do")
	@ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
	// 用于更新用户密码,并将结果以字符串形式返回给客户端
	public String updatePwds(UserP userP, String oldPwd) throws Exception {
		// 将"userP"和"oldPwd"参数传递给serviceInter.updatePwds()方法进行处理,并将返回值赋给"state"变量
		String state = serviceInter.updatePwds(userP, oldPwd);
		// 将返回值将被转换为HTTP响应,并使用@ResponseBody注解将其作为响应正文发送回客户端
		return state;
	}

	// 使用@RequestMapping注解将请求映射到"/loginOut.do"路径上
	@RequestMapping("/loginOut.do")
	// 用于用户退出登录,并将结果以字符串形式返回给客户端
	public String loginOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 将"request"和"response"参数传递给serviceInter.longOut()方法进行处理
		// 该方法用于将用户从当前会话中注销,并清除与该用户相关的所有会话数据
		serviceInter.longOut(request, response);
		// 使用"redirect"关键字将请求重定向到"/user/login.html"路径
		return "redirect:/user/login.html";
	}

	// 使用@RequestMapping注解将请求映射到"/adminByidGetUser.do"路径上
	@RequestMapping("/adminByidGetUser.do")
	@ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
	// 用于根据用户ID查询用户信息,并将结果以字符串形式返回给客户端
	public String adminByidGetUser(Integer id) throws Exception {
		// 将"id"参数传递给serviceInterByIdPUser()方法进行处理,并将返回值作为HTTP响应的正文发送回客户端
		return serviceInter.AdminByIdPUser(id);
	}

	// 使用@RequestMapping注解将请求映射到"/adminGetByUsers.do"路径上,使用"produces"属性设置响应的MIME类型"text/html;charset=UTF-8;",以确保响应文的编码正确
	@RequestMapping(value = "/adminGetByUsers.do", produces = "text/html;charset=UTF-8;")
	@ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
	// 用于查询所有用户信息,并将结果以字符串形式返回给客户端
	public String adminGetByUsers() throws Exception {
		// 将"id"参数传递给serviceInterByIdPUser()方法进行处理,并将返回值作为HTTP响应的正文发送回客户端
		return serviceInter.AdmingetByuser();
	}

	// 使用@RequestMapping注解将请求映射到"/adminDelsUsers.do"路径上,使用"produces"属性设置响应的MIME类型"text/html;charset=UTF-8;",以确保响应文的编码正确
	@RequestMapping(value = "/adminDelsUsers.do", produces = "text/html;charset=UTF-8;")
	@ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
	// 用于删除用户,并将结果以字符串形式返回给客户端
	public String adminDelsUsers(Integer id, Integer shiro_id) throws Exception {
		// 检查"id"和"shiro_id"参数是否为null
		if (id == null || shiro_id == null) {
			// 如果其中任何一个参数为null,则返回一个JavaScript脚本,该脚本在客户端弹出一个警告框,然后将页面重定向到"/Ascent/admin/index.html"路径
			return "<script>alert('非法请求！');location.href='/Ascent/admin/index.html';</script>";
		} else {
			// 如果"id"和"shiro_id"参数都不为null,则将它们传递给serviceInter.AdminDleuser()方法进行处理,并将返回值作为HTTP响应的正文回客户端
			return serviceInter.AdminDleuser(id, shiro_id);
		}
	}

	// 使用@RequestMapping注解将请求映射到"/adminOneByManyOrder.do"路径上,使用"produces"属性设置响应的MIME类型"text/html;charset=UTF-8;",以确保响应文的编码正确
	@RequestMapping(value = "/adminOneByManyOrder.do", produces = "text/html;charset=UTF-8;")
	@ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
	// 用于查询所有用户信息,并将结果以字符串形式返回给客户端
	public String adminOneByManyOrder() throws Exception {
		return serviceInter.adminOnToMantyode();
	}

	// 使用@RequestMapping注解将请求映射到"/addPlainUsers.do"路径上,使用"produces"属性设置响应的MIME类型"text/html;charset=UTF-8;",以确保响应文的编码正确
	@RequestMapping(value = "/addPlainUsers.do", produces = "text/html;charset=UTF-8;")
	@ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
	// 用于添加用户,并将结果以字符串形式返回给客户端
	public String addPlainUsers(UserP userP) throws Exception {
		// 检查"userP"参数是否为null或者"userP"中的"users"属性是否为null
		if (userP.getUsers() == null || userP == null) {
			// 如果"userP"参数为null或者"users"属性为null,则一个JavaScript脚本,该脚本在客户端弹出一个警告框,然后将页面重定向到"/Ascent/user/register.html"路径
			return "<script>alert('非法请求！');location.href='/Ascent/user/register.html';</script>";
		} else {
			// 如果"userP"参数和"users"属性都不为null,则将"userP"参数传递给serviceInter.addPlusers()方法进行处理
			boolean falg = serviceInter.addPlusers(userP);
			// 如果添加成功,则返回一个JavaScript脚本,该脚本在客户端弹出一个提示框,然后将页面重定向到"/Ascent/user/login.html"路径
			if (falg) {
				return "<script>alert('注册成功');location.href='/Ascent/user/login.html';</script>";
			} else {
				// 如果添加失败,则返回一个JavaScript脚本,该脚本在客户端弹出一个提示框,然后将页面重定向到"/Ascent/user/register.html"路径
				return "<script>alert('注册失败');location.href='/Ascent/user/register.html';</script>";
			}
		}
	}
}

