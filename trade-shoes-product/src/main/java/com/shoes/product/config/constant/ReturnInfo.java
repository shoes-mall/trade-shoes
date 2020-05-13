package com.shoes.product.config.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * @author: wx
 * @date: 2020/05/13 15:54
 * @description: 错误返回信息常量类
 */
@Component
public class ReturnInfo {

    private static final Logger logger = LoggerFactory.getLogger(ReturnInfo.class);

    /**
     * 返回信息资源常量文件名称
     */
    public static final String VALIDATION_FILE_NAME = "ValidationMessages";

    /**
     * 语言资源文件夹
     */
    public static final String LANGUAGE_FILE = "lang";

    /**
     * 错误消息模板
     */
    public static final String ERROR = "error";

    /**
     * 分隔符
     */
    public static final String SEPARATOR = "@";

    // ===============================公共提示模版===============================

    /**
     * 网络繁忙
     */
    public static final String NETWORK_BUSY = "network_busy";

    // ===============================私有提示模版===============================

    /**
     * 参数不合法
     */
    public static final String PARAMETER_INVALID = "parameter_invalid";

    // ===============================分隔符===============================

    /**
     * 返回资源文件名称
     *
     * @return
     */
    public static String getReturnInfoFileName() {
        String name = LANGUAGE_FILE + File.separator + File.separator + VALIDATION_FILE_NAME;
        logger.info("加载返回资源文件", name);
        return name;
    }
}
