package com.jobayed.orderservice.entity;

import com.jobayed.orderservice.enums.Status;
import com.jobayed.orderservice.utility.StatusConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "ORDER_ITEMS")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderItemEntity extends BaseEntity{
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_item_id_generator"
    )
    @SequenceGenerator(
            name = "order_item_id_generator",
            sequenceName = "order_item_id_seq",
            allocationSize = 1
    )
    Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    OrderEntity order ;

    @ManyToOne
    @JoinColumn(name = "item_id")
    ItemEntity item ;

    @Column(name = "quantity", nullable = false)
    Integer quantity;
}
