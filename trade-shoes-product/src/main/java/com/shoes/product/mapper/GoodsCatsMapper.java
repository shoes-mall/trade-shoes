package com.shoes.product.mapper;

import com.shoes.product.model.GoodsCats;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GoodsCatsMapper继承基类
 * @author weiwanxi
 */
@Repository
public interface GoodsCatsMapper extends MyBatisBaseDao<GoodsCats, Integer> {

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