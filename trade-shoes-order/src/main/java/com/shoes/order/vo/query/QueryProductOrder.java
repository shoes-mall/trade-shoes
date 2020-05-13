package com.shoes.order.vo.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 查询订单
 * @author: bingfeng
 * @create: 2020-05-13 18:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryProductOrder {

    @ApiModelProperty(value = "订单号")
    private String orderNum;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "订单状态")
    private Integer status;
}
