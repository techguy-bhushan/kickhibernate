package com.kickhibernate.dao;

import com.kickhibernate.manytoone.unidirectional.Phone;
import com.kickhibernate.onetoone.bidirectional.Book;
import com.kickhibernate.onetoone.bidirectional.BookDetails;
import com.kickhibernate.onetoone.undirection.CellPhone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class BaseDao {
    private SessionFactory sessionFactory;

    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long save(Object ob) {
        Session session = null;
        Long id = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            id = (Long) session.save(ob);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return id;
    }

    public List<Phone> phones() {
       Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Phone");
        return query.getResultList();
    }

    public CellPhone getCellPhone(Long id) {
        Session session = sessionFactory.openSession();
        return session.load(CellPhone.class, id);
    }

    public Book getBook(Long id) {
        Session session = sessionFactory.openSession();
        return session.load(Book.class, id);
    }

    public BookDetails getBookDetails(Long id) {
        Session session = sessionFactory.openSession();
        return session.load(BookDetails.class, id);
    }

}
