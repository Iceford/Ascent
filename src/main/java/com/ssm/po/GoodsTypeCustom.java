/*
 * @Description: 
 * @FilePath: \src\main\java\com\ssm\po\GoodsTypeCustom.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-05 15:34:56
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.po;

import java.util.List;

public class GoodsTypeCustom extends GoodsType {
	private List<Goods> lists;

	public List<Goods> getLists() {
		return lists;
	}

	public void setLists(List<Goods> lists) {
		this.lists = lists;
	}
}
