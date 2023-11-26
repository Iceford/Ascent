/*
 * @Description: AdminShiroS类映射数据库中的admin_shiro表
 * @FilePath: \src\main\java\com\whimsyquester\po\AdminShiroS.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: WhimsyQuester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-11-26 03:26:09
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved.
 */
package com.whimsyquester.po;

public class AdminShiroS {
    private int id;
    private String shiro_name;
    private String shiro_cont;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShiro_name() {
        return shiro_name;
    }

    public void setShiro_name(String shiro_name) {
        this.shiro_name = shiro_name;
    }

    public String getShiro_cont() {
        return shiro_cont;
    }

    public void setShiro_cont(String shiro_cont) {
        this.shiro_cont = shiro_cont;
    }

}
