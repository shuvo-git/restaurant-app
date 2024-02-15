package com.jobayed.foodservice.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 6:01 PM
 */

public enum Status {
    ACTIVE("ACTIVE", 1),
    INACTIVE("INACTIVE", 2),
    DELETED("DELETED", 3);

    @Getter
    private final String name;

    @Getter
    private final int value;

    private static final Map<String, Status> names = new HashMap<>();
    private static final Map<Integer, Status> values = new HashMap<>();

    static {
        Arrays.stream(Status.values())
                .forEach(status -> {
                    names.put(status.name, status);
                    values.put(status.value, status);
                });
    }

    Status(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static Status getByName(String name) {
        return names.get(name);
    }

    public static Status getByValue(Integer value) {
        return values.get(value);
    }

}
