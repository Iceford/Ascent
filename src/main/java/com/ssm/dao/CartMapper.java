/*
 * @Description: 定义了一个Java接口CartMapper,用于访问数据库中的购物车信息
 * @FilePath: \src\main\java\com\ssm\dao\CartMapper.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-05 23:00:23
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved.
 */
package com.ssm.dao;

import com.ssm.po.GoodsCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    // 添加购物车,接收一个GoodsCart类型的参数cart,表示购物车信息,返回一个int类型的值
    int addCart(GoodsCart cart) throws Exception;

    // 以名字查询购物车,接收两个参数userId和goods_name,分别表示用户ID和商品名称,返回一个GoodsCart类型的对象
    GoodsCart findGetName(@Param("userId") Integer userId, @Param("goods_name") String goods_name) throws Exception;

    // 以ID更新购物车信息,接收一个GoodsCart类型的参数cart,表示购物车信息,返回一个int类型的值
    int updateByid(GoodsCart cart) throws Exception;

    // 以ID展示用户购物车,接收一个Integer类型的参数id,表示用户ID,返回一个GoodsCart类型的List集合
    List<GoodsCart> findByUserId(Integer id) throws Exception;

    // 以ID删除购物车信息,接收一个Integer类型的参数id,表示购物车ID,返回一个int类型的值
    int delByid(Integer id) throws Exception;

    // 以ID批量删除购物车信息,接收一个String类型的数组ids,表示购物车ID数组,返回一个int类型的值
    int delByIdsArry(String[] ids);

}
