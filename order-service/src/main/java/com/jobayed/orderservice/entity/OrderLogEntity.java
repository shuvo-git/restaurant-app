package com.jobayed.orderservice.entity;

import com.jobayed.orderservice.enums.OrderStatus;
import com.jobayed.orderservice.utility.OrderStatusConverter;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "ORDER_LOG")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderLogEntity extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_log_id_generator"
    )
    @SequenceGenerator(
            name = "order_log_id_generator",
            sequenceName = "order_log_id_seq",
            allocationSize = 1
    )
    Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    OrderEntity order;

    @Convert(converter = OrderStatusConverter.class)
    @Column(name = "STATUS")
    OrderStatus orderStatus;

    @Column(name = "description", nullable = true)
    String description;

}
