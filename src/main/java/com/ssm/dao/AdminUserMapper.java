/*
 * @Description: 定义了一个Java接口AdminUserMapper,用于访问数据库中的管理员权限信息
 * @FilePath: \src\main\java\com\ssm\dao\AdminUserMapper.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-05 22:46:51
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved.
 */
package com.ssm.dao;

import com.ssm.po.AdminUser;
import com.ssm.po.AdminUserOV;

import java.util.List;

public interface AdminUserMapper {

    // 后台登录,接收一个AdminUser类型的参数adminUser,表示管理员用户信息,返回一个AdminUser类型的对象
    AdminUser adminLogin(AdminUser adminUser) throws Exception;

    // 查询管理员,返回一个AdminUserOV类型的List集合
    List<AdminUserOV> GetAdmin() throws Exception;

}
