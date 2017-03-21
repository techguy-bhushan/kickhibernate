package com.kickoffwithhibernate.generatorclassesinhibernate.customgenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by bhushan on 9/3/17.
 */
@Entity(name = "custom_generator")
public class Custom {
    @Id
    @GeneratedValue(generator = "custom_id")
    @GenericGenerator(name = "custom_id",
            strategy = "com.kickoffwithhibernate.generatorclassesinhibernate.customgenerator.CustomIdGenerator")
    private String id;

}
