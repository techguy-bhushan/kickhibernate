package com.kickoffwithhibernate.entitymapping.inheritancemapping.tablepersubclass.withxml;

/**
 * Created by bhushan on 12/3/17.
 */
public class Employee {
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
