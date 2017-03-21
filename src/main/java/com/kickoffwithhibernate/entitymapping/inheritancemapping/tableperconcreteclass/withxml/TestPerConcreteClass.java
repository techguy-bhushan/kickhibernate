package com.kickoffwithhibernate.entitymapping.inheritancemapping.tableperconcreteclass.withxml;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Created by bhushan on 12/3/17.
 */
public class TestPerConcreteClass {
    public static void main(String[] args) {
        Book book = new Book();
        book.setName("The Fault in Our Stars");
        book.setAuthor("John Green");
        createData(book);
        PrintedBook printedBook = new PrintedBook();
        printedBook.setName("Looking for Alaska");
        printedBook.setAuthor("John Green");
        printedBook.setWeight(1.2);
        printedBook.setBulkyPaperUsed(false);
        createData(printedBook);
        EBook eBook = new EBook();
        eBook.setName("Paper Towns");
        eBook.setAuthor("John Green");
        eBook.setFree(true);
        eBook.setAvailable(true);
        createData(eBook);
        HibernateUtil.shutdown();
    }

    private static void createData(Book instance) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(instance);
        session.getTransaction().commit();
    }
/*

mysql> select * from Book;
+----+------------------------+------------+
| id | name                   | author     |
+----+------------------------+------------+
|  1 | The Fault in Our Stars | John Green |
+----+------------------------+------------+
1 row in set (0.00 sec)

mysql> select * from EBook;
+----+-------------+------------+-------------+--------+
| id | name        | author     | isAvailable | isFree |
+----+-------------+------------+-------------+--------+
|  3 | Paper Towns | John Green | Y           | Y      |
+----+-------------+------------+-------------+--------+
1 row in set (0.00 sec)

mysql> select * from PrintedBook;
+----+--------------------+------------+--------+------------------+
| id | name               | author     | weight | isBulkyPaperUsed |
+----+--------------------+------------+--------+------------------+
|  2 | Looking for Alaska | John Green |    1.2 | N                |
+----+--------------------+------------+--------+------------------+
1 row in set (0.00 sec)

*/

}
