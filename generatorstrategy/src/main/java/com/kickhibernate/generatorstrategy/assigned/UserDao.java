package com.kickhibernate.generatorstrategy.assigned;

import com.kickhibernate.generatorstrategy.BasicDaoTemplate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDao implements BasicDaoTemplate<User, Long> {
    private SessionFactory sessionFactory;
    private UserDao() { }
    private static UserDao userDao = new UserDao();
    public static UserDao getUserDao() {
        return userDao;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Long create(User entity) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
           Long id = (Long) session.save(entity);
           session.getTransaction().commit();
           return id;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public User get(Long id) {
        Session session = sessionFactory.openSession();
        try {
           return  session.get(User.class, id);
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
