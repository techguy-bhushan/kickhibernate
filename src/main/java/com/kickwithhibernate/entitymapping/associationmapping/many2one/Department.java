package com.kickwithhibernate.entitymapping.associationmapping.many2one;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by bhushan on 24/3/17.
 */
@Entity
public class Department implements Serializable {
    private static final long serialVersionUID = -1409273870307344556L;
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String depName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

}
