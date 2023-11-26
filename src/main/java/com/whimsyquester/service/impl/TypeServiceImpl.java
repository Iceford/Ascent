/*
 * @Description: 实现接口TypeServiceInter的Java类,用于对商品类型进行查询和更新的操作
 * @FilePath: \src\main\java\com\whimsyquester\service\impl\TypeServiceImpl.java
 * @Author: whimsyquester rongquanhuang01@gmail.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: whimsyquester rongquanhuang01@gmail.com
 * @LastEditTime: 2023-06-06 22:54:49
 * Copyright (c) 2023 by whimsyquester , All Rights Reserved.
 */
package com.whimsyquester.service.impl;

import com.alibaba.fastjson.JSON;
import com.whimsyquester.dao.GoodsMapper;
import com.whimsyquester.dao.GoodsTypeMapper;
import com.whimsyquester.enums.Shiros;
import com.whimsyquester.po.GoodsList;
import com.whimsyquester.po.GoodsType;
import com.whimsyquester.po.GoodsTypeCustom;
import com.whimsyquester.service.inter.TypeServiceInter;
import com.whimsyquester.util.Time;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeServiceImpl implements TypeServiceInter {
    // 使用@Autowired注解,自动装配GoodsTypeMapper和GoodsMapper类的实例
    @Autowired
    private GoodsTypeMapper goodMapper;

    @Autowired
    private GoodsMapper goodsMa;

    // 实现了goodsIndex方法,用于查询所有商品类型信息
    @Override
    public String goodsIndex() throws Exception {
        // 通过调用GoodsTypeMapper中的goodsIndex方法,查询所有商品类型信息
        List<GoodsTypeCustom> lists = goodMapper.goodsIndex();
        // 将结果转换为JSON格式返回
        return JSON.toJSONString(lists);
    }

    // 实现了admin_delType方法,用于删除指定id的商品类型。
    @Override
    public String admin_delType(Integer id, Integer shiro_id) throws Exception {
        List<GoodsList> lists = goodsMa.getTypeIdList(id);
        Map<String, String> map = new HashMap<String, String>();
        // 如果当前用户不是超级管理员,则返回-1
        if (shiro_id != Shiros.SuperAdmin.getCode()) {
            map.put("state", "-1");
        } else if (lists != null) {
            // 如果该类型下有商品,则返回0
            map.put("state", "0");
        } else {
            // 否则通过调用GoodsTypeMapper中的admin_del_type方法,删除指定id的商品类型
            int num = goodMapper.admin_del_type(id);
            if (num > 0) {
                map.put("state", "1");
            }
        }
        // 将结果转换为JSON格式返回
        return JSON.toJSONString(map);
    }

    // 实现了AdminAddType方法,用于添加商品类型信息
    @Override
    public boolean AdminAddType(GoodsType type) throws Exception {
        boolean bol = false;
        // 将传入的商品类型对象设置日期
        type.setDate(Time.getTimes());
        // 通过调用GoodsTypeMapper中的AdminaddType方法,添加商品类型信息并返回添加
        int num = goodMapper.AdminaddType(type);
        bol = num > 0;
        return bol;
    }

    // 实现了AdminGetIdType方法,用于查询指定id的商品类型信息
    @Override
    public String AdminGetIdType(Integer id) throws Exception {
        // 通过调用GoodsTypeMapper中的AdminGetIdType方法,查询指定id的商品类型信息
        GoodsType type = goodMapper.AdminGetIdType(id);
        // 将结果转换为JSON格式返回
        return JSON.toJSONString(type);
    }

    // 实现了AdminUpdateTypes方法,用于更新商品类型信息
    @Override
    public boolean AdminUpdateTypes(GoodsType type) throws Exception {
        boolean bol = false;
        // 通过调用GoodsTypeMapper中的AdminUpdateType方法,更新商品类型信息,并返回更新结果
        int num = goodMapper.AdminUpdateType(type);
        bol = num > 0;
        return bol;
    }
}

