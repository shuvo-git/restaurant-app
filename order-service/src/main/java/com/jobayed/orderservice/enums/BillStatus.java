package com.jobayed.orderservice.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum BillStatus {
    UNPAID("UNPAID", 31),
    PAID("PAID", 32),
    CANCELED("CANCELED", 33);

    private static final Map<String, BillStatus> names = new HashMap<>();
    private static final Map<Integer, BillStatus> values = new HashMap<>();

    static {
        Arrays.stream(BillStatus.values())
                .forEach(billStatus -> {
                    names.put(billStatus.name, billStatus);
                    values.put(billStatus.value, billStatus);
                });
    }

    @Getter
    private final String name;
    @Getter
    private final int value;

    BillStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static BillStatus getByName(String name) {
        return names.get(name);
    }

    public static BillStatus getByValue(Integer value) {
        return values.get(value);
    }
}
