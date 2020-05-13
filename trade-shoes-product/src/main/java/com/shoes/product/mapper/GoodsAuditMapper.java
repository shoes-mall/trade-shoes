package com.shoes.product.mapper;

import com.shoes.product.model.GoodsAudit;
import org.springframework.stereotype.Repository;

/**
 * GoodsAuditMapper继承基类
 * @author weiwanxi
 */
@Repository
public interface GoodsAuditMapper extends MyBatisBaseDao<GoodsAudit, Integer> {
}