package com.shoes.order.mapper;

import com.shoes.order.po.ProductOrderPO;
import com.shoes.order.vo.query.QueryProductOrder;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @description: 描述
 * @author: bingfeng
 * @create: 2020-05-13 19:13
 */
@Component
public interface IProductOrderMapper extends Mapper<ProductOrderPO> {

    /**
     * 查询订单
     *
     * @param queryOrder
     * @return
     */
    List<ProductOrderPO> queryProductOrder(QueryProductOrder queryOrder);
}
