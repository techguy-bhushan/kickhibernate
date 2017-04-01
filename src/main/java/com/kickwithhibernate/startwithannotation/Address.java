package com.kickwithhibernate.startwithannotation;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Created by bhushan on 21/3/17.
 */
@Embeddable
public class Address implements Serializable {
    private static final long serialVersionUID = -6740445995621493668L;
    private String street1;
    private String street2;
    private String phoneNumber;
    private String postalCode;

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
