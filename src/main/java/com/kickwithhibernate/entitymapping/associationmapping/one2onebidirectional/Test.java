package com.kickwithhibernate.entitymapping.associationmapping.one2onebidirectional;

import com.kickwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 24/3/17.
 */
public class Test {
    public static void main(String[] args) {
        createData();
        HibernateUtil.shutdown();
    }

    private static void createData() {
        BaseDAO baseDAO = new BaseDAO();

        Profile profile = new Profile();
        profile.setPhoneNumber("777777777777");
        profile.setStreet2("delhi6");
        profile.setStreet1("15 roy");

        User user = new User();
        user.setUserName("test");
        user.setProfile(profile);

        baseDAO.save(user);

    }

    /*
    * mysql> select * from User;
+----+----------+------------+
| id | userName | profile_id |
+----+----------+------------+
|  1 | test     |          1 |
+----+----------+------------+
1 row in set (0.00 sec)

mysql> select * from Profile;
+----+--------------+---------+---------+
| id | phoneNumber  | street1 | street2 |
+----+--------------+---------+---------+
|  1 | 777777777777 | 15 roy  | delhi6  |
+----+--------------+---------+---------+
1 row in set (0.00 sec)

    * */
}
