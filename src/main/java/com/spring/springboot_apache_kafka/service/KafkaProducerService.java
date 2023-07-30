package com.spring.springboot_apache_kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {
    @KafkaListener(topics = "nasimkabir", groupId = "group-id")
    public void producer(String message) {
        System.out.println("Consumed message: " + message);
        log.info("Consumed message: " + message);
    }
}
