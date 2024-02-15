package com.jobayed.customerservice.controller.model.response;

import lombok.Builder;
import lombok.Data;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 8:08 PM
 */

public interface CustomerResponse {
    @Builder
    @Data
    class Create {
        String message;
    }
}
