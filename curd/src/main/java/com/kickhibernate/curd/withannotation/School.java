package com.kickhibernate.curd.withannotation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long totalNumberOfStudent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalNumberOfStudent() {
        return totalNumberOfStudent;
    }

    public void setTotalNumberOfStudent(Long totalNumberOfStudent) {
        this.totalNumberOfStudent = totalNumberOfStudent;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalNumberOfStudent=" + totalNumberOfStudent +
                '}';
    }
}
