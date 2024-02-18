package com.jobayed.orderservice.exception;

import com.jobayed.orderservice.utility.ErrorCode;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/13/24 5:48 PM
 */

public class ItemNotFoundException extends BaseException {
    public ItemNotFoundException() {
        super(ErrorCode.ITEM_NOT_FOUND);
    }

    public ItemNotFoundException(String code, String message) {
        super(code, message);
    }

    public ItemNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
