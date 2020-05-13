package com.shoes.order.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @description: 商品订单实体类
 * @author: bingfeng
 * @create: 2020-05-13 18:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product_order")
public class ProductOrderPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @KeySql(useGeneratedKeys = true, sql = "SELECT LAST_INSERT_ID()", order = ORDER.AFTER)
    @ApiModelProperty("订单号")
    private String orderNum;

    @ApiModelProperty("1 未支付 2 已支付")
    private String status;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("商品id")
    private String productId;
}
