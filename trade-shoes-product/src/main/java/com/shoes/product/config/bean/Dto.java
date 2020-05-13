package com.shoes.product.config.bean;

import com.shoes.product.config.tool.ResultTools;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author: wx
 * @date: 2020/05/13 15:54
 * @description: 接口返回参数格式
 */
@Data
@Builder
@ToString
public class Dto<T> extends ResultTools {

    /**
     * http 状态码
     */
    private Integer rc;

    /**
     * 结果集返回
     */
    private T data;

    /**
     * 信息
     */
    private String msg;

    public Dto() {
    }

    public Dto(Integer rc, T data, String msg) {
        this.rc = rc;
        this.data = data;
        this.msg = msg;
    }
}
