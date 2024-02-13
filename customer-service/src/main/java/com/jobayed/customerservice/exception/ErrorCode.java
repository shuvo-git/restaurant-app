package com.jobayed.customerservice.exception;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/13/24 5:21 PM
 */

public enum ErrorCode {
    CUSTOMER_NOT_FOUND("001", "Customer not found"),
    INTERNAL_SERVER_ERROR("500", "Internal server error");

    public final String code;
    public final String message;

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
