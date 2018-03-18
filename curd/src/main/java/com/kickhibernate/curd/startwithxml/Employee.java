package com.kickhibernate.curd.startwithxml;

import java.io.Serializable;

/**
 * Created by bhushan on 19/2/17.
 * ---------------------------------------------------------------------------------------
 * Prefer non-final class: Hibernate uses the concept of proxies,that depends on the persistent class.
 * The application programmer will not be able to use proxies for lazy association fetching.
 *-------------------------------------------------------------------------------------------
 * It is recommended that you have a default constructor at least package visibility so that hibernate can create the instance of the Persistent class by newInstance() method.
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 6774825366322336183L;

    private Long id;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
