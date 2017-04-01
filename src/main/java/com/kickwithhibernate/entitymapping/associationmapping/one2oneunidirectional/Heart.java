package com.kickwithhibernate.entitymapping.associationmapping.one2oneunidirectional;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by bhushan on 21/3/17.
 */
@Entity
public class Heart implements Serializable {
    private static final long serialVersionUID = 8040937148196053807L;
    @Id
    @GeneratedValue
    private Long id;

    private double heartBeatSpeed;


    public double getHeartBeatSpeed() {
        return heartBeatSpeed;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHeartBeatSpeed(double heartBeatSpeed) {
        this.heartBeatSpeed = heartBeatSpeed;
    }
}
