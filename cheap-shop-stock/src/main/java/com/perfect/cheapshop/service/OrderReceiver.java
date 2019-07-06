package com.perfect.cheapshop.service;


import com.perfect.cheapshop.domain.CsShopOrder;
import com.perfect.cheapshop.domain.CsShopOrderDetail;
import com.perfect.cheapshop.domain.CsShopProduct;
import com.perfect.cheapshop.service.ICsShopProductService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderReceiver {

    @Autowired
    private ICsShopProductService iCsShopProductService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value= "${spring.rabbitmq.listener.order.queue.name}",durable = "${spring.rabbitmq.listener.order.queue.durable}"),
            exchange = @Exchange(value = "${spring.rabbitmq.listener.order.exchange.name}",ignoreDeclarationExceptions="${spring.rabbitmq.listener.order.exchange.ignoreDeclarationExceptions}"),
            key = "${spring.rabbitmq.listener.order.key}"
    ))
    @RabbitHandler
    public void process(@Payload CsShopOrderDetail detail, Channel channel, @Headers Map<String, Object> headers) throws Exception{
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //手动ACK
        channel.basicAck(deliveryTag,false);
        Long productid = detail.getProductid();
        Integer ordernum = detail.getProductnum(); //购买数量
        CsShopProduct csShopProduct = iCsShopProductService.getById(productid);
        Long num = csShopProduct.getNum()-Long.parseLong(String.valueOf(ordernum));
        csShopProduct.setNum(num);
        iCsShopProductService.updateById(csShopProduct);
        System.out.println("====消费消息handleMessage");
        System.out.println("receive:"+detail);
    }
}
