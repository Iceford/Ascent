/*
 * @Description: Java工具类，提供了获取时间和生成随机数的方法
 * @FilePath: /src/main/java/com/ssm/util/Time.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-06 17:20:37
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

	// 获取当前时间:该方法使用Date类获取当前时间，并使用SimpleDateFormat类将时间格式化为"yyyy-MM-dd
	// HH:mm:ss"的字符串格式，最后返回该字符串
	public static String getTimes() {
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String udata = sf.format(d);
		return udata;
	}

	// 生成随机数
	public static int getTimeCode() {
		int romd = (int) ((Math.random() * (99999999 - 10000000)) + 10000000);
		return romd;
	}

}
