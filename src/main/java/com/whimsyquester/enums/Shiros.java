/*
 * @Description: Java枚举类型
 * @FilePath: \src\main\java\com\whimsyquester\enums\Shiros.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: WhimsyQuester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-11-26 03:32:08
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved.
 */
package com.whimsyquester.enums;

public enum Shiros {
    // 定义了两个常量值(SuperAdmin和GeneralAdmin),分别代表超级管理员和普通管理员
    SuperAdmin(1, "超级管理员"), GeneralAdmin(2, "普通管理员");

    private int code;
    private String name;

    Shiros(int code, String name) {
        this.code = code;
        this.name = name();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
