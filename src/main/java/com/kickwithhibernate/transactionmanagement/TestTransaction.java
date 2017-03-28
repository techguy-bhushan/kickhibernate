package com.kickwithhibernate.transactionmanagement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

/**
 * Created by bhushan on 28/3/17.
 */
public class TestTransaction {
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.setBrandName("CH#4");

        Car car = new Car();
        car.setModelNumber("PH560");

        Car car1 = new Car();
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {

            session.save(engine);
            session.save(car);
            transaction.commit();
            session.close();
            System.out.println(""+transaction.isActive());

            System.out.println("Is this transaction still active? :"+transaction.isActive());
            System.out.println("Is Hibernate participating in the underlying transaction? :"+transaction.isParticipating());
            System.out.println("Was this transaction committed? : "+transaction.wasCommitted());
            System.out.println("Was this transaction rolled back or set to rollback only? :"+transaction.wasRolledBack());
            System.out.println("Retrieve the transaction timeout set for this transaction.  A negative indicates no timeout has been set. :"+transaction.getTimeout());
            System.out.println("Is this transaction the initiator of any underlying transaction? :"+transaction.isInitiator());
        } catch (HibernateException e) {
            System.out.println("exception occur during commit:"+e);
            transaction.rollback();
        }
        HibernateUtil.shutdown();
    }
}
