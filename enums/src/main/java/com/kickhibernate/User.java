package com.kickhibernate;

import javax.persistence.*;

@Entity
public class User {

    @Id
    private Long id;

    private String name;

/*    In the ORDINAL example, the phone_type column is defined as an (nullable) INTEGER type and would hold:
NULL
    For null values
0
    For the LAND_LINE enum
1
    For the MOBILE enum*/
    @Enumerated(EnumType.ORDINAL)
    private PhoneType phoneType;

/*    In the STRING example, the paymentMethod column is defined as an (nullable) VARCHAR type and would hold:
    NULL
    For null values
PAYPAL:
    For the PAYPAL enum
STRIPE:
For the STRIPE enum*/
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

/*
We can AttributeConverter here for Gender enum which stores its values using the 'M' and 'F' codes.
* */
@Convert(converter = GenderTypeConverter.class)
    private GenderType genderType;

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

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }
}
