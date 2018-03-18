package com.kickhibernate.ac;

import org.hamcrest.core.Is;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Period;
import java.util.Date;

import static org.junit.Assert.assertThat;

public class BookDaoTest {
    private static BookDao bookDao;
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void init() {
        sessionFactory = Hbm.getSessionFactory(Book.class);
        bookDao = new BookDao(sessionFactory);
    }

    @Test
    public void saveProduct() {
        Book instance = new Book();
        Date date = new Date();
        instance.setId(1l);
        instance.setDate(date);
        instance.setTime(date);
        instance.setTimestamp(date);
        instance.setSpan(Period.of(1, 2, 3));
        Long id = bookDao.save(instance);
        Book book = bookDao.get(id);

        assertThat(book.getId(), Is.is(id));
        assertThat(book.getSpan().getYears(), Is.is(1));
        assertThat(book.getSpan().getMonths(), Is.is(2));
        assertThat(book.getSpan().getDays(), Is.is(3));

    }

    @AfterClass
    public static void destroy() {
        sessionFactory.close();
    }



    /*

    mysql> desc Book;
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| id        | bigint(20)   | NO   | PRI | NULL    |       |
| date      | date         | YES  |     | NULL    |       |
| span      | varchar(255) | YES  |     | NULL    |       |
| time      | time         | YES  |     | NULL    |       |
| timestamp | datetime     | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
5 rows in set (0.00 sec)


    * mysql> select * from Book;
+----+------------+---------+----------+---------------------+
| id | date       | span    | time     | timestamp           |
+----+------------+---------+----------+---------------------+
|  1 | 2018-03-18 | P1Y2M3D | 21:51:44 | 2018-03-18 21:51:45 |
+----+------------+---------+----------+---------------------+
1 row in set (0.00 sec)

    *
    * */
}
