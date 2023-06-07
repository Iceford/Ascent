/*
 * @Description: Java类,名为AdminUserServiceImpl,实现了AdminUserServiceInter接口
 * @FilePath: \src\main\java\com\ssm\service\impl\admin\AdminUserServiceImpl.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-06 21:58:59
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.service.impl.admin;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.dao.AdminUserMapper;
import com.ssm.po.AdminUser;
import com.ssm.po.AdminUserOV;
import com.ssm.service.inter.admin.AdminUserServiceInter;

public class AdminUserServiceImpl implements AdminUserServiceInter {

	@Autowired
	private AdminUserMapper adminMapper;

	// 验证管理员用户的登录信息,并将其存储在Cookie和Session中,以便在后续的请求中使用
	@Override
	public boolean adminLogin(AdminUser adminUser) throws Exception {
		boolean blo = false;
		// 调用AdminUserMapper对象的adminLogin方法,将传入的AdminUser对象作为参数,从数据库中查询是否存在该管理员用户
		AdminUser user = adminMapper.adminLogin(adminUser);
		if (user != null) {
			blo = true; // 如果存在将blo变量的值设置为true
			// 将该用户对象转换为JSON格式的字符串,并将其存储在Cookie和Session中,以便在后续的中使用
			String jsonUser = JSONObject.toJSONString(user);
			System.out.println(jsonUser);
			// 创建一个名为"admin-users"的Cookie,并将该JSON格式的字符串进行URL编码后作为Cookie的值
			Cookie cookies = new Cookie("admin-users", java.net.URLEncoder.encode(jsonUser, "UTF-8"));
			// 使用Spring框架的ServletRequestAttributes类获取HttpServletRequest和HttpServletResponse对象,将Cookie添加到响应中
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getResponse();
			response.addCookie(cookies);
			// 使用Spring框架的ServletRequestAttributes类获取HttpServletRequest和HttpServletResponse对象,将Cookie添加到响应中
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			// 将JSON的字符串存储在Session中,以便在后续的请求中使用
			request.getSession().setAttribute("admin-users", jsonUser);
		} else {
			// 如果不存在该管理员用户,则返回false
			return false;
		}
		return blo;
	}

	// 注销当前用户的登录状态,接收两个参数,一个是类型的request对象,另一个是HttpServletResponse类型的response对象
	@Override
	public void LoginOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 通过request.getSession()方法获取当前用户的session对象
		HttpSession session = request.getSession();
		// 调用session.removeAttribute("admin-users")方法将session中名为"admin-users"的属性移除
		session.removeAttribute("admin-users");
		// 调用session.invalidate()方法使session失效
		session.invalidate();
		// 通过request.getCookies()方法获取当前用户的所有cookie
		Cookie[] cookies = request.getCookies();
		// 遍历每个cookie,将其最大存活时间设置为0
		for (Cookie ck : cookies) {
			ck.setMaxAge(0);
			// 通过response.addCookie(ck)方法将cookie添加到响应中,使其失效
			response.addCookie(ck);
		}
	}

	// 获取所有管理员用户信息:无参数,返回一个字符串类型的JSON格式数据
	@Override
	public String GetAdmins() throws Exception {
		// 调用了adminMapper对象的GetAdmin()方法,返回一个AdminUserOV类型的列表
		List<AdminUserOV> lists = adminMapper.GetAdmin();
		// 使用JSON.toJSONString(lists)方法将列表转换为JSON格式的字符串,并将其作为返回值返回
		return JSON.toJSONString(lists);
	}

}
