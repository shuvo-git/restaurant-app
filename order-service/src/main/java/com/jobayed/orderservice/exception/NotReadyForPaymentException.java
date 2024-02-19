package com.jobayed.orderservice.exception;

import com.jobayed.orderservice.utility.ErrorCode;

public class NotReadyForPaymentException extends BaseException {
    public NotReadyForPaymentException() {
        super(ErrorCode.NOT_READY_FOR_PAYMENT);
    }

    public NotReadyForPaymentException(String code, String message) {
        super(code, message);
    }

    public NotReadyForPaymentException(ErrorCode errorCode) {
        super(errorCode);
    }
}
