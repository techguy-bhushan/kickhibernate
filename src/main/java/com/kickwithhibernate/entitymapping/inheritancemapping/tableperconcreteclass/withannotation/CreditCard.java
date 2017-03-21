package com.kickwithhibernate.entitymapping.inheritancemapping.tableperconcreteclass.withannotation;

import java.util.Date;

import javax.persistence.Entity;

/**
 * Created by bhushan on 12/3/17.
 */
@Entity
public class CreditCard extends Payment {
private String ccNumber;
private Date expireDate;

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
