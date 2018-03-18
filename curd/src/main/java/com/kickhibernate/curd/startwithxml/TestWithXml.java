package com.kickhibernate.curd.startwithxml;

import junit.framework.Assert;
import org.hamcrest.core.Is;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestWithXml {
    private final static Logger LOGGER = Logger.getLogger(TestWithXml.class.getName());
    public static void main(String[] args) {
        try {
            EmployeeDao employeeDao = EmployeeDao.getEmployeeDao();

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

        } finally {
            EmployeeDao.sessionFactory.close();
        }

    }


}
