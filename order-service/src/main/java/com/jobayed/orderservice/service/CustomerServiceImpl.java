package com.jobayed.orderservice.service;

import com.jobayed.orderservice.entity.CustomerEntity;
import com.jobayed.orderservice.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    @KafkaListener(groupId = "customer_Group", topics = "customer")
    public void addItem(CustomerEntity customer) {
        log.info("Received Customer = {} from Customer service...", customer);
        if (customer != null) {
            customerRepository.save(customer);
        }
    }
}
