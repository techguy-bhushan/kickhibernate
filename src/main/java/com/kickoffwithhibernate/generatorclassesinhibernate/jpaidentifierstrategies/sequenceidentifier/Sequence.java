package com.kickoffwithhibernate.generatorclassesinhibernate.jpaidentifierstrategies.sequenceidentifier;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.kickoffwithhibernate.generatorclassesinhibernate.sequence.SequenceGenerator;

/**
 * Created by bhushan on 9/3/17.
 *
 * Note: {@link SequenceGenerator} and this is a same thing.
 * means @GeneratedValue(strategy = GenerationType.SEQUENCE) and @GeneratedValue(generator="sequence") are a same.
 * Bbest practice is use GenerationType.SEQUENCE instead of "sequence"
 */


@Entity(name = "sequence_identifier")
public class Sequence {
    @Id
/*    @GeneratedValue(strategy = GenerationType.SEQUENCE)*/
    private Long id;
}
