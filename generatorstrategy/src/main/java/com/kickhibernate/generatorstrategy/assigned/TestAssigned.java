package com.kickhibernate.generatorstrategy.assigned;

import com.kickhibernate.generatorstrategy.BasicDaoTemplate;
import com.kickhibernate.generatorstrategy.Utils;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by bhushan on 8/3/17.
 *Here we are creating the Assigned object and assigning the id's.
 * If id will same of multiple objects then it will throw org.hibernate.NonUniqueObjectException.
 * So please take care of it if you are using assigned generated strategy.
 */
public class TestAssigned {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().addProperties(Utils.getProperties())
                .addAnnotatedClass(User.class).buildSessionFactory();
        BasicDaoTemplate<User, Long> basicDaoTemplate = UserDao.getUserDao();
        basicDaoTemplate.setSessionFactory(sessionFactory);
        try {
            User user = new User();
            user.setId(1l);
            user.setName("2");
        }finally {

        }

    }
}
