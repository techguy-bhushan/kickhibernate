package com.kickwithhibernate.generatorclassesinhibernate.jpaidentifierstrategies.identityidentifier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by bhushan on 9/3/17.
 */
@Entity(name = "identity_identifier")
public class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
