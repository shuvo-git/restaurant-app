package com.jobayed.orderservice.service;

import com.jobayed.orderservice.entity.OrderEntity;
import com.jobayed.orderservice.entity.OrderItemEntity;
import com.jobayed.orderservice.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItemEntity> findAllByOrderId(OrderEntity order) {
        return orderItemRepository.findAllByOrder(order);
    }
}
