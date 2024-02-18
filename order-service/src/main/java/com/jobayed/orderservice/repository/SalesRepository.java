package com.jobayed.orderservice.repository;

import com.jobayed.orderservice.entity.SalesEntity;
import com.jobayed.orderservice.enums.BillStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<SalesEntity, Long> {
    @Query("SELECT SUM(s.bill) FROM SalesEntity s " +
            " WHERE s.billStatus = :billStatus AND s.updatedAt >= CURRENT_DATE ")
    Double getTotalPriceByStatus(BillStatus billStatus);
}
