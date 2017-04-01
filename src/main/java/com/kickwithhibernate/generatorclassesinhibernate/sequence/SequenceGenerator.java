package com.kickwithhibernate.generatorclassesinhibernate.sequence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by bhushan on 9/3/17.
 */
@Entity(name = "sequence_generator")
public class SequenceGenerator implements Serializable {
    private static final long serialVersionUID = -2213809147877882721L;
    @Id
   /* @GeneratedValue(generator="sequence")
    @GenericGenerator(name="sequence", strategy = "sequence")*/
    private Long id;

    public SequenceGenerator() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
