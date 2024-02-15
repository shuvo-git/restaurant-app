package com.jobayed.orderservice.exception;

import com.jobayed.customerservice.utility.ErrorCode;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/13/24 5:48 PM
 */

public class CustomerNotFoundException extends BaseException {
    public CustomerNotFoundException() {
        super(ErrorCode.CUSTOMER_NOT_FOUND);
    }

    public CustomerNotFoundException(String code, String message) {
        super(code, message);
    }

    public CustomerNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
