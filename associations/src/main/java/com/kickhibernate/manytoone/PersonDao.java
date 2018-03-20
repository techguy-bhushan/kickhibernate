package com.kickhibernate.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersonDao {
    private SessionFactory sessionFactory;

    public PersonDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long saveAndPhone(Person person) {
        Session session = null;
        Long id = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            id = (Long) session.save(person);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return id;
    }
}
