package com.kickwithhibernate.startwithxml;

/**
 * Created by bhushan on 19/2/17.
 * ---------------------------------------------------------------------------------------
 * Prefer non-final class: Hibernate uses the concept of proxies,that depends on the persistent class.
 * The application programmer will not be able to use proxies for lazy association fetching.
 *-------------------------------------------------------------------------------------------
 * It is recommended that you have a default constructor at least package visibility so that hibernate can create the instance of the Persistent class by newInstance() method.
 */
public class Employee {
    public Employee() {
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

    public String getLasttName() {
        return lasttName;
    }

    public void setLasttName(String lasttName) {
        this.lasttName = lasttName;
    }

    private Long id;
    private String firstName;
    private String lasttName;
}
