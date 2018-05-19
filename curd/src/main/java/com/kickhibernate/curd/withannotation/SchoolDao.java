package com.kickhibernate.curd.withannotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SchoolDao {
    private static SchoolDao schoolDao = new SchoolDao();;
    private SchoolDao() {
    }

    private final static Logger logger = Logger.getLogger(SchoolDao.class.getName());

    public static SchoolDao getSchoolDao()  {
        return schoolDao;
    }

    private static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "root");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/kickhibernate");
        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.show_sql", true);
        SessionFactory sessionFactory = new Configuration().addProperties(properties)
                .addAnnotatedClass(School.class).buildSessionFactory();
        return sessionFactory;
    }
    public static SessionFactory sessionFactory = getSessionFactory();

    public Long create(School school) {
        // Create Session
        Session session = sessionFactory.openSession();
        logger.info("Session open");
        try {
            // Start Transaction
            session.beginTransaction();

            // Persist school
            Long id= (Long)session.save(school);

            // Commit transaction
            session.getTransaction().commit();
            logger.log(Level.INFO,"Successfully saved school with id: {0}", id);
            return id;

        } finally {
            // Close session
            session.close();
            logger.info("Session close");
        }
    }

    public void update(School school) {
        // Create Session
        Session session = sessionFactory.openSession();
        logger.info("Session open");
        try {
            // Start Transaction
            session.beginTransaction();

            // Update school
            session.update(school);

            // Commit transaction
            session.getTransaction().commit();
            logger.log(Level.INFO,"Successfully updated school with id: {0}", school.getId());
        } finally {
            // Close session
            session.close();
            logger.info("Session close");
        }
    }

    public void delete(School school) {
        // Create Session
        Session session = sessionFactory.openSession();
        logger.info("Session open");
        try {
            // Start Transaction
            session.beginTransaction();

            // Update school
            session.delete(school);

            // Commit transaction
            session.getTransaction().commit();
            logger.log(Level.INFO,"Successfully delted school with id: {0}", school.getId());
        } finally {
            // Close session
            session.close();
            logger.info("Session close");
        }
    }

    public School get(Long id) {
        // Create Session
        Session session = sessionFactory.openSession();
        logger.info("Session open");
        try {
            // Start Transaction
            session.beginTransaction();

            // Get school
            School school = session.get(School.class, id);

            // Commit transaction
            session.getTransaction().commit();
            System.out.println(school);
            if (school != null) {
                logger.log(Level.INFO, "Successfully get school with id: {0}", school.getId());
            }
            return school;
        } finally {
            // Close session
            session.close();
            logger.info("Session close");
        }
    }
}
