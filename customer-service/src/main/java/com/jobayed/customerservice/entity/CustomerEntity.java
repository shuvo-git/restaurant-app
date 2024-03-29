package com.jobayed.customerservice.entity;

import com.jobayed.customerservice.enums.Status;
import com.jobayed.customerservice.utility.StatusConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 5:38 PM
 */
@Table(name = "CUSTOMER")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerEntity extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_generator"
    )
    @SequenceGenerator(
            name = "customer_id_generator",
            sequenceName = "customer_id_seq",
            allocationSize = 1
    )
    Long id;

    @Column(name = "NAME")
    String name;

    @Column(name = "PHONE")
    String phoneNumber;

    @Convert(converter = StatusConverter.class)
    @Column(name = "STATUS")
    Status status;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    AddressEntity address;
}
