/*
 * @Description: AdminUser类映射数据库中的admin_users表
 * @FilePath: \src\main\java\com\whimsyquester\po\Goods.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-05 15:24:17
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved. 
 */
package com.whimsyquester.po;

public class AdminUser {

	private int id;
	private String admin_name;
	private String admin_user;
	private String admin_pwd;
	private int admin_shiro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_user() {
		return admin_user;
	}

	public void setAdmin_user(String admin_user) {
		this.admin_user = admin_user;
	}

	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}

	public int getAdmin_shiro() {
		return admin_shiro;
	}

	public void setAdmin_shiro(int admin_shiro) {
		this.admin_shiro = admin_shiro;
	}

}

