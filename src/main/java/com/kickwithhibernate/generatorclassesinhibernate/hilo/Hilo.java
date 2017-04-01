package com.kickwithhibernate.generatorclassesinhibernate.hilo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by bhushan on 9/3/17.
 */
@Entity(name = "hilo_generator")
public class Hilo implements Serializable{
    private static final long serialVersionUID = -6938440005518278013L;
    @Id
    @GeneratedValue(generator = "hilo")
    @GenericGenerator(name = "hilo", strategy = "hilo")
    private Long id;
}
