/*
 * @Description: Java枚举类型
 * @FilePath: \src\main\java\com\ssm\enums\Shiros.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-06 16:58:19
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.enums;

public enum Shiros {
	// 定义了两个常量值(SuperAdmin和GeneralAdmin),分别代表超级管理员和普通管理员
	SuperAdmin(1, "超级管理员"), GeneralAdmin(2, "普通管理员");

	private int code;
	private String name;

	private Shiros(int code, String name) {
		this.code = code;
		this.name = name();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
