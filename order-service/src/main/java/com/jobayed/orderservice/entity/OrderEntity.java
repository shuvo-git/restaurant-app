package com.jobayed.orderservice.entity;

import com.jobayed.orderservice.enums.OrderStatus;
import com.jobayed.orderservice.utility.OrderStatusConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 5:38 PM
 */
@Table(name = "ORDERS")
@Entity
@Data
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

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    CustomerEntity customerId;

    @Convert(converter = OrderStatusConverter.class)
    @Column(name = "STATUS")
    OrderStatus orderStatus;


}
