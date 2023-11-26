/*
 * @Description: GoodsType类映射数据库中的shop_type表
 * @FilePath: \src\main\java\com\whimsyquester\po\GoodsType.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-05 15:34:19
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved. 
 */
package com.whimsyquester.po;

public class GoodsType {
	private int id;
	private String type_name;
	private String date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

