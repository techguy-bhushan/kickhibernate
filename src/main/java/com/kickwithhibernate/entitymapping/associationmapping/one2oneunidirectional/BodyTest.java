package com.kickwithhibernate.entitymapping.associationmapping.one2oneunidirectional;


import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Created by bhushan on 21/3/17.
 */
public class BodyTest {
    public static void main(String[] args) {
        createData();
        HibernateUtil.shutdown();
    }

    private static void createData() {
        Session session =  HibernateUtil.getSession();
        session.beginTransaction();

        Heart heart = new Heart();
        heart.setHeartBeatSpeed(72);
        session.save(heart);

        Body body = new Body();
        body.setBodyTemperature(95);
        body.setHeart(heart);
        session.save(body);

        session.getTransaction().commit();
        session.close();
    }

}

/*
mysql> select * from Body;
+----+-----------------+----------+
| id | bodyTemperature | heart_id |
+----+-----------------+----------+
|  1 |              95 |        1 |
+----+-----------------+----------+
1 row in set (0.00 sec)

mysql> select * from Heart;
+----+----------------+
| id | heartBeatSpeed |
+----+----------------+
|  1 |             72 |
+----+----------------+
1 row in set (0.00 sec)

* */
