package com.kickwithhibernate.entitymapping.collectionmapping.many2many.withjointable;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Created by bhushan on 1/4/17.
 */
@Entity
public class Event implements Serializable {
    private static final long serialVersionUID = 4201698856975067051L;
    @Id
    @GeneratedValue
    private Long idEvent;
    private String name;
    private String description;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "EventArtists",
            joinColumns =
            @JoinColumn(name = "idEvent"),
            inverseJoinColumns =
            @JoinColumn(name = "idArtist")
    )
    private Set<Artist> artists = new HashSet<Artist>();

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }
}
