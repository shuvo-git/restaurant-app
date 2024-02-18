package com.jobayed.orderservice.service;

import com.jobayed.orderservice.entity.OrderEntity;
import com.jobayed.orderservice.entity.OrderItemEntity;

import java.util.List;

public interface OrderItemService {
    List<OrderItemEntity> findAllByOrderId(OrderEntity order);

}
