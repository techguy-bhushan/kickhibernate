package com.kickwithhibernate.hql;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by bhushan on 28/3/17.
 */
@Entity
public class Teacher implements Serializable {
    private static final long serialVersionUID = 845624085307251356L;
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    private School school;

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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
