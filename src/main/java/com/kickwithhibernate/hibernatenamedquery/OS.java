package com.kickwithhibernate.hibernatenamedquery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by bhushan on 28/3/17.
 */

@NamedQueries({
        @NamedQuery( name = "listOfOS",
                query = "from OS")
})

@Entity
public class OS {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String osName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }
}
