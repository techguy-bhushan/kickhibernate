package com.kickhibernate.onetoone.bidirectional;

import com.kickhibernate.dao.BaseDao;
import com.kickhibernate.onetoone.undirection.CellPhone;
import com.kickhibernate.onetoone.undirection.CellPhoneDetail;
import com.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class oneToOneWithBiDirectionalRelationTest {

    private static BaseDao baseDao;
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void init() {
        sessionFactory = HibernateUtil.getSessionFactory(Book.class, BookDetails.class);
        baseDao = new BaseDao(sessionFactory);
    }


    @Test
    public void testRelation() {
        BookDetails details = new BookDetails();
        details.setAuthorName("Xyz");
        details.setPrice(10.5);

        Book book = new Book();
        book.setName("Bio");
        book.setBookDetails(details);
        details.setBook(book);

        Long id = baseDao.save(book);
        Assert.assertNotNull(id);

        Book instance = baseDao.getBook(id);
        System.out.println(instance);

        Assert.assertNotNull(instance);
        Assert.assertNotNull(instance.getBookDetails());

        BookDetails bookDetailsIns = baseDao.getBookDetails(details.getId());
        System.out.println(bookDetailsIns);

        Assert.assertNotNull(bookDetailsIns);
        Assert.assertNotNull(bookDetailsIns.getBook());


    }

    @AfterClass
    public static void destroy() {
        sessionFactory.close();
    }
}
