package com.jobayed.customerservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 6:15 PM
 */

@Data
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity {
    @CreatedDate
    @Column(name = "CREATED_AT")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    LocalDateTime updatedAt;

    @Version
    @Column(name = "version")
    Long version;
}
