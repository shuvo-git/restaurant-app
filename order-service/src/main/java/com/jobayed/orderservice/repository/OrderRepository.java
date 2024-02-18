package com.jobayed.orderservice.repository;

import com.jobayed.orderservice.controller.model.response.OrderResponse;
import com.jobayed.orderservice.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT o.orderId AS orderId, " +
            " c.id AS customerId, " +
            " c.name AS customerName, " +
            " o.orderStatus AS orderStatus, " +
            " o.createdAt AS orderedAt " +
            " FROM OrderEntity o " +
            " JOIN CustomerEntity c ON o.customer = c" +
            " WHERE c.id = :customerId " +
            " ORDER BY o.id DESC ")
    Page<OrderResponse.OrderSummary> findOrdersByCustomer(Long customerId, Pageable pageable);

    @Query("SELECT o.orderId AS orderId, " +
            " c.id AS customerId, " +
            " c.name AS customerName, " +
            " o.orderStatus AS orderStatus, " +
            " o.createdAt AS orderedAt " +
            " FROM OrderEntity o " +
            " JOIN CustomerEntity c ON o.customer = c" +
            " WHERE o.createdAt >= CURRENT_DATE " +
            " ORDER BY o.id DESC ")
    Page<OrderResponse.OrderSummary> findOrdersByCurrentDate(Pageable pageable);
}
