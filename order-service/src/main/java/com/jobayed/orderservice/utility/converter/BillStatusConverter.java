package com.jobayed.orderservice.utility.converter;

import com.jobayed.orderservice.enums.BillStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 8:01 PM
 */
@Converter
public class BillStatusConverter implements AttributeConverter<BillStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(BillStatus attribute) {
        return attribute.getValue();
    }

    @Override
    public BillStatus convertToEntityAttribute(Integer dbData) {
        return BillStatus.getByValue(dbData);
    }
}
