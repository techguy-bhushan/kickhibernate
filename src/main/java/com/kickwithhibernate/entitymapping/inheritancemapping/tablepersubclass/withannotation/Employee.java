package com.kickwithhibernate.entitymapping.inheritancemapping.tablepersubclass.withannotation;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Created by bhushan on 12/3/17.
 */
@Entity(name = "emp_1")
@Inheritance(strategy= InheritanceType.JOINED)
public class Employee implements Serializable {
    private static final long serialVersionUID = -2014539566541635289L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
