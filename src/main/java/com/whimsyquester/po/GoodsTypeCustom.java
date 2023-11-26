/*
 * @Description: 
 * @FilePath: \src\main\java\com\whimsyquester\po\GoodsTypeCustom.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: WhimsyQuester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-11-26 03:28:12
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved. 
 */
package com.whimsyquester.po;

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

