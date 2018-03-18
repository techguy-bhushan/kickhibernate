package com.kickhibernate;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
/*
*  JPA expects a database column having the same name with its associated object property. When including multiple embeddables, the implicit name-based mapping rule doesn’t work anymore because multiple object properties could end-up being mapped to the same database column.
* */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "line", column = @Column(name = "home_line")),
            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
            @AttributeOverride(name = "city", column = @Column(name = "home_city"))
    } )
    private Address address1;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "line", column = @Column(name = "office_line")),
            @AttributeOverride(name = "street", column = @Column(name = "office_street")),
            @AttributeOverride(name = "city", column = @Column(name = "office_city"))
    } )

    private Address address2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress1() {
        return address1;
    }

    public void setAddress1(Address address1) {
        this.address1 = address1;
    }

    public Address getAddress2() {
        return address2;
    }

    public void setAddress2(Address address2) {
        this.address2 = address2;
    }
}
