package com.kickhibernate;

import com.util.BaseDAO;
import com.util.HibernateUtil;
import org.hamcrest.core.Is;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class UserDaoTest {
    private static BaseDAO<User,Long> userDao;
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void init() {
        sessionFactory = HibernateUtil.getSessionFactory(User.class);
        userDao = new BaseDAO<>(sessionFactory);
    }

    @Test
    public void saveProduct() {
        User user = new User();
        user.setId(1l);
        user.setPhoneType(PhoneType.MOBILE);
        user.setGenderType(GenderType.MALE);
        user.setPaymentMethod(PaymentMethod.PAYPAL);
        Long id = userDao.save(user);

        assertThat(id, Is.is(1l));
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
| id            | bigint(20)   | NO   | PRI | NULL    |       |
| genderType    | int(11)      | YES  |     | NULL    |       |
| name          | varchar(255) | YES  |     | NULL    |       |
| paymentMethod | varchar(255) | YES  |     | NULL    |       |
| phoneType     | int(11)      | YES  |     | NULL    |       |
+---------------+--------------+------+-----+---------+-------+


mysql> select * from User;
+----+------------+------+---------------+-----------+
| id | genderType | name | paymentMethod | phoneType |
+----+------------+------+---------------+-----------+
|  1 | M          | NULL | PAYPAL        |         1 |
+----+------------+------+---------------+-----------+
1 row in set (0.00 sec)


*/

}
