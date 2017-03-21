package com.kickoffwithhibernate.generatorclassesinhibernate.jpaidentifierstrategies.tableidentifier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by bhushan on 9/3/17.
 */
@Entity(name = "table_identifier")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
}
