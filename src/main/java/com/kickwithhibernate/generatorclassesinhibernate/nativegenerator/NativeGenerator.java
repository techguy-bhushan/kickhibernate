package com.kickwithhibernate.generatorclassesinhibernate.nativegenerator;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by bhushan on 9/3/17.
 */
@Entity(name = "native_generator")
public class NativeGenerator implements Serializable {
    private static final long serialVersionUID = 8394356812933005368L;
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
