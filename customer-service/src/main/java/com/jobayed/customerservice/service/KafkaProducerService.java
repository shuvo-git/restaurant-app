package com.jobayed.customerservice.service;

public interface KafkaProducerService {
    void sendToKafka(String topic, String key, Object data);
}
