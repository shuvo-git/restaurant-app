package com.jobayed.foodservice.entity;

import com.jobayed.foodservice.utility.StatusConverter;
import com.jobayed.foodservice.enums.Status;
import jakarta.persistence.*;
import lombok.*;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 5:38 PM
 */
@Table(name = "ITEM")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ItemEntity extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_id_generator"
    )
    @SequenceGenerator(
            name = "item_id_generator",
            sequenceName = "item_id_seq",
            allocationSize = 1
    )
    Long id;

    @Column(name = "NAME")
    String name;

    @Column(name = "PRICE")
    double price;

    @Convert(converter = StatusConverter.class)
    @Column(name = "STATUS")
    Status status;
}
