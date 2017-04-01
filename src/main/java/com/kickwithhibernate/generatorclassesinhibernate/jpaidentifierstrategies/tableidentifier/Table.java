package com.kickwithhibernate.generatorclassesinhibernate.jpaidentifierstrategies.tableidentifier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by bhushan on 9/3/17.
 */
@Entity(name = "table_identifier")
public class Table implements Serializable {
    private static final long serialVersionUID = 236488038912799168L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
}
