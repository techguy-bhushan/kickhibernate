package com.kickhibernate.manytoone;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Person() {
    }
}
