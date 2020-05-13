package com.shoes.product.service.impl;

import com.shoes.product.mapper.GoodsMapper;
import com.shoes.product.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author weiwanxi
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsMapper mapper;
}
