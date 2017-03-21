package com.kickoffwithhibernate.generatorclassesinhibernate.customgenerator;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * Created by bhushan on 9/3/17.
 */
public class CustomIdGenerator implements IdentifierGenerator {

    public static final String ID_PRE_FIX = "CUSTOM";

    public Serializable generate(SessionImplementor sessionImplementor, Object o) throws HibernateException {
        return String.format("%s-%s", ID_PRE_FIX, UUID.randomUUID().toString());
    }

}
