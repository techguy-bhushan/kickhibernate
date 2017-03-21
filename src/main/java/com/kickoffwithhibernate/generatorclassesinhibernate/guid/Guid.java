package com.kickoffwithhibernate.generatorclassesinhibernate.guid;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by bhushan on 9/3/17.
 */
@Entity(name = "guid_generator")
public class Guid {
    @Id
    @GeneratedValue(generator = "guid" )
    @GenericGenerator(name = "guid", strategy = "guid")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
