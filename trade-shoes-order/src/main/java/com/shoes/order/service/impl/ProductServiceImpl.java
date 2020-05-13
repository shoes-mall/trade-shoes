package com.shoes.order.service.impl;

import com.shoes.order.dao.ProductOrderDao;
import com.shoes.order.po.ProductOrderPO;
import com.shoes.order.service.IProductService;
import com.shoes.order.vo.query.QueryProductOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 描述
 * @author: bingfeng
 * @create: 2020-05-13 19:15
 */
@Slf4j
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductOrderDao productOrderDao;

    @Override
    public List<ProductOrderPO> queryProductOrder(QueryProductOrder queryOrder) {
        return productOrderDao.queryProductOrderDao(queryOrder);
    }
}
