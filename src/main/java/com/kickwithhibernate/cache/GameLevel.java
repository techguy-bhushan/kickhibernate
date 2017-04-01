package com.kickwithhibernate.cache;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Created by bhushan on 30/3/17.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "com.kickwithhibernate.cache.GameLevel")
public class GameLevel implements Serializable {
    private static final long serialVersionUID = 7482093573993303068L;
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
