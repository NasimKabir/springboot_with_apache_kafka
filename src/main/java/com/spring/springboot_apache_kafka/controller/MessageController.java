package com.spring.springboot_apache_kafka.controller;

import com.spring.springboot_apache_kafka.service.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private final KafkaProducerService kafkaProducer;

    public MessageController(KafkaProducerService kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }


    // http:localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.producer(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
