package com.kickwithhibernate.generatorclassesinhibernate.hilo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by bhushan on 9/3/17.
 */
@Entity(name = "hilo_generator")
public class Hilo {
    @Id
    @GeneratedValue(generator = "hilo")
    @GenericGenerator(name = "hilo", strategy = "hilo")
    private Long id;
}
