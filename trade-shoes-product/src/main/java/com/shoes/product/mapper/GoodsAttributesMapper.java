package com.shoes.product.mapper;

import com.shoes.product.model.GoodsAttributes;
import org.springframework.stereotype.Repository;

/**
 * GoodsAttributesMapper继承基类
 * @author weiwanxi
 */
@Repository
public interface GoodsAttributesMapper extends MyBatisBaseDao<GoodsAttributes, Integer> {
}