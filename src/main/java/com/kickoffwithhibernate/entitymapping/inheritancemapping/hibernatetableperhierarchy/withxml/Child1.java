package com.kickoffwithhibernate.entitymapping.inheritancemapping.hibernatetableperhierarchy.withxml;

/**
 * Created by bhushan on 11/3/17.
 */
public class Child1 extends Parent {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
