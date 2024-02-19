package com.jobayed.orderservice.controller.model.response;

import com.jobayed.orderservice.enums.OrderStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

public interface OrderResponse {
    interface OrderSummary {
        String getOrderId();

        String getCustomerId();

        String getCustomerName();

        OrderStatus getOrderStatus();

        LocalDateTime getOrderedAt();
    }

    @Data
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    class Pending {
        final OrderStatus orderStatus = OrderStatus.PENDING;
        String orderId;
        String message;
    }

    @Data
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    class WaitForPayment {
        final OrderStatus orderStatus = OrderStatus.WAIT_FOR_PAYMENT;
        String orderId;
        String message;
    }

    @Data
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    class Payment {
        final OrderStatus orderStatus = OrderStatus.PLACED;
        String orderId;
        String message;
    }
}
