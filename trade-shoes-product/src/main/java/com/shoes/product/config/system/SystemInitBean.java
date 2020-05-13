package com.shoes.product.config.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: wx
 * @date: 2020/5/13 16:37
 * @description: 常量类 程序中不许出现魔法值
 */
@Component
public class SystemInitBean implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(SystemInitBean.class);


    /**
     * 系统全局标识符
     */
    public static final String IDENTIFIER = UUID.randomUUID().toString();

    /**
     * 0 type parameter
     */
    public static final Integer NEGATIVE_ONE_INTEGER_NUMBER = -1;
    public static final Integer ZERO_INTEGER_NUMBER = 0;

    /**
     * 初始化 数据入口 Bean 配置
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() {
        // 初始化 数据入口 Bean 配置
        logger.info("系统配置: {}", this.toString());
        logger.info("加载初始化配置完成...系统标识符: {} ---------------", IDENTIFIER);
    }
}
