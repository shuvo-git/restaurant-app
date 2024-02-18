package com.jobayed.orderservice.service;

import com.jobayed.orderservice.entity.dto.Order;

public interface SalesService {
    void prepareOrderBill(Order order);
}
