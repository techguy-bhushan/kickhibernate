package com.kickhibernate.curd.startwithxml;

import junit.framework.Assert;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDaoTest {
    private final static Logger LOGGER = Logger.getLogger(EmployeeDaoTest.class.getName());
    private EmployeeDao employeeDao = null;

    @Before
    public void init() {
        employeeDao = EmployeeDao.getEmployeeDao();
    }

    @Test
    public void test() {
            Employee employee = new Employee();
            employee.setId(1l);
            employee.setFirstName("Jhon");
            employee.setLastName("Doe");

            // insert employee
            Long id = employeeDao.create(employee);
            // Verify id
            assertThat(id, Is.is(1l));

            // Fetch employee by id
           employee = employeeDao.get(id);

           assertNotNull(employee);

           LOGGER.log(Level.INFO,"Employee id {0}, firstName: {1}, lastName: {2}",new Object[] {employee.getId(), employee.getFirstName(), employee.getLastName()});

           // Assert before update
            assertThat(employee.getFirstName(), Is.is("Jhon"));
            // Update Employee
            employee.setFirstName("Mike");
            employeeDao.update(employee);
            //Verify after assert
            assertThat(employee.getFirstName(), Is.is("Mike"));

            LOGGER.log(Level.INFO,"Employee id {0}, firstName: {1}, lastName: {2}",new Object[] {employee.getId(), employee.getFirstName(), employee.getLastName()});

            // It's time to delete
            employeeDao.delete(employee);

            // Time to verify delete
            employee = employeeDao.get(id);
            Assert.assertNull(employee);

        EmployeeDao.sessionFactory.close();
    }


}
