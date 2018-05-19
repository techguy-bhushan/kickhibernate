package com.kickhibernate.manytoone.unidirectional;

import com.kickhibernate.dao.BaseDao;
import com.kickhibernate.manytoone.unidirectional.Person;
import com.kickhibernate.manytoone.unidirectional.Phone;
import com.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PersonDaoTest {
    private static BaseDao baseDao;
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void init() {
        sessionFactory = HibernateUtil.getSessionFactory(Person.class, Phone.class);
        baseDao = new BaseDao(sessionFactory);
    }

    @Test
    public void savePerson() {
        Person person = new Person();
        person.setName("John");

        baseDao.save(person);
        System.out.println(person);
        assertNotNull(person.getId());

        Phone phone = new Phone();
        phone.setNumber("147852369");
        phone.setPerson(person);

        Phone phone2 = new Phone();
        phone2.setNumber("847852345");
        phone2.setPerson(person);

        baseDao.save(phone);
        System.out.println(phone);
        assertNotNull(phone.getId());

        baseDao.save(phone2);
        System.out.println(phone2);
        assertNotNull(phone2.getId());


        List<Phone> phones = baseDao.phones();
        assertTrue(phones != null);
        for (Phone p : phones) {
            System.out.println(p);
            assertTrue(p.getPerson() != null);
        }

        assertEquals(phones.size(), 2);
    }

    @AfterClass
    public static void destroy() {
        sessionFactory.close();
    }

}
