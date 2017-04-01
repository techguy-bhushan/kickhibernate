package com.kickwithhibernate.generatorclassesinhibernate.customgenerator;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by bhushan on 9/3/17.
 */
@Entity(name = "custom_generator")
public class Custom implements Serializable {
    private static final long serialVersionUID = 8828715022940398284L;
    @Id
    @GeneratedValue(generator = "custom_id")
    @GenericGenerator(name = "custom_id",
            strategy = "com.kickwithhibernate.generatorclassesinhibernate.customgenerator.CustomIdGenerator")
    private String id;

}
