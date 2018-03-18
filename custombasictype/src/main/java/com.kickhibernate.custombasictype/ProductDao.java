package com.kickhibernate.custombasictype;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDao {

    private SessionFactory sessionFactory;

    public ProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int save(Product product) {
        Session session = null;
        Integer integer = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            integer = (Integer) session.save(product);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return integer;
    }

    public Product get(int i) {
        Session session = null;
        Product product = null;
        try {
            session = sessionFactory.openSession();
            product = session.get(Product.class, i);
        } finally {
            session.close();
        }
        return product;
    }
}
