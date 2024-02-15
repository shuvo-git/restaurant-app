package com.jobayed.orderservice.exception;

import lombok.Builder;
import lombok.Data;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/13/24 7:57 PM
 */
@Data
@Builder
public class Error {
    String errorCode;
    String errorMessage;
}
