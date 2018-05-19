package com.kickhibernate;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class ContactNumber {
    private String number;
    @Enumerated(EnumType.STRING)
    private ContactNumberType contactNumberType;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ContactNumberType getContactNumberType() {
        return contactNumberType;
    }

    public void setContactNumberType(ContactNumberType contactNumberType) {
        this.contactNumberType = contactNumberType;
    }
}
