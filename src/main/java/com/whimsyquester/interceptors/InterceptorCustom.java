/*
 * @Description: 实现了 Spring 框架的 "HandlerInterceptor" 接口的拦截器类,用于在 Spring MVC 中拦截请求和响应,允许在控制器处理请求之前或之后执行额外的处理逻辑
 * @FilePath: \src\main\java\com\whimsyquester\interceptors\InterceptorCustom.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-07 11:31:07
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved.
 */
package com.whimsyquester.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InterceptorCustom implements HandlerInterceptor {

    // 用于在视图被渲染之后被调用,它允许进行一些资源清理操作
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // 方法为空的,没有执行任何额外的处理逻辑
    }

    // 用于在请求处理之后被调用,但在视图被渲染之前,它允许对模型和视图进行进一步的修改
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
                           ModelAndView modelAndView)
            throws Exception {
        // 方法为空,没有执行任何额外的处理逻辑
    }

    // 用于在请求处理之前被调用,它返回一个布尔值,表示是否允许请求继续处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        // 首先获取请求的 URL,并检查当前用户是否已经登录
        String url = request.getRequestURI();
        System.out.println(url);
        Object user = request.getSession().getAttribute("shop-users");
        // 如果用户没有登录,它会设置响应的内容类型为 "text/html;charset=utf-8",并输出一段 JavaScript
        // 代码,弹出一个提示框,告诉用户需要先登录才能访问
        if (user == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter()
                    .write("<script>alert('请先登录再访问！');location.href='/Ascent/user/login.html';</script>");
            return false; // 然后返回 false,表示请求不应该继续处理
        }
        return true;
    }

}
