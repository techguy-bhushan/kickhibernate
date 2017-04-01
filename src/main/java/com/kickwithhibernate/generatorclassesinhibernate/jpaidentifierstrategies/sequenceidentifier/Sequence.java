package com.kickwithhibernate.generatorclassesinhibernate.jpaidentifierstrategies.sequenceidentifier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.kickwithhibernate.generatorclassesinhibernate.sequence.SequenceGenerator;

/**
 * Created by bhushan on 9/3/17.
 *
 * Note: {@link SequenceGenerator} and this is a same thing.
 * means @GeneratedValue(strategy = GenerationType.SEQUENCE) and @GeneratedValue(generator="sequence") are a same.
 * Bbest practice is use GenerationType.SEQUENCE instead of "sequence"
 */


@Entity(name = "sequence_identifier")
public class Sequence implements Serializable{
    private static final long serialVersionUID = -6317938706030568504L;
    @Id
/*    @GeneratedValue(strategy = GenerationType.SEQUENCE)*/
    private Long id;
}
