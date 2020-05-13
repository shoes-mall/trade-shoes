package com.shoes.product.service.impl;

import com.shoes.product.mapper.GoodsAuditMapper;
import com.shoes.product.service.GoodsAuditService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author weiwanxi
 */
@Service
public class GoodsAuditServiceImpl implements GoodsAuditService {

    @Resource
    GoodsAuditMapper mapper;
}
