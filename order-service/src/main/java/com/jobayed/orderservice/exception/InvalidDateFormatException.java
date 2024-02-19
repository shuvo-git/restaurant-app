package com.jobayed.orderservice.exception;

import com.jobayed.orderservice.utility.ErrorCode;

public class InvalidDateFormatException extends BaseException {
    public InvalidDateFormatException() {
        super(ErrorCode.INVALID_DATE_FORMAT_EXCEPTION);
    }

    public InvalidDateFormatException(String code, String message) {
        super(code, message);
    }

    public InvalidDateFormatException(ErrorCode errorCode) {
        super(errorCode);
    }
}
