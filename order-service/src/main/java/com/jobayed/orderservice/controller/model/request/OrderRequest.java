package com.jobayed.orderservice.controller.model.request;

import lombok.Data;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/15/24 6:06 PM
 */

public interface OrderRequest {
    @Data
    class Order {
        Long customerId;
    }
}
