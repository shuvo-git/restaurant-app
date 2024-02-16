package com.jobayed.orderservice.entity;

import com.jobayed.orderservice.enums.Status;
import com.jobayed.orderservice.utility.StatusConverter;
import jakarta.persistence.*;
import lombok.*;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 5:38 PM
 */
@Table(name = "CUSTOMER")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomerEntity extends BaseEntity {
    @Id
    Long id;

    @Column(name = "NAME")
    String name;

    @Convert(converter = StatusConverter.class)
    @Column(name = "STATUS")
    Status status;
}
