package com.jobayed.orderservice.repository;

import com.jobayed.orderservice.controller.model.response.SalesResponse;
import com.jobayed.orderservice.entity.OrderEntity;
import com.jobayed.orderservice.entity.SalesEntity;
import com.jobayed.orderservice.enums.BillStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesRepository extends JpaRepository<SalesEntity, Long> {
    Optional<SalesEntity> findByOrderAndBillStatus(OrderEntity order, BillStatus billStatus);

    @Query("SELECT SUM(s.bill) FROM SalesEntity s " +
            " WHERE s.billStatus = :billStatus AND s.updatedAt >= CURRENT_DATE ")
    Double getTotalPriceByStatus(BillStatus billStatus);

    @Query(value = "SELECT " +
            " DATE_TRUNC('day', updated_at) AS date, " +
            " SUM(bill) AS amount " +
            " FROM sales " +
            " WHERE updated_at >= TO_DATE(:startDate , 'DD/MM/YYYY') " +
            "   AND updated_at < TO_DATE(:endDate , 'DD/MM/YYYY')  " +
            "   AND  status = :billStatus " +
            " GROUP BY date " +
            " ORDER BY amount DESC", nativeQuery = true)
    List<SalesResponse.MaxSaleDay> getMaxSaleDay(String startDate, String endDate, int billStatus);
}
