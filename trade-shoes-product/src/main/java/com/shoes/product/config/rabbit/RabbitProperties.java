package com.shoes.product.config.rabbit;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wx
 * @date: 2020/05/13 10:58
 * @description:
 */
@Data
@ToString
@Configuration
public class RabbitProperties {

    /**
     * RabbitMQ 服务器地址
     */
    @Value("${spring.rabbitmq.host}")
    private String host;

    /**
     * RabbitMQ 服务器端口
     */
    @Value("${spring.rabbitmq.port}")
    private int port;

    /**
     * RabbitMQ 账号
     */
    @Value("${spring.rabbitmq.username}")
    private String username;

    /**
     * RabbitMQ 密码
     */
    @Value("${spring.rabbitmq.password}")
    private String password;
}
