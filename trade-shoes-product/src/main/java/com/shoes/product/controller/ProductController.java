package com.shoes.product.controller;


import com.alibaba.fastjson.JSONObject;
import com.shoes.product.biz.ProductBiz;
import com.shoes.product.config.bean.Dto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author weiwanxi
 */
@RestController
@RequestMapping("/product")
@Api(tags = "ProductController", description = "商品分类管理")
public class ProductController {

    @Resource
    private ProductBiz productBiz;

    /**
     * 获取所有商品分类
     *
     * @return
     */
    @ApiOperation("获取所有商品分类")
    @GetMapping("get/goods/cats")
    public Dto getCats(){
        return productBiz.getCats();
    }

    /**
     * 根据类型ID查询商品分类信息
     *
     * @param json
     * @return
     */
    @ApiOperation("根据类型ID查询商品分类信息")
    @PostMapping("get/cats/message")
    public Dto getCatsMessage(@RequestBody JSONObject json){
        return productBiz.getCatsMessage(json);
    }
}
