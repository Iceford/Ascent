/*
 * @Description: 
 * @FilePath: \src\main\java\com\ssm\service\inter\CartServiceInter.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-05 15:56:48
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.service.inter;

import com.ssm.po.GoodsCart;

public interface CartServiceInter {
	
	String addCart(GoodsCart cart) throws Exception; 
	
	String findUserIdC(Integer id) throws Exception;
	
	String delByid(Integer id)  throws Exception;
	
	String delByIdS(String str);

}
