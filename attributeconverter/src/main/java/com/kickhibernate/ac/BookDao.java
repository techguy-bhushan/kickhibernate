package com.kickhibernate.ac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BookDao {
    private SessionFactory sessionFactory;

    public BookDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long save(Book book) {
        Session session = null;
        Long id = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            id = (Long) session.save(book);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return id;
    }

    public Book get(long i) {
        Session session = null;
        Book book = null;
        try {
            session = sessionFactory.openSession();
            book = session.get(Book.class, i);
        } finally {
            session.close();
        }
        return book;
    }
}
