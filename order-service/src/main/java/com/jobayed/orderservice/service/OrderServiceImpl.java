package com.jobayed.orderservice.service;

import com.jobayed.orderservice.controller.model.request.OrderRequest;
import com.jobayed.orderservice.controller.model.response.OrderResponse;
import com.jobayed.orderservice.entity.CustomerEntity;
import com.jobayed.orderservice.entity.ItemEntity;
import com.jobayed.orderservice.entity.OrderEntity;
import com.jobayed.orderservice.entity.OrderItemEntity;
import com.jobayed.orderservice.entity.dto.Order;
import com.jobayed.orderservice.enums.OrderStatus;
import com.jobayed.orderservice.exception.CustomerNotFoundException;
import com.jobayed.orderservice.repository.OrderItemRepository;
import com.jobayed.orderservice.repository.OrderRepository;
import com.jobayed.orderservice.utility.Constants;
import com.jobayed.orderservice.utility.Utils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final CustomerService customerService;
    private final ItemService itemService;
    private final OrderLogService orderLogService;

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    private final KafkaProducerService kafkaProducerService;


    @Override
    @Transactional
    public OrderResponse.Pending createOrder(OrderRequest.Order request) {
        CustomerEntity customer = customerService.findCustomerById(request.getCustomerId())
                .orElseThrow(CustomerNotFoundException::new);

        List<Long> orderIds = request.getItems().stream()
                .map(OrderRequest.OrderItem::getItemId)
                .collect(Collectors.toList());

        List<OrderItemEntity> orderItemEntities = this.toOrderItemEntityList(orderIds, request.getItems());
        orderItemEntities = orderItemRepository.saveAll(orderItemEntities);

        OrderEntity orderEntity = OrderEntity.builder()
                .customer(customer)
                .orderId(Utils.orderUniqueIdGenerator())
                .orderStatus(OrderStatus.PENDING)
                .orderItems(orderItemEntities)
                .build();
        orderRepository.save(orderEntity);

        orderLogService.addOrderLog(orderEntity, OrderStatus.PENDING,
                "Order created in "+OrderStatus.PENDING.getName()+" state");
        publishOrder(Order.builder().orderId(orderEntity.getId()).build());

        return OrderResponse.Pending.builder()
                .orderId(orderEntity.getOrderId())
                .message(Constants.OrderState.Message.PENDING)
                .build();
    }

    @Override
    public void publishOrder(Order order) {
        kafkaProducerService.sendToKafka(Constants.Topic.ORDER,Constants.Topic.Key.ORDER, order);
    }


    protected List<OrderItemEntity> toOrderItemEntityList(List<Long> orderIds,
        List<OrderRequest.OrderItem> orderItemRequest) {
        Map<Long, ItemEntity> itemMap = itemService.findItemsByIds(orderIds);
        // TODO: check if found item size and req item size is equal

        return orderItemRequest.stream()
                .filter(item -> itemMap.containsKey(item.getItemId()))
                .map(item -> OrderItemEntity.builder()
                        .item(itemMap.get(item.getItemId()))
                        .quantity(item.getQuantity())
                        .build()
                ).collect(Collectors.toList());

    }


}
