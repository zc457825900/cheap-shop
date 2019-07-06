package com.perfect.cheapshop.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${spring.rabbitmq.listener.order.queue.name}")
    private String order_queue;

    @Value("${spring.rabbitmq.listener.order.exchange.name}")
    private String order_exchange;

    @Value("${spring.rabbitmq.listener.order.key}")
    private String order_bindingkey;

    @Bean
    public Queue queue(){
        return new Queue(order_queue);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(order_exchange);
    }

    @Bean
    public Binding bindingExchangeMessage(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(order_bindingkey);
    }
}
