package com.shoes.product.service.impl;

import com.shoes.product.mapper.GoodsCatsMapper;
import com.shoes.product.model.GoodsCats;
import com.shoes.product.service.GoodsCatsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author weiwanxi
 */
@Service
public class GoodsCatsServiceImpl implements GoodsCatsService {

    @Resource
    GoodsCatsMapper mapper;

    @Override
    public List<GoodsCats> getCats() {
        return mapper.getCats();
    }

    @Override
    public GoodsCats getCatsByCatId(Integer catId) {
        return mapper.getCatsByCatId(catId);
    }
}
