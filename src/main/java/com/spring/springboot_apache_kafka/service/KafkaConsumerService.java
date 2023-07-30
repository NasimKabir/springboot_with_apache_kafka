package com.spring.springboot_apache_kafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {
    @Value("${kafka.topic}")
    private String topic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "nasimkabir", groupId = "group-id")
    public void consume(String message) {
        log.info("Consumed message: " + message);
        kafkaTemplate.send(topic, message);
    }
}
