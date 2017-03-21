package com.kickwithhibernate.dao;

import java.io.Serializable;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Created by bhushan on 12/3/17.
 */
public class BaseDAO<T, PK extends Serializable> {

    public void save(T entity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(T entity) {
        HibernateUtil.getCurrentSession().delete(entity);
    }

    public T findById(Class<T> type, PK id) {
        @SuppressWarnings("unchecked")
        T result = (T) HibernateUtil.getCurrentSession().load(type, id);
        return result;
    }

    public T getById(Class type, PK id) {
        @SuppressWarnings("unchecked")
        T result = (T) HibernateUtil.getCurrentSession().get(type, id);
        return result;
    }

}
