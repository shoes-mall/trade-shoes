package com.shoes.order.controller;

import com.shoes.order.commons.ResultMsg;
import com.shoes.order.po.ProductOrderPO;
import com.shoes.order.service.IProductService;
import com.shoes.order.vo.query.QueryProductOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 商品订单管理
 * @author: bingfeng
 * @create: 2020-05-13 18:22
 */
@Slf4j
@RestController
@Api(tags = "OrderController", description = "商品订单管理")
public class ProductOrderController {

    @Autowired
    IProductService productService;

    @ApiOperation("查询订单")
    @PostMapping(value = "/query/product/order")
    public ResultMsg queryProductOrder(@RequestBody QueryProductOrder queryOrder) {

        List<ProductOrderPO> productOrderPOList = productService.queryProductOrder(queryOrder);

        return ResultMsg.success(productOrderPOList);
    }
}
