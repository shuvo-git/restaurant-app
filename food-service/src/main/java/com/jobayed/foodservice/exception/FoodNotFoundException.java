package com.jobayed.foodservice.exception;

import com.jobayed.foodservice.utility.ErrorCode;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/13/24 5:48 PM
 */

public class FoodNotFoundException extends BaseException {
    public FoodNotFoundException() {
        super(ErrorCode.FOOD_NOT_FOUND);
    }

    public FoodNotFoundException(String code, String message) {
        super(code, message);
    }

    public FoodNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
