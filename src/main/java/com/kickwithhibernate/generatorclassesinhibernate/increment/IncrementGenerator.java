package com.kickwithhibernate.generatorclassesinhibernate.increment;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by bhushan on 8/3/17.
 * It generates the unique id only if no other process is inserting data into this table.
 * It generates short, int or long type identifier. The first generated identifier is 1 normally and incremented as 1.
 * Xml Syntax:
 <id ...>
 <generator class="increment"></generator>
 </id>
 * Here we are using annotation for increment strategy
 * @javax.persistence.GeneratedValue and @org.hibernate.annotations.GenericGenerator work in tandem to indicate that Hibernate should use Hibernate's increment generation strategy for this entity's identifier values.
 */
@Entity(name = "increment_generator")
public class IncrementGenerator implements Serializable {
    private static final long serialVersionUID = 3140266995943376613L;
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;

    private String name;

    public IncrementGenerator() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
