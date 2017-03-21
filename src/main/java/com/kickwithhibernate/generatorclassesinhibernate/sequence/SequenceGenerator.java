package com.kickwithhibernate.generatorclassesinhibernate.sequence;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by bhushan on 9/3/17.
 */
@Entity(name = "sequence_generator")
public class SequenceGenerator {
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
