/*
 * @Description: 定义了一个Java接口UserMapper,用于访问数据库中的用户信息的方法
 * @FilePath: \src\main\java\com\whimsyquester\dao\UserMapper.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-06 16:34:19
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved.
 */
package com.whimsyquester.dao;

import com.whimsyquester.po.UserP;
import com.whimsyquester.po.UserPVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    // 用于用户登录,传入用户名和密码,返回一个UserP对象表示登录用户的信息
    UserP loginUsers(@Param("users") String users, @Param("password") String password) throws Exception;

    // 用于更新用户信息,传入一个UserP对象,返回一个整数值表示更新结果
    int updateUsers(UserP userP) throws Exception;

    // 用于根据用户ID查询用户,返回一个UserP对象
    UserP getUsersId(Integer id) throws Exception;

    // 用于更新用户密码,传入一个UserP对象,返回一个整数值表示更新结果
    int updatePwds(UserP userP) throws Exception;

    // 用于管理员获取所有用户信息,返回一个UserP列表
    List<UserP> AdminGetUser() throws Exception;

    // 用于管理员删除用户信息,入一个用户ID,返回一个整数值表示删除结果
    int AdminDelsUsers(Integer id) throws Exception;

    // 用于管理员获取用户及其订单信息,返回一个UserPVo列表
    List<UserPVo> AdminOneToManyOrdes() throws Exception;

    // 用于添加用户信息,传入一个UserP对象,返回一个整数值表示插入结果
    int addPlUsers(UserP userP) throws Exception;

}

