package com.kickwithhibernate.entitymapping.inheritancemapping.tablepersubclass.withxml;


/**
 * Created by bhushan on 12/3/17.
 */
public class RegularEmployee extends Employee {
    private double salaryPerMonth;

    public double getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(double salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

}
