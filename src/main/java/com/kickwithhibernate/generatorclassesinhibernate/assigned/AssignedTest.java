package com.kickwithhibernate.generatorclassesinhibernate.assigned;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Created by bhushan on 8/3/17.
 *Here we are creating the Assigned object and assigning the id's.
 * If id will same of multiple objects then it will throw org.hibernate.NonUniqueObjectException.
 * So please take care of it if you are using assigned generated strategy.
 */
public class AssignedTest {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Assigned assigned = new Assigned();
        //here we are assigning id.
        assigned.setId(1);
        session.save(assigned);
        Assigned assigned1 = new Assigned();
        assigned1.setId(20);
        session.save(assigned1);
        session.getTransaction().commit();
        HibernateUtil.shutdown();

    }
}
