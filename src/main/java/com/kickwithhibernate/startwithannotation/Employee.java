package com.kickwithhibernate.startwithannotation;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by bhushan on 8/3/17.
 * Note ; This entity is registered with hibernate.cfg.xml, <mapping class="com.kickoffwithhibernate.startwithannotation.Employee"/>(means reference to a mapping file in configuration)
 *
 */

@Entity(name = "employess_2")
@Table(name = "employess_2")
public class Employee implements Serializable {
    private static final long serialVersionUID = -3662585877797913050L;

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name",nullable = false, length = 100)
    private String firstName;
    @Column(length = 100)
    private String lastName;
    @Embedded
    @AttributeOverrides( {@AttributeOverride(name = "phoneNumber", column = @Column(name = "phone_number")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "postal_code"))})
    private Address address;
    private String password;

    @Transient
    private String confirmPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
