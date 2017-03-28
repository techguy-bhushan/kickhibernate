package com.kickwithhibernate.dao;

import java.io.Serializable;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Created by bhushan on 12/3/17.
 */
public class BaseDAO<T, PK extends Serializable> {

    public T save(T entity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public void delete(T entity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    public T findById(Class<T> type, PK id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.setDefaultReadOnly(true);
        @SuppressWarnings("unchecked")
        T result = (T) session.get(type, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }


}
