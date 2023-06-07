/*
 * @Description: 基于Spring MVC框架的权限控制器类,用于处理与权限信息的请求
 * @FilePath: \src\main\java\com\ssm\controller\ShiroHandler.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-07 11:14:53
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.service.inter.ShiroServiceInter;

@Controller // 标识该类是一个控制器
public class ShiroHandler {

	// 使用@Autowired注解将ShiroServiceInter类型的"shiroInter"属性注入到该类中
	@Autowired
	private ShiroServiceInter shiroInter;

	// 使用@RequestMapping注解将请求映射到"GetsShiros.do"路径上,使用"produces"属性设置响应的MIME类型"text/html;charset=UTF-8;",以确保响应文的编码正确
	@RequestMapping(value = "GetsShiros.do", produces = "text/html;charset=UTF-8;")
	@ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
	// 用于查询所有信息,并将结果以字符串形式返回给客户端
	public String GetsShiros() throws Exception {
		return shiroInter.GetsShiros();
	}

	// 使用@RequestMapping注解将请求映射到"/updateAdminShiro.do/{shiroId}/{userId}"路径上,使用"produces"属性设置响应的MIME类型"text/html;charset=UTF-8;",以确保响应文的编码正确
	@RequestMapping(value = "/updateAdminShiro.do/{shiroId}/{userId}", produces = "text/html;charset=UTF-8;")
	@ResponseBody // 使用@ResponseBody注解表示返回的数据直接写入响应体中
	// 用于更新权限,并将结果以字符串形式返回给客户端
	public String updateAdminShiro(@PathVariable Integer shiroId, @PathVariable Integer userId) throws Exception {
		// 检查"shiroId"和"userId"是否为null
		if (shiroId == null || userId == null) {
			// 如果其中任意一个为null,则返回一个JavaScript脚本,该脚本在客户端弹出一个警告框,然后将页面重定向到"/Shop-SSM/admin/AdminUserShiro.html"路径
			return "<script>alert('非法请求！');location.href='/Shop-SSM/admin/AdminUserShiro.html'</script>";
		} else {
			// 如果"shiroId"和"userId"都不为null,则将它们传递给shiroInter.AdminUpdateShi()方法进行处理
			boolean flag = shiroInter.AdminUpdateShi(shiroId, userId);
			// 如果更新成功,则返回一个JavaScript脚本,该脚本在客户端弹一个提示框,然后将页面重定向到"/Shop-SSM/admin/AdminUserShiro.html"路径
			if (flag) {
				return "<script>alert('修改成功');location.href='/Shop-SSM/admin/AdminUserShiro.html'</script>";
			} else {
				// 如果更新失败,则返回一个JavaScript脚本,该脚本在客户端弹出一个提示框,然后将页面重定向到"/Shop-SSM/admin/AdminUserSh.html"路径
				return "<script>alert('修改失败');location.href='/Shop-SSM/admin/AdminUserShiro.html'</script>";
			}
		}
	}
}
