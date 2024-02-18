package com.jobayed.orderservice.controller.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface SalesResponse {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class TotalSales {
        LocalDate currentDate;
        double amount;
    }
}
