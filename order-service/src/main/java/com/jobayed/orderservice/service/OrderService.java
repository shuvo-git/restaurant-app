package com.jobayed.orderservice.service;

import com.jobayed.orderservice.controller.model.request.OrderRequest;
import com.jobayed.orderservice.controller.model.response.OrderResponse;
import com.jobayed.orderservice.entity.OrderEntity;
import com.jobayed.orderservice.entity.dto.Order;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface OrderService {
    OrderResponse.Pending createOrder(OrderRequest.Order request);

    void publishOrder(Order order);

    Page<OrderResponse.OrderSummary> getOrdersByCustomerId(Long customerId, Integer page, Integer pageSize);

    Page<OrderResponse.OrderSummary> getOrdersByCurrentDate(Integer page, Integer pageSize);

    Optional<OrderEntity> findById(Long id);

    OrderResponse.Payment payOrderBill(String orderId);
}
