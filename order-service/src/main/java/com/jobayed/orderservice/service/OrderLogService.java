package com.jobayed.orderservice.service;

import com.jobayed.orderservice.entity.OrderEntity;
import com.jobayed.orderservice.enums.OrderStatus;

public interface OrderLogService {
    void addOrderLog(OrderEntity order, OrderStatus orderStatus, String description);
}
