package com.kickhibernate;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class GenderTypeConverter implements AttributeConverter<GenderType, Character>{

    @Override
    public Character convertToDatabaseColumn( GenderType value ) {
        if ( value == null ) {
            return null;
        }

        return value.getCode();
    }

    @Override
    public GenderType convertToEntityAttribute( Character value ) {
        if ( value == null ) {
            return null;
        }

        return GenderType.fromCode( value );
    }
}
