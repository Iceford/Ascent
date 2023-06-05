/*
 * @Description: 
 * @FilePath: \src\main\java\com\ssm\po\UserPVo.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-05 15:37:09
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.po;

import java.util.List;

public class UserPVo extends UserP {

	private List<GoodsOrders> lists;

	public List<GoodsOrders> getLists() {
		return lists;
	}

	public void setLists(List<GoodsOrders> lists) {
		this.lists = lists;
	}
}
