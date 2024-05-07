package com.x250.rabbitfanout.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue1.name}")
    private String queue1;

    @Value("${rabbitmq.queue2.name}")
    private String queue2;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;


    @Bean
    public Queue queue1() {
        return new Queue(queue1, false);
    }

    @Bean
    public Queue queue2() {
        return new Queue(queue2, false);
    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(exchange);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder
                .bind(queue1())
                .to(exchange());
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder
                .bind(queue2())
                .to(exchange());
    }

    // ConnectionFactory
    // RabbitTemplate
    // RabbitAdmin

}