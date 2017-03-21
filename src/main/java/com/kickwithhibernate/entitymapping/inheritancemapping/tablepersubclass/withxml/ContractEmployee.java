package com.kickwithhibernate.entitymapping.inheritancemapping.tablepersubclass.withxml;

/**
 * Created by bhushan on 12/3/17.
 */
public class ContractEmployee extends Employee {
    private double salaryPerHour;
    private String contractDuration;

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public String getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(String contractDuration) {
        this.contractDuration = contractDuration;
    }
}
