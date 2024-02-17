package com.jobayed.orderservice.entity;

import com.jobayed.orderservice.enums.Status;
import com.jobayed.orderservice.utility.StatusConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    Long id;

    @Column(name = "NAME")
    String name;

    @Column(name = "PRICE")
    double price;

    @Convert(converter = StatusConverter.class)
    @Column(name = "STATUS")
    Status status;

    @OneToMany(mappedBy = "id")
    private List<OrderItemEntity> orderItems;
}
