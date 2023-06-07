/*
 * @Description: 实现了 Spring 框架的 "HandlerInterceptor" 接口的拦截器类,用于在 Spring MVC 中拦截请求和响应,允许在控制器处理请求之前或之后执行额外的处理逻辑
 * @FilePath: \src\main\java\com\ssm\interceptors\InterceptorAdmin.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-07 11:20:49
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class InterceptorAdmin implements HandlerInterceptor {

	// 用于在请求处理之前被调用,它返回一个布尔值,表示是否允许请求继续处理
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true; // 只是简单地返回 true,表示允许请求继续处理
	}

	// 用于在请求处理之后被调用,但在视图被渲染之前。它允许对模型和视图进行进一步的修改
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 方法为空,没有执行任何额外的处理逻辑
	}

	// 用于在视图被渲染之后被调用,允许进行一些资源清理操作
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 方法为空,没有执行任何额外的处理逻辑
	}

}
