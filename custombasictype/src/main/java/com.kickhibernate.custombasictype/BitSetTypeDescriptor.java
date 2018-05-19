package com.kickhibernate.custombasictype;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

import java.util.BitSet;

public class BitSetTypeDescriptor extends AbstractTypeDescriptor<BitSet>{
    private static final String DELIMITER = ",";
    public static final BitSetTypeDescriptor INSTANCE = new BitSetTypeDescriptor();

    public BitSetTypeDescriptor() {
        super( BitSet.class );
    }

    @Override
    public String toString(BitSet bitSet) {
        StringBuilder builder = new StringBuilder();
        for ( long token : bitSet.toLongArray() ) {
            if ( builder.length() > 0 ) {
                builder.append( DELIMITER );
            }
            builder.append( Long.toString( token, 2 ) );
        }
        return builder.toString();
    }

    @Override
    public BitSet fromString(String string) {
        if ( string == null || string.isEmpty() ) {
            return null;
        }
        String[] tokens = string.split( DELIMITER );
        long[] values = new long[tokens.length];

        for ( int i = 0; i < tokens.length; i++ ) {
            values[i] = Long.valueOf( tokens[i], 2 );
        }
        return BitSet.valueOf( values );
    }
/*
* The unwrap method is used when passing a BitSet as a PreparedStatement bind parameter, while the wrap method is used to transform the JDBC column value object (e.g. String in our case) to the actual mapping object type (e.g. BitSet in this example).
* */
    @Override
    public <X> X unwrap(BitSet value, Class<X> type, WrapperOptions wrapperOptions) {
        if ( value == null ) {
            return null;
        }
        if ( BitSet.class.isAssignableFrom( type ) ) {
            return (X) value;
        }
        if ( String.class.isAssignableFrom( type ) ) {
            return (X) toString( value);
        }
        throw unknownUnwrap( type );
    }

    @Override
    public <X> BitSet wrap(X value, WrapperOptions wrapperOptions) {
        if ( value == null ) {
            return null;
        }
        if ( String.class.isInstance( value ) ) {
            return fromString( (String) value );
        }
        if ( BitSet.class.isInstance( value ) ) {
            return (BitSet) value;
        }
        throw unknownWrap( value.getClass() );
    }
}
