package com.kickwithhibernate.entitymapping.collectionmapping.many2many.withjointable;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Created by bhushan on 1/4/17.
 */
@Entity
public class Artist implements Serializable{
    private static final long serialVersionUID = 5350479181027151243L;
    @Id
    @GeneratedValue
    private Long idArtist;
    private String name;
    private String description;

    public Long getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(Long idArtist) {
        this.idArtist = idArtist;
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

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    @ManyToMany(mappedBy = "artists")
    private Set<Event> events = new HashSet<Event>();
}
