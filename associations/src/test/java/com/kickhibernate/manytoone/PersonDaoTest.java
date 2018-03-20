package com.kickhibernate.manytoone;

import com.kickhibernate.Hbm;
import org.hamcrest.core.Is;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Period;
import java.util.Date;

import static org.junit.Assert.assertThat;

public class PersonDaoTest {
    private static PersonDao personDao;
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void init() {
        sessionFactory = Hbm.getSessionFactory(Person.class);
        personDao = new PersonDao(sessionFactory);
    }

    @Test
    public void savePerson() {
        Person person = new Person();

    }

    @AfterClass
    public static void destroy() {
        sessionFactory.close();
    }

}
