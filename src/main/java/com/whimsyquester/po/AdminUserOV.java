/*
 * @Description:
 * @FilePath: \src\main\java\com\whimsyquester\po\AdminUserOV.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-05 15:26:51
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved.
 */
package com.whimsyquester.po;

public class AdminUserOV extends AdminUser {
    private String shiro_name;

    public String getShiro_name() {
        return shiro_name;
    }

    public void setShiro_name(String shiro_name) {
        this.shiro_name = shiro_name;
    }

}

