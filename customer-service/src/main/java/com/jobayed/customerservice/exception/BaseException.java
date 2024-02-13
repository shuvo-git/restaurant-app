package com.jobayed.customerservice.exception;

import lombok.Data;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/13/24 5:31 PM
 */
@Data
public class BaseException extends RuntimeException {
    String code;
    String message;

    BaseException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    BaseException(ErrorCode errorCode) {
        super(errorCode.message);
        this.code = errorCode.code;
        this.message = errorCode.message;
    }
}
