package com.kickwithhibernate.hibernatecriteriaquerylanguage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by bhushan on 30/3/17.
 */
@Entity
public class Genre {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @ManyToOne
    private Movie movie;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
