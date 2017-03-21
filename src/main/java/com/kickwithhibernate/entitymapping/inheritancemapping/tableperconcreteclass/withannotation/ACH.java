package com.kickwithhibernate.entitymapping.inheritancemapping.tableperconcreteclass.withannotation;

import javax.persistence.Entity;

/**
 * Created by bhushan on 12/3/17.
 */
@Entity
public class ACH extends Payment{
    private String bank_name;
    private String accountName;

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
