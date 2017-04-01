package com.kickwithhibernate.entitymapping.associationmapping.one2oneunidirectional;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by bhushan on 21/3/17.
 */
@Entity
public class Body implements Serializable {
    private static final long serialVersionUID = -2994957991211867157L;
    @Id
    @GeneratedValue
    private Long id;

    /*If we write cascade = “all” then changes at parent class object will be effected to child class object too,
     *if we write cascade = “all” then all operations like insert, delete, update at parent object will be effected to child object also
     */
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(unique= true, nullable=true)
    private Heart heart;
    
    private double bodyTemperature;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Heart getHeart() {
        return heart;
    }

    public void setHeart(Heart heart) {
        this.heart = heart;
    }
    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }
}
