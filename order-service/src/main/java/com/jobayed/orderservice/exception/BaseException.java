package com.jobayed.orderservice.exception;


import com.jobayed.orderservice.utility.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/13/24 5:31 PM
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BaseException extends RuntimeException {
    private Error error;

    BaseException(String code, String message) {
        super(message);
        this.error = Error.builder()
                .errorCode(code)
                .errorMessage(message)
                .build();
    }

    BaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.error = Error.builder()
                .errorCode(errorCode.getCode())
                .errorMessage(errorCode.getMessage())
                .build();
    }
}
