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
    public void saveUser() {
        Address address1 = new Address();
        address1.setLine("line1");
        address1.setCity("Delhi");
        address1.setStreet("street1");


        Address address2 = new Address();
        address2.setLine("line2");
        address2.setCity("Noida");
        address2.setStreet("street1");

        ContactNumber contactNumber = new ContactNumber();
        contactNumber.setNumber("1234567890");
        contactNumber.setContactNumberType(ContactNumberType.MOBILE_NUMBER);

        ContactNumber contactNumber2 = new ContactNumber();
        contactNumber2.setNumber("+0 734567890");
        contactNumber2.setContactNumberType(ContactNumberType.TELEPHONE_NUMBER);


        User instance = new User();
        instance.setId(1);
        instance.setAddress1(address1);
        instance.setAddress2(address2);
        instance.addContactNumber(contactNumber);
        instance.addContactNumber(contactNumber2);
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

mysql> desc contact_number;
+-------------------+--------------+------+-----+---------+-------+
| Field             | Type         | Null | Key | Default | Extra |
+-------------------+--------------+------+-----+---------+-------+
| user_id           | int(11)      | NO   | PRI | NULL    |       |
| contactNumberType | varchar(255) | YES  |     | NULL    |       |
| number            | varchar(255) | YES  |     | NULL    |       |
| index_id          | int(11)      | NO   | PRI | NULL    |       |
+-------------------+--------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

mysql> select * from contact_number;
+---------+-------------------+--------------+----------+
| user_id | contactNumberType | number       | index_id |
+---------+-------------------+--------------+----------+
|       1 | MOBILE_NUMBER     | 1234567890   |        0 |
|       1 | TELEPHONE_NUMBER  | +0 734567890 |        1 |
+---------+-------------------+--------------+----------+

* */
}
