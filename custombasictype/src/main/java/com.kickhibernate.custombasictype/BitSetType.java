package com.kickhibernate.custombasictype;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import java.util.BitSet;
/*
* The AbstractSingleColumnStandardBasicType requires an sqlTypeDescriptor and a javaTypeDescriptor. The sqlTypeDescriptor is VarcharTypeDescriptor.INSTANCE because the database column is a VARCHAR. On the Java side, we need to use a BitSetTypeDescriptor instance which can be implemented like this:
* */
public class BitSetType extends AbstractSingleColumnStandardBasicType<BitSet> implements DiscriminatorType<BitSet>{
    public static final BitSetType INSTANCE = new BitSetType();
    public BitSetType() {
        super( VarcharTypeDescriptor.INSTANCE, BitSetTypeDescriptor.INSTANCE );
    }

    @Override
    public BitSet stringToObject(String xml) throws Exception {
        return fromString( xml );
    }

    @Override
    public String objectToSQLString(BitSet value, Dialect dialect) throws Exception {
        return toString( value );
    }

    @Override
    public String getName() {
        return "bitset";
    }

}
