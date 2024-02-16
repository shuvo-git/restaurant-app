package com.jobayed.foodservice.utility;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/13/24 5:21 PM
 */

public enum ErrorCode {
    FOOD_NOT_FOUND("001", "Food not found"),
    INTERNAL_SERVER_ERROR("500", "Internal server error");

    @Getter
    private final String code;

    @Getter
    private final String message;

    private static final Map<String, ErrorCode> map = new HashMap<>();

    static {
        Arrays.stream(ErrorCode.values())
                .forEach(i -> map.put(i.code, i));
    }

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    ErrorCode get(String code) {
        return map.get(code);
    }
}
