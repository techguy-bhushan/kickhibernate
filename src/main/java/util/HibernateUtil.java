package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by bhushan on 19/2/17.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    /*
     *The SessionFactory is a factory of session and client of ConnectionProvider.
     *It holds second level cache (optional) of data. The org.hibernate.SessionFactory interface provides factory method to get the object of Session.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /*
    *The session object provides an interface between the application and data stored in the database.
    * It is a short-lived object and wraps the JDBC connection. It is factory of Transaction, Query and Criteria.
    * It holds a first-level cache (mandatory) of data. The org.hibernate.Session interface provides methods to insert, update and delete the object.
    * It also provides factory methods for Transaction, Query and Criteria.
    */
    public static Session getSession() {

        return sessionFactory.openSession();
    }

    public static Session getCurrentSession() {

        return sessionFactory.getCurrentSession();
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }


}
