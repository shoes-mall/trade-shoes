package com.shoes.order.service;

import com.shoes.order.po.ProductOrderPO;
import com.shoes.order.vo.query.QueryProductOrder;

import java.util.List;

/**
 * @description: 商品订单
 * @author: bingfeng
 * @create: 2020-05-13 19:14
 */
public interface IProductService {

    /**
     * 查询商品订单
     *
     * @param queryOrder
     * @return
     */
    List<ProductOrderPO> queryProductOrder(QueryProductOrder queryOrder);
}
