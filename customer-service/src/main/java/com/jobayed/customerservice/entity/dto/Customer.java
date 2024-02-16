package com.jobayed.customerservice.entity.dto;

import com.jobayed.customerservice.entity.BaseEntity;
import com.jobayed.customerservice.enums.Status;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends BaseEntity {
    Long id;
    String name;
    Status status;
}
