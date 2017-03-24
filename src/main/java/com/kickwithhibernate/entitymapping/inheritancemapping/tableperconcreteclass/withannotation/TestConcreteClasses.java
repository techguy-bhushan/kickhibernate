package com.kickwithhibernate.entitymapping.inheritancemapping.tableperconcreteclass.withannotation;


import java.util.Date;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Created by bhushan on 12/3/17.
 */
public class TestConcreteClasses {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.setAmount(52.6);
        createData(payment);

        CreditCard creditCard = new CreditCard();
        creditCard.setAmount(10);
        creditCard.setCcNumber("2536985474561236");
        creditCard.setExpireDate(new Date());
        createData(creditCard);

        ACH ach = new ACH();
        ach.setAccountName("abc");
        ach.setBank_name("xyz");
        ach.setAmount(14);

        createData(ach);

        HibernateUtil.shutdown();

    }

    private static void createData(Payment instance) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(instance);
        session.getTransaction().commit();
    }
/*
mysql> select * from Payment;
+----+--------+
| id | amount |
+----+--------+
|  1 |   52.6 |
+----+--------+
1 row in set (0.00 sec)

 select * from CreditCard;
+----+--------+------------------+---------------------+
| id | amount | ccNumber         | expireDate          |
+----+--------+------------------+---------------------+
|  2 |     10 | 2536985474561236 | 2017-03-12 14:10:15 |
+----+--------+------------------+---------------------+
1 row in set (0.00 sec)

mysql> select * from ACH;
+----+--------+-------------+-----------+
| id | amount | accountName | bank_name |
+----+--------+-------------+-----------+
|  3 |     14 | abc         | xyz       |
+----+--------+-------------+-----------+
1 row in set (0.00 sec)
*/

}
