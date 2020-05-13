package com.shoes.product.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author: wx
 * @date: 2020/05/13 15:54
 * @description: 返回消息枚举类
 */
public enum ResultMessageEnum {

    /**
     * 成功
     */
    SUCCESS_MSG("SUCCESS"),

    /**
     * 失败
     */
    ERROR_MSG("ERROR"),
    ;

    private final String value;

    ResultMessageEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    public String getValue() {
        return value();
    }
}
