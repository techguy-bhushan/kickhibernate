package com.kickoffwithhibernate.entitymapping.inheritancemapping.hibernatetableperhierarchy.withannotation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by bhushan on 11/3/17.
 */
@Entity
@DiscriminatorValue("msg")
public class Message extends Notification {
    private String mobileNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
