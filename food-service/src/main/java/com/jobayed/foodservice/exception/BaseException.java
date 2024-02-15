package com.jobayed.foodservice.exception;


import com.jobayed.foodservice.utility.ErrorCode;
import lombok.Data;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/13/24 5:31 PM
 */
@Data
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
