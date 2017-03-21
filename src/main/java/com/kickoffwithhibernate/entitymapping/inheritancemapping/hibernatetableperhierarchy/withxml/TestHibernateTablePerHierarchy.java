package com.kickoffwithhibernate.entitymapping.inheritancemapping.hibernatetableperhierarchy.withxml;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Created by bhushan on 11/3/17.
 */
public class TestHibernateTablePerHierarchy {
    public static void main(String[] args) {
        createData(new Parent());
        Child1 child1 = new Child1();
        child1.setFirstName("jhon");
        child1.setLastName("Doe");
        createData(child1);
        Child2 child2 = new Child2();
        child2.setName("tesy");
        createData(child2);
        HibernateUtil.shutdown();
    }

    private static void createData(Parent instance) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(instance);
        session.getTransaction().commit();
    }
/*
    mysql> select * from Parent;
            +----+--------+-----------+----------+------+
            | id | type   | firstName | lastName | name |
            +----+--------+-----------+----------+------+
            |  1 | Parent | NULL      | NULL     | NULL |
            |  2 | Child1 | jhon      | Doe      | NULL |
            |  3 | Child2 | NULL      | NULL     | tesy |
            +----+--------+-----------+----------+------+
            3 rows in set (0.00 sec)*/

}
