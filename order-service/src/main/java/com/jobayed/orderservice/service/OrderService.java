package com.jobayed.orderservice.service;

import com.jobayed.orderservice.controller.model.request.OrderRequest;
import com.jobayed.orderservice.controller.model.response.OrderResponse;

public interface OrderService {
    OrderResponse.WaitForPayment createOrder(OrderRequest.Order request);
}
