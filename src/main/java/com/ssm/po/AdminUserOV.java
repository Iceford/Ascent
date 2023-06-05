/*
 * @Description: 
 * @FilePath: \src\main\java\com\ssm\po\AdminUserOV.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-05 15:26:51
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.po;

public class AdminUserOV extends AdminUser {
	private String shiro_name;

	public String getShiro_name() {
		return shiro_name;
	}

	public void setShiro_name(String shiro_name) {
		this.shiro_name = shiro_name;
	}

}
