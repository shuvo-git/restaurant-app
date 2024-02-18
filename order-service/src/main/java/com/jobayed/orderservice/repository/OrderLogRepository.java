package com.jobayed.orderservice.repository;

import com.jobayed.orderservice.entity.OrderLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLogRepository extends JpaRepository<OrderLogEntity, Long> {
}
