/*
 * @Description:
 * @FilePath: \src\main\java\com\whimsyquester\po\UserPVo.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-05 15:37:09
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved.
 */
package com.whimsyquester.po;

import java.util.List;

public class UserPVo extends UserP {

    private List<GoodsOrders> lists;

    public List<GoodsOrders> getLists() {
        return lists;
    }

    public void setLists(List<GoodsOrders> lists) {
        this.lists = lists;
    }
}

