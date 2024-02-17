package com.jobayed.orderservice.service;

import com.jobayed.orderservice.controller.model.request.OrderRequest;
import com.jobayed.orderservice.controller.model.response.OrderResponse;
import com.jobayed.orderservice.entity.dto.Order;

public interface OrderService {
    OrderResponse.Pending createOrder(OrderRequest.Order request);

    void publishOrder(Order order);
}
