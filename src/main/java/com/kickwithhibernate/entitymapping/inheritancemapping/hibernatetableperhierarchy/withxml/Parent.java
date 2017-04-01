package com.kickwithhibernate.entitymapping.inheritancemapping.hibernatetableperhierarchy.withxml;

import java.io.Serializable;

/**
 * Created by bhushan on 11/3/17.
 */
public class Parent implements Serializable {
    private static final long serialVersionUID = -6669816252762580826L;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
