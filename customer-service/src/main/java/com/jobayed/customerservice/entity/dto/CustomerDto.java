package com.jobayed.customerservice.entity.dto;

import com.jobayed.customerservice.enums.Status;

import java.time.LocalDateTime;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/15/24 4:47 PM
 */

public interface CustomerDto {
    String getId();

    String getName();

    String getPhoneNumber();

    Status getStatus();

    String getLocation();

    String getCity();

    String getPostCode();

    LocalDateTime getCreatedAt();
}
