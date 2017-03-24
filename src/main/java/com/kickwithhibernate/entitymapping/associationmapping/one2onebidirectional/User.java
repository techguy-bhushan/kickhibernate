package com.kickwithhibernate.entitymapping.associationmapping.one2onebidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by bhushan on 24/3/17.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
