package com.kickoffwithhibernate.startwithannotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

/**
 * Created by bhushan on 8/3/17.
 *
 */
public class BasicKickWithHibernateAnnotation {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Address address = new Address();
        address.setPhoneNumber("78956145896");
        address.setPostalCode("456789");
        address.setStreet1("test");
        address.setStreet2("test ok");
        Employee employee = new Employee();
        employee.setFirstName("Bhushan");
        employee.setLastName("Uniyal");
        employee.setAddress(address);
        employee.setPassword("123456");
        employee.setConfirmPassword("123456");
        session.save(employee);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
