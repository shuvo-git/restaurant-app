package com.jobayed.customerservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService {
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    public void sendToKafka(String topic, String key, Object data) {
        log.info("===Sending to Kafka Topic {} with key {}...", topic, key);

        try {
            CompletableFuture<SendResult<String, Object>> result = kafkaTemplate.send(topic, key, data);
            log.info("===Data={} published to topic={} with key={}", data, topic, key);
            // log.info("Added data " + data + " to topic-partition@offset="
            // + result.get().getRecordMetadata().toString()
            // + " with the key " + key);
        } catch (Throwable t) {
            log.error("===Error Sending to kafka: ", t);
        }
    }
}
