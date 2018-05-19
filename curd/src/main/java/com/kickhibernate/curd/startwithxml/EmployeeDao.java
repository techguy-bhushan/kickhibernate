package com.kickhibernate.curd.startwithxml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDao {
   private EmployeeDao() {}

   public static EmployeeDao getEmployeeDao() {
       logger.info("Working....................");
       return employeeDao;
   }

    private static EmployeeDao employeeDao = new EmployeeDao();

    private final static Logger logger = Logger.getLogger(EmployeeDao.class.getName());

   public static SessionFactory sessionFactory = new Configuration().configure("/com/kickhibernate/curd/startwithxml/hibernate.hbm.xml")
            .buildSessionFactory();

   public Long create(Employee employee) {
       // Create Session
       Session session = sessionFactory.openSession();
       logger.info("Session open");
       try {
           // Start Transaction
           session.beginTransaction();

           // Persist employee
           Long id= (Long)session.save(employee);

           // Commit transaction
           session.getTransaction().commit();
           logger.log(Level.INFO,"Successfully saved employee with id: {0}", id);
           return id;

       } finally {
           // Close session
           session.close();
           logger.info("Session close");
       }
   }

    public void update(Employee employee) {
        // Create Session
        Session session = sessionFactory.openSession();
        logger.info("Session open");
        try {
            // Start Transaction
            session.beginTransaction();

            // Update employee
             session.update(employee);

            // Commit transaction
            session.getTransaction().commit();
            logger.log(Level.INFO,"Successfully updated employee with id: {0}", employee.getId());
        } finally {
            // Close session
            session.close();
            logger.info("Session close");
        }
    }

    public void delete(Employee employee) {
        // Create Session
        Session session = sessionFactory.openSession();
        logger.info("Session open");
        try {
            // Start Transaction
            session.beginTransaction();

            // Update employee
            session.delete(employee);

            // Commit transaction
            session.getTransaction().commit();
            logger.log(Level.INFO,"Successfully delted employee with id: {0}", employee.getId());
        } finally {
            // Close session
            session.close();
            logger.info("Session close");
        }
    }

    public Employee get(Long id) {
        // Create Session
        Session session = sessionFactory.openSession();
        logger.info("Session open");
        try {
            // Start Transaction
            session.beginTransaction();

            // Get employee
            Employee employee = session.get(Employee.class, id);

            // Commit transaction
            session.getTransaction().commit();
            System.out.println(employee);
            if (employee != null) {
                logger.log(Level.INFO, "Successfully get employee with id: {0}", employee.getId());
            }
            return employee;
        } finally {
            // Close session
            session.close();
            logger.info("Session close");
        }
    }
}
