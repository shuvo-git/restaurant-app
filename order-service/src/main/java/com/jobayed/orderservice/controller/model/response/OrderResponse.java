package com.jobayed.orderservice.controller.model.response;

import com.jobayed.orderservice.enums.OrderStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

public interface OrderResponse {
    @Data
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    class Pending {
        String orderId;
        String message;
        final OrderStatus orderStatus = OrderStatus.PENDING;
    }

    @Data
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    class WaitForPayment {
        String orderId;
        String message;
        final OrderStatus orderStatus = OrderStatus.WAIT_FOR_PAYMENT;
    }
}
