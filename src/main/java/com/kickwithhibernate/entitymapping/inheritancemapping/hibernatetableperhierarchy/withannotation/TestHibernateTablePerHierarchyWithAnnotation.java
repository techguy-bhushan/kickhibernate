package com.kickwithhibernate.entitymapping.inheritancemapping.hibernatetableperhierarchy.withannotation;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Created by bhushan on 11/3/17.
 */
public class TestHibernateTablePerHierarchyWithAnnotation {
    public static void main(String[] args) {
        Notification notification = new Notification();
        notification.setContent("hello ping");
        createData(notification);
        Email email = new Email();
        email.setEmailAddress("a@b.com");
        email.setContent("test data");
        createData(email);
        Message message = new Message();
        message.setContent("message");
        message.setMobileNumber("9632587412");
        createData(message);
        HibernateUtil.shutdown();
    }

    private static void createData(Notification instance) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(instance);
        session.getTransaction().commit();
    }

/*    mysql> select * from Notification;
            +--------------+----+------------+--------------+--------------+
            | type         | id | content    | emailAddress | mobileNumber |
            +--------------+----+------------+--------------+--------------+
            | notification |  1 | hello ping | NULL         | NULL         |
            | email        |  2 | test data  | a@b.com      | NULL         |
            | msg          |  3 | message    | NULL         | 9632587412   |
            +--------------+----+------------+--------------+--------------+*/

}
