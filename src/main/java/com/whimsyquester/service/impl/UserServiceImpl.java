/*
 * @Description: 实现了接口UserServiceInter的Java类,用于用户登录、注销、修改密码、查询用户信息等操作
 * @FilePath: \src\main\java\com\whimsyquester\service\impl\UserServiceImpl.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: WhimsyQuester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-11-26 03:34:10
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved. 
 */
package com.whimsyquester.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whimsyquester.dao.ReceAddressMapper;
import com.whimsyquester.dao.UserMapper;
import com.whimsyquester.enums.Shiros;
import com.whimsyquester.po.UserP;
import com.whimsyquester.po.UserPVo;
import com.whimsyquester.service.inter.UserServiceInter;

public class UserServiceImpl implements UserServiceInter {

	// 使用@Autowired注解,自动装配UserMapper和ReceAddressMapper类的实例
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ReceAddressMapper receMapper;

	// 实现了login方法,用于用户
	@Override
	public String login(String users, String password) throws Exception {
		// 通过调用UserMapper中的loginUsers方法,查询用户名和密码是否匹配
		Map<String, String> map = new HashMap<String, String>();
		UserP userP = userMapper.loginUsers(users, password);
		// 如果匹配,则将用户信息转换为JSON格式,并将其存储到Cookie和Session中,返回登录成功
		if (userP != null) {
			map.put("state", "1");
			String jsonUser = JSONObject.toJSONString(userP);
			System.out.println(jsonUser);
			Cookie cookies = new Cookie("shop-users", java.net.URLEncoder.encode(jsonUser, "UTF-8"));
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getResponse();
			response.addCookie(cookies);
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			request.getSession().setAttribute("shop-users", jsonUser);
		} else {
			// 否则,返回登录失败
			map.put("state", "-1");
		}
		return JSON.toJSONString(map);
	}

	// 实现了updateUsers方法,用于更新用户信息
	@Override
	public void updateUsers(UserP userP) throws Exception {
		if (userP == null) {
			return;
		} else {
			// 通过调用UserMapper中的updateUsers方法,更新用户信息
			int num = userMapper.updateUsers(userP);
			if (num > 0) {
				String jsonUser = JSONObject.toJSONString(userMapper.getUsersId(userP.getId()));
				Cookie cookies = new Cookie("shop-users", java.net.URLEncoder.encode(jsonUser, "UTF-8"));
				HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
						.getResponse();
				// 将更新后的用户信息存储到Cookie中
				response.addCookie(cookies);
			}
		}
	}

	// 实现了updatePwds方法,用于修改用户密码
	@Override
	public String updatePwds(UserP userP, String oldPwd) throws Exception {
		// 通过调用UserMapper中的getUsersId方法,查询指定id的用户信息
		Map<String, String> map = new HashMap<String, String>();
		// 如果旧密码不匹配,则返回修改失败
		if (userP == null) {
			map.put("state", "-1");
		} else {
			// 否则通过调用UserMapper中的updatePwds方法修改用户密码,并返回修改成功
			UserP p = userMapper.getUsersId(userP.getId());
			if (!oldPwd.equals(p.getPassword())) {
				map.put("state", "0");
			} else {
				int num = userMapper.updatePwds(userP);
				if (num > 0) {
					map.put("state", "1");
				}
			}
		}
		return JSON.toJSONString(map);
	}

	// 实现了longOut方法,用于用户注销
	@Override
	public void longOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 通过调用HttpServletRequest中的getSession方法,获取Session对象,并将其清空
		HttpSession session = request.getSession();
		session.removeAttribute("shop-users");
		session.invalidate();
		// 通过调用HttpServletRequest中的getCookies方法,获取所有Cookie,并将其删除
		Cookie[] cookies = request.getCookies();
		for (Cookie ck : cookies) {
			ck.setMaxAge(0);
			response.addCookie(ck);
		}
	}

	// 实现了AdminByIdPUser方法,用于查询指定id的用户信息
	@Override
	public String AdminByIdPUser(Integer id) throws Exception {
		// 通过调用UserMapper中的getUsersId方法,查询指定id的用户信息
		UserP userP = userMapper.getUsersId(id);
		// 将结果转换为JSON格式返回
		return JSON.toJSONString(userP);
	}

	// 实现了AdminByIdPUser方法,用于查询指定id的用户信息
	@Override
	public String AdmingetByuser() throws Exception {
		// 通过调用UserMapper中的AdminGetUser方法,查询所有用户信息
		List<UserP> lists = userMapper.AdminGetUser();
		// 将结果转换为JSON格式返回
		return JSON.toJSONString(lists);
	}

	// 实现了AdminDleuser方法,用于删除指定id的用户信息
	@Override
	public String AdminDleuser(Integer id, Integer shiro_id) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		// 如果当前用户不是超级管理员,则返回-1
		if (shiro_id != Shiros.SuperAdmin.getCode()) {
			map.put("state", "-1");
		} else {
			// 否则通过调用UserMapper中的AdminDelsUsers方法,删除指定id的用户信息
			int num = userMapper.AdminDelsUsers(id);
			if (num > 0) {
				map.put("state", "1");
			} else {
				map.put("state", "0");
			}
		}
		// 将结果转换为JSON格式返回
		return JSON.toJSONString(map);
	}

	// 实现了adminOnToMantyode方法,用于查询所有用户的订单信息
	@Override
	public String adminOnToMantyode() throws Exception {
		// 通过调用UserMapper中的AdminOneToManyOrdes方法,查询所有用户的订单信息
		List<UserPVo> list = userMapper.AdminOneToManyOrdes();
		// 将结果转换为JSON格式返回
		return JSON.toJSONString(list);
	}

	// 实现了addPlusers方法,用于添加用户信息
	@Override
	public boolean addPlusers(UserP userP) throws Exception {
		boolean bol = false;
		// 通过调用UserMapper中的addPlUsers方法,添加用户信息,并返回添加结果
		int num = userMapper.addPlUsers(userP);
		// 如果添加成功,则通过调用ReceAddressMapper中的addAddress方法,为该用户添加默认收货地址
		if (num > 0) {
			bol = true;
			receMapper.addAddress(userP.getId());
		} else {
			bol = false;
		}
		return bol;
	}
}
