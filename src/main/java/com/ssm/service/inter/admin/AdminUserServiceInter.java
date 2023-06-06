/*
 * @Description: Java接口，定义了管理后台用户相关的服务接口
 * @FilePath: \src\main\java\com\ssm\service\inter\admin\AdminUserServiceInter.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-06 17:03:16
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.service.inter.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssm.po.AdminUser;

public interface AdminUserServiceInter {
	
	// 管理后台用户的登录,接收一个AdminUser对象作为参数,返回一个boolean类型的值表示登录是否成功
	boolean adminLogin(AdminUser adminUser) throws Exception;
	
	// 管理后台用户的退出登录。该方法接收一个HttpServletRequest对象和一个HttpServletResponse对象作为参数，没有返回值
	void LoginOut(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 获取所有管理后台用户的信息。该方法没有参数，返回一个String类型的值表示所有用户信息的JSON格式字符串
	String GetAdmins() throws Exception;
}
