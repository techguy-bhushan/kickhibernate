package com.kickhibernate.naming;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDao {

    private SessionFactory sessionFactory;

    public ProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int save(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Integer integer = (Integer) session.save(product);
        session.getTransaction().commit();
        session.close();
        return integer;
    }
}
