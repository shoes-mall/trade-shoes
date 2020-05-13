package com.shoes.order.dao;

import com.shoes.order.mapper.IProductOrderMapper;
import com.shoes.order.po.ProductOrderPO;
import com.shoes.order.vo.query.QueryProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import trade.shoes.commons.utils.LocalDateUtil;

import java.util.List;

/**
 * @description: 描述
 * @author: bingfeng
 * @create: 2020-05-13 19:14
 */
@Repository
public class ProductOrderDao {

    @Autowired
    IProductOrderMapper productOrderMapper;


    /**
     * 查询订单
     *
     * @param queryOrder
     * @return
     */
    public List<ProductOrderPO> queryProductOrderDao(QueryProductOrder queryOrder) {
        return productOrderMapper.queryProductOrder(queryOrder);
    }

    /**
     * 保存订单
     *
     * @param orderPO
     * @return
     */
    public ProductOrderPO saveProductOrder(ProductOrderPO orderPO) {

        String currentTime = LocalDateUtil.formatNow(LocalDateUtil.DateFormatStandard);

        orderPO.setCreateTime(currentTime);

        productOrderMapper.insertSelective(orderPO);
        return orderPO;
    }
}
