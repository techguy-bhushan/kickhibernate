package com.kickwithhibernate.entitymapping.associationmapping.one2oneunidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by bhushan on 21/3/17.
 */
@Entity
public class Heart {
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

    public double getHearBeatSpeed() {
        return heartBeatSpeed;
    }

    public void setHeartBeatSpeed(double heartBeatSpeed) {
        this.heartBeatSpeed = heartBeatSpeed;
    }
}
