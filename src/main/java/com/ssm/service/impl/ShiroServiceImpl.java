/*
 * @Description: 实现接口ShiroServiceInter的Java类,用于对管理员权限进行查询和更新的操作
 * @FilePath: \src\main\java\com\ssm\service\impl\ShiroServiceImpl.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-06 22:42:19
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.ssm.dao.AdminShiro;
import com.ssm.po.AdminShiroS;
import com.ssm.service.inter.ShiroServiceInter;

public class ShiroServiceImpl implements ShiroServiceInter {
	// 使用@Autowired注解，自动装配AdminShiro类的实例
	@Autowired
	private AdminShiro adminShiro;

	// 实现了GetsShiros方法,用于查询所有管理员权限信息
	@Override
	public String GetsShiros() throws Exception {
		// 通过调用AdminShiro中的ShiroGets方法，查询所有管理员权限信息
		List<AdminShiroS> lists = adminShiro.ShiroGets();
		// 将结果转换为JSON格式返回
		return JSON.toJSONString(lists);
	}

	// 实现了AdminUpdateShi方法,用于更新管理员权限信息
	@Override
	public boolean AdminUpdateShi(Integer shiroId, Integer userId) throws Exception {
		boolean blo = false;
		// 如果传入的权限id或用户id为空，则返回false
		if (shiroId == null || userId == null) {
			blo = false;
		} else {
			// 通过调用AdminShiro中的AdminUpdateShiro方法，更新管理员权限信息
			int num = adminShiro.AdminUpdateShiro(shiroId, userId);
			if (num > 0) {
				blo = true;
			} else {
				blo = false;
			}
		}
		// 返回更新结果
		return blo;
	}
}
