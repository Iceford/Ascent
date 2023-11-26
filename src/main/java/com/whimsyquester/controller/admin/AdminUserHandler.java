/*
 * @Description: 基于Java Spring MVC框架的控制器类,用于处理管理员用户相关的请求
 * @FilePath: \src\main\java\com\whimsyquester\controller\admin\AdminUserHandler.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: WhimsyQuester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-11-26 03:31:55
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved.
 */
package com.whimsyquester.controller.admin;

import com.whimsyquester.po.AdminUser;
import com.whimsyquester.service.inter.admin.AdminUserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller // 标识该类为控制器类
@RequestMapping("/admin") // 指示处理的请求路径为"/admin"
public class AdminUserHandler {
    // 使用@Autowired注解来自动装配一个AdminUserServiceInter类型的对象adminInter
    @Autowired
    private AdminUserServiceInter adminInter;

    // 使用@RequestMapping注解来指示处理的请求路径为/admin/adminLogin.do
    @RequestMapping(value = "/adminLogin.do")

    // 用于处理管理员用户的登录请求
    public void adminLogin(AdminUser adminUser, HttpServletResponse response) throws Exception {
        // 调用adminInter对象的adminLogin方法来验证管理员用户的登录信息
        boolean flag = adminInter.adminLogin(adminUser);
        // 如果验证成功,它会使用HttpServletResponse对象的sendRedirect方法将请求重定向到管理员用户的主页
        if (flag) {
            response.sendRedirect("/Ascent/admin/index.html");
        } else {
            // 否则会返回一个提示信息并跳转回登录页面
            response.setContentType("text/html;charset=utf-8"); // 设置响应的内容类型为text/html,字符编码为utf-8
            // 向响应输出一段JavaScript代码,弹出一个提示框并跳转到登录页面
            response.getWriter().println("<script>alert('登录失败');location.href='/Ascent/admin/login.html';</script>");
        }
    }

    // 指示处理的路径为/admin/LoginOut.do
    @RequestMapping("/LoginOut.do")
    // 用于处理管理员用户的退出登录请求
    public String LoginOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 调用adminInter对象的LoginOut方法来清除管理员用户的登录信息
        adminInter.LoginOut(request, response);
        // 返回一个重定向到页面的字符串
        return "redirect:/admin/login.html";
    }

    // 指示处理的请求路径为/admin/adminGets.do,并使用produces属性来指定响应的内容类型为text/html;charset=UTF-8
    @RequestMapping(value = "/adminGets.do", produces = "text/html;charset=UTF-8;")
    @ResponseBody // 使用@ResponseBody注解来指示返回的是一个字符串,而不是一个视图
    // 获取所有管理员用户的信息,并将其以字符串的形式返回给客户端
    public String adminGets() throws Exception {
        // 调用了adminInter对象的GetAdmins方法来获取所有管理员用户的信息,并将其作为字符串返回
        return adminInter.GetAdmins();
    }

}

