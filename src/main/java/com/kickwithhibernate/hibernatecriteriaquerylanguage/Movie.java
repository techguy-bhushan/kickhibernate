package com.kickwithhibernate.hibernatecriteriaquerylanguage;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

/**
 * Created by bhushan on 29/3/17.
 */
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Type(type = "yes_no")
    @Column(nullable = false, columnDefinition = "char(1) default 'N'")
    private boolean actionMovie;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<Genre> genres = new HashSet<Genre>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActionMovie() {
        return actionMovie;
    }

    public void setActionMovie(boolean actionMovie) {
        this.actionMovie = actionMovie;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
