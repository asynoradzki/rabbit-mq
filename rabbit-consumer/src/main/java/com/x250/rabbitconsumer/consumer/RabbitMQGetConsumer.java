package com.x250.rabbitconsumer.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RabbitMQGetConsumer {

    @Value("${rabbitmq.queue.name}")
    private String queue;

    private final RabbitTemplate rabbitTemplate;
    @GetMapping("/get_rabbit")
    ResponseEntity<String> getRabbit() {
        Object message = rabbitTemplate.receiveAndConvert(queue);
        return ResponseEntity.ok(message.toString());
    }
}