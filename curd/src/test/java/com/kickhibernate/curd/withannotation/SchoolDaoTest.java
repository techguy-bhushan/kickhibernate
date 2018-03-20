package com.kickhibernate.curd.withannotation;

import junit.framework.Assert;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class SchoolDaoTest {
    private final static Logger LOGGER = Logger.getLogger(SchoolDaoTest.class.getName());

    @Test
    public void test() {

            SchoolDao schoolDao = SchoolDao.getSchoolDao();

            School school = new School();
            school.setId(1l);
            school.setName("DAV");
            school.setTotalNumberOfStudent(1000l);

            // insert employee
            Long id = schoolDao.create(school);
/*
mysql> desc School;
+----------------------+--------------+------+-----+---------+-------+
| Field                | Type         | Null | Key | Default | Extra |
+----------------------+--------------+------+-----+---------+-------+
| id                   | bigint(20)   | NO   | PRI | NULL    |       |
| name                 | varchar(255) | YES  |     | NULL    |       |
| preFix               | varchar(255) | YES  |     | NULL    |       |
| totalNumberOfStudent | bigint(20)   | YES  |     | NULL    |       |
+----------------------+--------------+------+-----+---------+-------+
* */
            // Verify id
            assertThat(id, Is.is(1l));

            // Fetch employee by id
            school = schoolDao.get(id);

            assertNotNull(school);

            LOGGER.log(Level.INFO,"Employee id {0}, Name: {1}, total nunmber of students: {2}",new Object[] {school.getId(), school.getName(), school.getTotalNumberOfStudent()});

            // Assert before update
            assertThat(school.getName(), Is.is("DAV"));
            // Update Employee
            school.setName("DBS");
            schoolDao.update(school);
            //Verify after assert
            assertThat(school.getName(), Is.is("DBS"));

            LOGGER.log(Level.INFO,"Employee id {0}, firstName: {1}, lastName: {2}",new Object[] {school.getId(), school.getTotalNumberOfStudent(), school.getTotalNumberOfStudent()});

            // It's time to delete
            schoolDao.delete(school);

            // Time to verify delete
            school = schoolDao.get(id);
            Assert.assertNull(school);

            SchoolDao.sessionFactory.close();
    }
}
