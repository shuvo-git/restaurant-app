package com.jobayed.foodservice.utility;

import com.jobayed.foodservice.enums.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 8:01 PM
 */
@Converter
public class StatusConverter implements AttributeConverter<Status, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Status attribute) {
        return attribute.getValue();
    }

    @Override
    public Status convertToEntityAttribute(Integer dbData) {
        return Status.getByValue(dbData);
    }
}
