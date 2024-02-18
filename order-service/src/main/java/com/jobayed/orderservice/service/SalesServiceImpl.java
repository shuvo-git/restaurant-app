package com.jobayed.orderservice.service;

import com.jobayed.orderservice.entity.OrderEntity;
import com.jobayed.orderservice.entity.OrderItemEntity;
import com.jobayed.orderservice.entity.SalesEntity;
import com.jobayed.orderservice.entity.dto.Order;
import com.jobayed.orderservice.enums.BillStatus;
import com.jobayed.orderservice.exception.OrderNotFoundException;
import com.jobayed.orderservice.repository.SalesRepository;
import com.jobayed.orderservice.utility.Constants;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SalesServiceImpl implements SalesService {
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final SalesRepository salesRepository;

    @Transactional
    @KafkaListener(groupId = Constants.Topic.Group.ORDER, topics = Constants.Topic.ORDER)
    @Override
    public void prepareOrderBill(Order order) {
        log.info("Received Order = {} from Order service...", order);
        if (order != null) {
            Long id = order.getOrderId();
            OrderEntity orderEntity = orderService.findById(id)
                    .orElseThrow(OrderNotFoundException::new);

            List<OrderItemEntity> orderItems = orderItemService.findAllByOrderId(orderEntity);

            double totalBill = orderItems.stream()
                    .map(OrderItemEntity::getTotalPrice)
                    .reduce(0.0, Double::sum);

            salesRepository.save(SalesEntity.builder()
                    .order(orderEntity)
                    .bill(totalBill)
                    .billStatus(BillStatus.UNPAID)
                    .build());
        }
    }
}
