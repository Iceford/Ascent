/*
 * @Description: AdminShiroS类映射数据库中的admin_shiro表
 * @FilePath: \src\main\java\com\ssm\po\AdminShiroS.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-05 15:12:30
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved.
 */
package com.ssm.po;

public class AdminShiroS {
	private int id;
	private String shiro_name;
	private String shiro_cont;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShiro_name() {
		return shiro_name;
	}

	public void setShiro_name(String shiro_name) {
		this.shiro_name = shiro_name;
	}

	public String getShiro_cont() {
		return shiro_cont;
	}

	public void setShiro_cont(String shiro_cont) {
		this.shiro_cont = shiro_cont;
	}

}
