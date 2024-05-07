package com.x250.rabbitfanout.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQConsumer2 {

    @RabbitListener(queues = {"${rabbitmq.queue2.name}"})
    private void consume(String message){
        log.info("Received message by consumer2 -> {}", message);
    }

}