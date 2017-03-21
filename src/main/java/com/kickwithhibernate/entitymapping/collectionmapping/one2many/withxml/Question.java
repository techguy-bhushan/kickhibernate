package com.kickwithhibernate.entitymapping.collectionmapping.one2many.withxml;

import java.util.List;

/**
 * Created by bhushan on 12/3/17.
 */
public class Question {
    private Long id;
    private String question;
    private List<Answer> answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
