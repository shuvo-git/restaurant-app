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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

        List<Long> orderItemIds = request.getItems().stream()
                .map(OrderRequest.OrderItem::getItemId)
                .collect(Collectors.toList());

        OrderEntity orderEntity = OrderEntity.builder()
                .customer(customer)
                .orderId(Utils.orderUniqueIdGenerator())
                .orderStatus(OrderStatus.PENDING)
                .build();
        orderRepository.save(orderEntity);

        List<OrderItemEntity> orderItemEntities = this.toOrderItemEntityList(
                orderItemIds,
                orderEntity,
                request.getItems()
        );
        orderItemEntities = orderItemRepository.saveAll(orderItemEntities);
        orderEntity.setOrderItems(orderItemEntities);

        orderLogService.addOrderLog(orderEntity, OrderStatus.PENDING,
                "Order created in " + OrderStatus.PENDING.getName() + " state");
        publishOrder(Order.builder().orderId(orderEntity.getId()).build());

        return OrderResponse.Pending.builder()
                .orderId(orderEntity.getOrderId())
                .message(Constants.OrderState.Message.PENDING)
                .build();
    }

    @Override
    public void publishOrder(Order order) {
        kafkaProducerService.sendToKafka(Constants.Topic.ORDER, Constants.Topic.Key.ORDER, order);
    }

    @Override
    public Page<OrderResponse.OrderSummary> getOrdersByCustomerId(Long customerId, Integer page, Integer pageSize) {
        CustomerEntity customer = customerService.findCustomerById(customerId)
                .orElseThrow(CustomerNotFoundException::new);
        PageRequest pageable = PageRequest.of(page, pageSize);
        Page<OrderResponse.OrderSummary> orders = orderRepository.findOrdersByCustomer(customer.getId(), pageable);

        log.info("Orders {}", orders);

        return orders;
    }

    @Override
    public Page<OrderResponse.OrderSummary> getOrdersByCurrentDate(Integer page, Integer pageSize) {
        PageRequest pageable = PageRequest.of(page, pageSize);
        Page<OrderResponse.OrderSummary> orders = orderRepository.findOrdersByCurrentDate(pageable);
        log.info("Orders {}", orders);
        return orders;
    }

    protected List<OrderItemEntity> toOrderItemEntityList(List<Long> orderIds,
                                                          OrderEntity order,
                                                          List<OrderRequest.OrderItem> orderItemRequest) {
        Map<Long, ItemEntity> itemMap = itemService.findItemsByIds(orderIds);
        // TODO: check if found item size and req item size is equal

        return orderItemRequest.stream()
                .filter(item -> itemMap.containsKey(item.getItemId()))
                .map(item -> {
                    ItemEntity itemEntity = itemMap.get(item.getItemId());
                    return OrderItemEntity.builder()
                            .order(order)
                            .item(itemEntity)
                            .quantity(item.getQuantity())
                            .totalPrice(item.getQuantity() * itemEntity.getPrice())
                            .build();
                })
                .collect(Collectors.toList());
    }


}
