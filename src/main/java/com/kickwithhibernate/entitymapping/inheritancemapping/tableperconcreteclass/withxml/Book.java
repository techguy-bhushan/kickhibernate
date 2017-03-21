package com.kickwithhibernate.entitymapping.inheritancemapping.tableperconcreteclass.withxml;

/**
 * Created by bhushan on 12/3/17.
 */
public class Book {
    private Long id;
    private String author;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
