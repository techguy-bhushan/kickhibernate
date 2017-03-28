package com.kickwithhibernate.transactionmanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by bhushan on 28/3/17.
 */
@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String modelNumber;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

}
