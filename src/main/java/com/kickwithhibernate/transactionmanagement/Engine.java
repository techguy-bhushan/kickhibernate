package com.kickwithhibernate.transactionmanagement;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by bhushan on 28/3/17.
 */
@Entity
public class Engine implements Serializable {
    private static final long serialVersionUID = 1019768241238693434L;
    @Id
    @GeneratedValue
    private Long id;

    private String brandName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
