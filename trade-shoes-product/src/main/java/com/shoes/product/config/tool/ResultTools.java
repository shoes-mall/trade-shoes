package com.shoes.product.config.tool;

import com.alibaba.fastjson.JSONObject;
import com.shoes.product.config.bean.Dto;
import com.shoes.product.enums.ResultMessageEnum;
import com.shoes.product.config.constant.ReturnInfo;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author: wx
 * @date: 2020/05/13 15:54
 * @description: 返回操作工具类
 */
@Component
public class ResultTools<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回信息资源常量
     */
    private static ResourceBundle returnInfoResourceBundle;

    @PostConstruct
    public void init() {
        returnInfoResourceBundle = new PlatformResourceBundleLocator(ReturnInfo.getReturnInfoFileName()).getResourceBundle(Locale.getDefault());
    }

    /**
     * 基本返回
     *
     * @param code    返回状态码
     * @param message 返回信息
     */
    public static ResultTools BASIC(Integer code, String message) {
        return BASIC(code, message, new JSONObject());
    }

    /**
     * 基本的返回
     *
     * @param code    返回状态码
     * @param message 返回信息
     * @param data    返回数据
     * @param <T>
     * @return
     */
    public static <T> ResultTools<T> BASIC(Integer code, String message, T data) {
        return Dto.<T>builder().rc(code).msg(message).data(data).build();
    }

    /**
     * 成功-不带参数
     */
    public static Dto SUCCESS() {
        return SUCCESS(new JSONObject());
    }

    /**
     * 成功-返回数据
     *
     * @param data 返回数据
     * @param <T>
     * @return
     */
    public static <T> Dto<T> SUCCESS(T data) {
        return Dto.<T>builder().rc(HttpStatus.OK.value()).msg(ResultMessageEnum.SUCCESS_MSG.getValue()).data(data).build();
    }

    /**
     * 错误-返回状态码/消息
     *
     * @param code    返回状态码
     * @param message 返回信息
     * @return
     */
    public static Dto ERROR(Integer code, String message) {
        return Dto.builder().rc(code).msg(message).data(new JSONObject()).build();
    }

    /**
     * 错误-返回状态码/信息/数据
     *
     * @param code    返回状态码
     * @param message 返回信息
     * @param data    返回数据
     * @return
     */
    public static Dto ERROR(Integer code, String message, Object data) {
        return Dto.builder().rc(code).msg(message).data(data).build();
    }

    /**
     * 错误-信息资源常量
     *
     * @return
     */
    public static Dto MODEL() {
        String[] message = separatorResources(getInfoPromptResources(ReturnInfo.ERROR));
        return Dto.builder().rc(Integer.parseInt(message[0])).msg(message[1]).data(new JSONObject()).build();
    }

    /**
     * 错误-信息资源常量
     *
     * @param constant 返回信息资源常量
     * @return
     */
    public static Dto MODEL(String constant) {
        String[] message = separatorResources(getInfoPromptResources(constant));
        String messageInfo = new String(message[1].getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return Dto.builder().rc(Integer.parseInt(message[0])).msg(messageInfo).data(new JSONObject()).build();
    }

    /**
     * 错误-信息资源常量
     *
     * @return
     */
    public static String getResultPromptInfo(String constant) {
        return separatorResources(getInfoPromptResources(constant))[1];
    }

    /**
     * 根据分隔符，切割数据
     *
     * @param constant 返回信息资源字符串
     * @return
     */
    protected static String[] separatorResources(String constant) {
        return constant.split(ReturnInfo.SEPARATOR);
    }

    /**
     * 根据 KEY 获取信息提示资源
     *
     * @param key
     * @return
     */
    protected static String getInfoPromptResources(String key) {
        return returnInfoResourceBundle.containsKey(key) ? returnInfoResourceBundle.getString(key) : returnInfoResourceBundle.getString(ReturnInfo.ERROR);
    }

}
