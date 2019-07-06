package com.perfect.cheapshop.service;

import com.perfect.cheapshop.domain.CsShopOrderDetail;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.listener.order.exchange.name}")
    private String order_exchange;

    @Value("${spring.rabbitmq.listener.order.key}")
    private String order_bindingkey;

    final ConfirmCallback confirmCallback = (CorrelationData correlationData, boolean ack, String cause)->{
        System.out.println("correlationData:"+correlationData);
        System.out.println("ack:"+ack);
        if(!ack){
            System.out.println("处理...");
        }
    };

    final ReturnCallback returnCallback = (org.springframework.amqp.core.Message message, int replyCode, String replyText, String exchange, String routingKey)->{
            System.err.println("return exchange: " + exchange + ", routingKey: "
                    + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
    };


    /**
     * 发送消息方法调用
     * @param detail
     * @throws Exception
     */
    public void send(CsShopOrderDetail detail) throws Exception {
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        //id  uuid 全局唯一
        String id = UUID.randomUUID().toString().replaceAll("-","");
        CorrelationData correlationData = new CorrelationData(id);
        System.out.println("sender:"+detail);
        rabbitTemplate.convertAndSend(order_exchange,order_bindingkey,detail,correlationData);
    }
}
