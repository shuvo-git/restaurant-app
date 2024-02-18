package com.jobayed.orderservice.service;

import com.jobayed.orderservice.entity.OrderEntity;
import com.jobayed.orderservice.entity.OrderLogEntity;
import com.jobayed.orderservice.enums.OrderStatus;
import com.jobayed.orderservice.repository.OrderLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderLogServiceImpl implements OrderLogService {
    private final OrderLogRepository orderLogRepository;

    @Override
    public void addOrderLog(OrderEntity order, OrderStatus orderStatus, String description) {
        OrderLogEntity log = OrderLogEntity.builder()
                .order(order)
                .orderStatus(orderStatus)
                .description(description)
                .build();
        orderLogRepository.save(log);
    }
}
