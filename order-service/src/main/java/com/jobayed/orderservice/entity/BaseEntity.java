package com.jobayed.orderservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 6:15 PM
 */

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class BaseEntity {
    @CreatedBy
    @Column(name = "CREATED_BY")
    String createdBy;

    @CreatedDate
    @Column(name = "CREATED_AT")
    LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "UPDATED_BY")
    String updatedBy;

    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    LocalDateTime updatedAt;

    @Version
    @Column(name = "version")
    Long version;
}
