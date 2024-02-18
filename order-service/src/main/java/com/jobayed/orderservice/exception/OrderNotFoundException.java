package com.jobayed.orderservice.exception;

import com.jobayed.orderservice.utility.ErrorCode;

public class OrderNotFoundException extends BaseException {
    public OrderNotFoundException() {
        super(ErrorCode.CUSTOMER_NOT_FOUND);
    }

    public OrderNotFoundException(String code, String message) {
        super(code, message);
    }

    public OrderNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
