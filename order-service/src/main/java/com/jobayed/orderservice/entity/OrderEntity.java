package com.jobayed.orderservice.entity;

import com.jobayed.orderservice.enums.OrderStatus;
import com.jobayed.orderservice.utility.OrderStatusConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 5:38 PM
 */
@Table(name = "ORDERS")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderEntity extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_id_generator"
    )
    @SequenceGenerator(
            name = "order_id_generator",
            sequenceName = "order_id_seq",
            allocationSize = 1
    )
    Long id;

    @Column(name = "order_id", nullable = false)
    String orderId;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    CustomerEntity customer;

    @Convert(converter = OrderStatusConverter.class)
    @Column(name = "STATUS")
    OrderStatus orderStatus;

    @OneToMany(mappedBy = "id")
    private List<OrderItemEntity> orderItems;

}
