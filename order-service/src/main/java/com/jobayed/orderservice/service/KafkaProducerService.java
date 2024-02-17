package com.jobayed.orderservice.service;

public interface KafkaProducerService {
    void sendToKafka(String topic, String key, Object data);
}
