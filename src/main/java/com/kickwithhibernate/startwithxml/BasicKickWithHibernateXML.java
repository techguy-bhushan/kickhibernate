package com.kickwithhibernate.startwithxml;


import org.hibernate.Session;

import util.HibernateUtil;

/**
 *sCreated by bhushan on 19/2/17.
 *Here basic kick off with hibernate,
 *Mapping Employee table in employee.hbm.xml
 */
public class BasicKickWithHibernateXML {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        /*
        *The transaction object specifies the atomic unit of work.
        * It is optional.
        * The org.hibernate.Transaction interface provides methods for transaction management.
        */
        session.beginTransaction();
        Employee employee = new Employee();
        employee.setFirstName("jhon");
        employee.setLasttName("doe");
        session.save(employee);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
