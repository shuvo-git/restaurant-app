package com.jobayed.orderservice.repository;

import com.jobayed.orderservice.entity.OrderEntity;
import com.jobayed.orderservice.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
    List<OrderItemEntity> findAllByOrder(OrderEntity order);
}
