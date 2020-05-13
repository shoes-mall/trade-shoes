package com.shoes.product.config.rabbit.send;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import trade.shoes.commons.utils.StringUtils;

import java.util.UUID;

/**
 * @author: wx
 * @date: 2020/05/13 10:58
 * @description:
 */
@Component
public class Sender {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 如果rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
     * 需手动注入
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * MQ 发送数据基础方法
     *
     * @param exchange
     * @param routingKey
     * @param payload
     * @param uniqueMessageId
     * @param messageExpirationTime
     * @return 消息编号
     */
    public String baseSend(String exchange, String routingKey, Object payload, String uniqueMessageId, Long messageExpirationTime) {
        // 生成消息ID
        if (StringUtils.isBlank(uniqueMessageId)) {
            uniqueMessageId = UUID.randomUUID().toString();
        }

        String finalUniqueMessageId = uniqueMessageId;
        logger.info("SEND --- unique message id：{}", uniqueMessageId);

        // 消息属性
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                // 消息属性中写入消息编号
                message.getMessageProperties().setMessageId(finalUniqueMessageId);
                // 消息持久化时间
                if (!StringUtils.isEmpty(messageExpirationTime)) {
                    logger.info("设置消息持久化时间：{}", messageExpirationTime);
                    message.getMessageProperties().setExpiration(Long.toString(messageExpirationTime));
                }
                // 设置持久化模式
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return message;
            }
        };

        logger.info("SEND --- messagePostProcessor：{}", messagePostProcessor);

        // 消息
        Message message = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(payload);
            logger.info("发送消息：{}", payload.toString());
            // 转换数据格式
            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setContentEncoding(MessageProperties.CONTENT_TYPE_JSON);
            message = new Message(json.getBytes(), messageProperties);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // correlationData
        CorrelationData correlationData = new CorrelationData(uniqueMessageId);

        /**
         * convertAndSend(String exchange, String routingKey, Object message, MessagePostProcessor messagePostProcessor, CorrelationData correlationData)
         * exchange: 路由
         * routingKey: 绑定key
         * message: 发送消息
         * messagePostProcessor: 消息属性处理类
         * correlationData: 对象内部只有一个 id 属性，用来表示当前消息唯一性
         */
        rabbitTemplate.convertAndSend(exchange, routingKey, message, messagePostProcessor, correlationData);

        return finalUniqueMessageId;
    }
}
