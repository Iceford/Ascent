/*
 * @Description: Java接口,定义了用户相关的服务接口
 * @FilePath: \src\main\java\com\ssm\service\inter\UserServiceInter.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-06 17:40:30
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssm.po.UserP;

public interface UserServiceInter {

	// 用户登录:该方法接收一个String类型的参数users和一个String类型的参数password,返回一个String类型的值表示登录结果
	String login(String users, String password) throws Exception;

	// 更新用户信息:该方法接收一个UserP类型的参数userP,没有返回值。
	void updateUsers(UserP userP) throws Exception;

	// 更新用户密码:该方法接收一个UserP类型的参数userP和一个String类型的参数oldPwd,返回一个String`类型的值表示更新用户密码的结果
	String updatePwds(UserP userP, String oldPwd) throws Exception;

	// 添加用户:该方法接收一个UserP类型的参数userP,返回一个boolean类型的值表示添加用户的结果
	boolean addPlusers(UserP userP) throws Exception;

	// 用户退出登录:该方法接收一个HttpServletRequest类型的参数request和一个HttpServletResponse类型的参数response,没有返回值
	void longOut(HttpServletRequest request, HttpServletResponse response) throws Exception;

	// 根据用户ID查询用户信息:该方法接收一个Integer类型的参数id,返回一个String类型的值表示查询到的用户信息的JSON格式字符串
	String AdminByIdPUser(Integer id) throws Exception;

	// 查询所有用户信息:该方法没有参数,返回一个String类型的值表示查询到的所有用户信息的JSON格式字符串
	String AdmingetByuser() throws Exception;

	// 删除用户:该方法接收一个Integer类型的参数id和一个Integer类型的参数shiro_id,返回一个String类型的值表示删除用户的结果
	String AdminDleuser(Integer id, Integer shiro_id) throws Exception;

	// 查询所有用户信息:该方法没有参数,返回一个String类型的值表示查询到的所有用户信息的JSON格式字符串
	String adminOnToMantyode() throws Exception;

}
