package com.kickwithhibernate.generatorclassesinhibernate.identity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by bhushan on 9/3/17.
 */
@Entity(name = "identity_generator")
public class IdentityGenerator implements Serializable {
    private static final long serialVersionUID = -7433096813635528978L;
    @Id
    @GeneratedValue(generator = "identity")
    @GenericGenerator(name = "identity", strategy = "identity")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
