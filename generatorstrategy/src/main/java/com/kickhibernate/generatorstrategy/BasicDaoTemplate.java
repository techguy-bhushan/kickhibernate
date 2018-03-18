package com.kickhibernate.generatorstrategy;
/*
Here T is  entity class type and I is Id type of entity
*/

import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

public interface BasicDaoTemplate<T, I extends Serializable> {
    void setSessionFactory(SessionFactory sessionFactory);
    I create(T entity);
    void update(T entity);
    I delete(I id);
    T get(I id);
    List<T> getAll();
}
