package com.jobayed.orderservice.entity;

import com.jobayed.orderservice.enums.BillStatus;
import com.jobayed.orderservice.utility.converter.BillStatusConverter;
import jakarta.persistence.*;
import lombok.*;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 5:38 PM
 */
@Table(name = "SALES")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SalesEntity extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sales_id_generator"
    )
    @SequenceGenerator(
            name = "sales_id_generator",
            sequenceName = "sales_id_seq",
            allocationSize = 1
    )
    Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    OrderEntity order;

    @Column(name = "bill", nullable = false)
    double bill;

    @Convert(converter = BillStatusConverter.class)
    @Column(name = "STATUS")
    BillStatus billStatus;
}
