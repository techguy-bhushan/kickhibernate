package com.kickwithhibernate.entitymapping.inheritancemapping.tablepersubclass.withannotation;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by bhushan on 12/3/17.
 */
@Entity(name = "reg_emp")
@PrimaryKeyJoinColumn(name = "eid")
public class RegularEmployee extends Employee {
    private double salaryPerMonth;

    public double getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(double salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

}
