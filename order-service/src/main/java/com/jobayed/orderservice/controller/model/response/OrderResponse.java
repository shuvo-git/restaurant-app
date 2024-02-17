package com.jobayed.orderservice.controller.model.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

public interface OrderResponse {
    @Data
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    class WaitForPayment {
        String orderId;
        String paymentDue;
        String message;
    }
}
