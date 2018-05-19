package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

/**
 * Created by bhushan on 12/3/17.
 */
public class BaseDAO<T, PK extends Serializable> {
    private SessionFactory sessionFactory;
    public BaseDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public T saveOrUpdate(T entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //UpdateAndSave method with throw javax.persistence.OptimisticLockException in case of Id generator IDENTITY
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public PK save(T entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //UpdateAndSave method with throw javax.persistence.OptimisticLockException in case of Id generator IDENTITY
        PK id= (PK)session.save(entity);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public void update(T entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //UpdateAndSave method with throw javax.persistence.OptimisticLockException in case of Id generator IDENTITY
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    public T findById(Class<T> type, PK id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.setDefaultReadOnly(true);
        @SuppressWarnings("unchecked")
        T result = (T) session.get(type, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }


}