package com.jobayed.orderservice.controller.model.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/15/24 6:06 PM
 */

public interface OrderRequest {
    @Data
    class Order {
        Long customerId;
        List<OrderItem> items = new ArrayList<>();
    }

    @Data
    public class OrderItem {
        Long itemId;
        Integer quantity;
    }
}
