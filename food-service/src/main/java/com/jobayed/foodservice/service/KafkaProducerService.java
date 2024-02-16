package com.jobayed.foodservice.service;

public interface KafkaProducerService {
    void sendToKafka(String topic, String key, Object data);
}
