/*
 * @Description: 定义了一个Java接口ReceAddressMapper,用于访问数据库中的收获地址的方法
 * @FilePath: \src\main\java\com\whimsyquester\dao\ReceAddressMapper.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-06 16:26:07
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved.
 */
package com.whimsyquester.dao;

import com.whimsyquester.po.ReceAddress;
import org.apache.ibatis.annotations.Param;

public interface ReceAddressMapper {

    // 根据收货地址ID查询收货地址,返回一个ReceAddress对象
    ReceAddress getAddress(Integer id) throws Exception;

    // 更新收货地址信息,传入一个ReceAddress对象,返回一个整数值表示更新结果
    int updateAddress(@Param("addres") ReceAddress address) throws Exception;

    // 在注册成功后将该地址的用户外键加入到数据库中,传入一个用户ID,返回一个整数值表示插入结果
    int addAddress(Integer userId) throws Exception;

}

