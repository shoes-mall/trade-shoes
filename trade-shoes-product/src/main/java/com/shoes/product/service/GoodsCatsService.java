package com.shoes.product.service;

import com.shoes.product.model.GoodsCats;

import java.util.List;

/**
 * @author weiwanxi
 */
public interface GoodsCatsService {

    /**
     * 获取所有商品分类
     *
     * @return
     */
    List<GoodsCats> getCats();

    /**
     * 根据类型ID查询商品分类信息
     *
     * @param catId
     * @return
     */
    GoodsCats getCatsByCatId(Integer catId);
}
