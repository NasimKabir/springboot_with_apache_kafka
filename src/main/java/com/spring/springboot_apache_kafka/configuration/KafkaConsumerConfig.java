package com.spring.springboot_apache_kafka.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    @Bean
    public ConsumerFactory<String, String> byteConsumerFactory() {
        Map<String,Object>params= new HashMap<>();
        params.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        params.put(ConsumerConfig.GROUP_ID_CONFIG,"group-id");
        params.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        params.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        params.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        return new DefaultKafkaConsumerFactory<>(params);
    }
}
