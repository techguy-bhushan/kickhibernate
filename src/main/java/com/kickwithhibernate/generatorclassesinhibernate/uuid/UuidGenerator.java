package com.kickwithhibernate.generatorclassesinhibernate.uuid;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by bhushan on 9/3/17.
 */
@Entity(name = "uuid_generator")
public class UuidGenerator {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid" )
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
