package com.jobayed.customerservice.controller.model.request;

import com.jobayed.customerservice.enums.Status;
import lombok.Data;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 7:59 PM
 */

public interface CustomerRequest {
    @Data
    class Customer {
        String name;
        String phoneNumber;
        Status status;
        String location;
        String city;
        String postCode;
    }
}


