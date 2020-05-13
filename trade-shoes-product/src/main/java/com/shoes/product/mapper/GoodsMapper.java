package com.shoes.product.mapper;

import com.shoes.product.model.Goods;
import org.springframework.stereotype.Repository;

/**
 * GoodsMapper继承基类
 * @author weiwanxi
 */
@Repository
public interface GoodsMapper extends MyBatisBaseDao<Goods, Integer> {
}