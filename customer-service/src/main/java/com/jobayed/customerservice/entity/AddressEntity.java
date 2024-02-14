package com.jobayed.customerservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 6:01 PM
 */

@Table(name = "ADDRESS")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressEntity extends BaseEntity{
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_id_generator"
    )
    @SequenceGenerator(
            name = "address_id_generator",
            sequenceName = "address_id_seq",
            allocationSize = 1
    )
    Long id;

    @Column(name = "location")
    String location;

    @Column(name = "city")
    String city;

    @Column(name = "postCode")
    String postCode;
}
