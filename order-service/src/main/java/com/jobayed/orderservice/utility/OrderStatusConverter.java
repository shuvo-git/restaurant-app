package com.jobayed.orderservice.utility;

import com.jobayed.orderservice.enums.OrderStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 8:01 PM
 */
@Converter
public class OrderStatusConverter implements AttributeConverter<OrderStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrderStatus attribute) {
        return attribute.getValue();
    }

    @Override
    public OrderStatus convertToEntityAttribute(Integer dbData) {
        return OrderStatus.getByValue(dbData);
    }
}
