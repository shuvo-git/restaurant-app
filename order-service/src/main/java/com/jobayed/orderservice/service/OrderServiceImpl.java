package com.jobayed.orderservice.service;

import com.jobayed.orderservice.controller.model.request.OrderRequest;
import com.jobayed.orderservice.controller.model.response.OrderResponse;
import com.jobayed.orderservice.entity.CustomerEntity;
import com.jobayed.orderservice.exception.CustomerNotFoundException;
import com.jobayed.orderservice.utility.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final CustomerService customerService;
    private final ItemService itemService;

    @Override
    public OrderResponse.WaitForPayment createOrder(OrderRequest.Order request) {
        CustomerEntity customerById = customerService.findCustomerById(request.getCustomerId())
                .orElseThrow(CustomerNotFoundException::new);


        String orderId = Utils.orderUniqueIdGenerator();
        return null;
    }
}
