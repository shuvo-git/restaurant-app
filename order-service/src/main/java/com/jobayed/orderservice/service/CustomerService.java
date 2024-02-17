package com.jobayed.orderservice.service;

import com.jobayed.orderservice.entity.CustomerEntity;

import java.util.Optional;

public interface CustomerService {
    void addItem(CustomerEntity customer);

    Optional<CustomerEntity> findCustomerById(Long customerId);
}
