package com.kickhibernate;

import org.hamcrest.core.Is;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class UserDaoTest {
    private static UserDao userDao;
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void init() {
        sessionFactory = Hbm.getSessionFactory(User.class);
        userDao = new UserDao(sessionFactory);
    }

    @Test
    public void saveProduct() {
        Address address1 = new Address();
        address1.setLine("line1");
        address1.setCity("Delhi");
        address1.setStreet("street1");


        Address address2 = new Address();
        address2.setLine("line2");
        address2.setCity("Noida");
        address2.setStreet("street1");

        User instance = new User();
        instance.setId(1);
        instance.setAddress1(address1);
        instance.setAddress2(address2);
        Integer id =userDao.save(instance);

        assertThat(id, Is.is(1));
    }

    @AfterClass
    public static void destroy() {
        sessionFactory.close();
    }


/*
mysql> desc User;
+---------------+--------------+------+-----+---------+-------+
| Field         | Type         | Null | Key | Default | Extra |
+---------------+--------------+------+-----+---------+-------+
| id            | int(11)      | NO   | PRI | NULL    |       |
| home_city     | varchar(255) | YES  |     | NULL    |       |
| home_line     | varchar(255) | YES  |     | NULL    |       |
| home_street   | varchar(255) | YES  |     | NULL    |       |
| office_city   | varchar(255) | YES  |     | NULL    |       |
| office_line   | varchar(255) | YES  |     | NULL    |       |
| office_street | varchar(255) | YES  |     | NULL    |       |
| name          | varchar(255) | YES  |     | NULL    |       |
+---------------+--------------+------+-----+---------+-------+
8 rows in set (0.00 sec)

mysql> select * from User;
+----+-----------+-----------+-------------+-------------+-------------+---------------+------+
| id | home_city | home_line | home_street | office_city | office_line | office_street | name |
+----+-----------+-----------+-------------+-------------+-------------+---------------+------+
|  1 | Delhi     | line1     | street1     | Noida       | line2       | street1       | NULL |
+----+-----------+-----------+-------------+-------------+-------------+---------------+------+

* */
}
