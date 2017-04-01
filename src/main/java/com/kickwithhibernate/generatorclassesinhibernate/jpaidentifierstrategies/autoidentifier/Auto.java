package com.kickwithhibernate.generatorclassesinhibernate.jpaidentifierstrategies.autoidentifier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by bhushan on 9/3/17.
 */
@Entity(name = "auto_identifier")
public class Auto implements Serializable {
    private static final long serialVersionUID = -7715985494546020589L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
