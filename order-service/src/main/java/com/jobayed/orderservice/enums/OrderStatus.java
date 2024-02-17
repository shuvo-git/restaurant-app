package com.jobayed.orderservice.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 6:01 PM
 */

public enum OrderStatus {
    ACTIVE("PENDING", 21),
    INACTIVE("WAIT_FOR_PAYMENT", 22),
    PLACED("PLACED", 23),
    REJECTED("REJECTED", 24);

    private static final Map<String, OrderStatus> names = new HashMap<>();
    private static final Map<Integer, OrderStatus> values = new HashMap<>();

    static {
        Arrays.stream(OrderStatus.values())
                .forEach(status -> {
                    names.put(status.name, status);
                    values.put(status.value, status);
                });
    }

    @Getter
    private final String name;
    @Getter
    private final int value;

    OrderStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static OrderStatus getByName(String name) {
        return names.get(name);
    }

    public static OrderStatus getByValue(Integer value) {
        return values.get(value);
    }

}
