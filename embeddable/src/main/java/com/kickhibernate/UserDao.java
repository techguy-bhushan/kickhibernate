package com.kickhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDao {
    private SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Integer save(User user) {
        Session session = null;
        Integer id = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            id = (Integer) session.save(user);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return id;
    }

}
