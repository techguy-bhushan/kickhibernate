package com.kickoffwithhibernate.entitymapping.inheritancemapping.hibernatetableperhierarchy.withannotation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by bhushan on 11/3/17.
 */
@Entity
@DiscriminatorValue("email")
public class Email extends Notification {
    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
