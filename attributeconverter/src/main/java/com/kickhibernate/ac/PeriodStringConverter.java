package com.kickhibernate.ac;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.time.Period;

@Convert
public class PeriodStringConverter implements AttributeConverter<Period, String>{
    @Override
    public String convertToDatabaseColumn(Period period) {
         return period == null ? null : period.toString();
    }

    @Override
    public Period convertToEntityAttribute(String s) {
        return s == null ? null : Period.parse( s );
    }
}
