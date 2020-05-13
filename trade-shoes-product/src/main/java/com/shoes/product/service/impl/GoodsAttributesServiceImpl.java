package com.shoes.product.service.impl;

import com.shoes.product.mapper.GoodsAttributesMapper;
import com.shoes.product.service.GoodsAttributesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author weiwanxi
 */
@Service
public class GoodsAttributesServiceImpl implements GoodsAttributesService {

    @Resource
    GoodsAttributesMapper mapper;
}
