package com.kickwithhibernate.generatorclassesinhibernate.increment;

import java.util.Random;

import com.kickwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 8/3/17.
 */
public class IncrementTest {
    public static void main(String[] args) {
        createIncrement();
       HibernateUtil.shutdown();

    }

    private static void createIncrement() {
        BaseDAO<IncrementGenerator, Long> baseDAO = new BaseDAO<IncrementGenerator, Long>();
        for (int i = 0; i < 5; i++) {
            IncrementGenerator incrementGenerator = new IncrementGenerator();
            incrementGenerator.setName(String.format("t1%s", new Random().nextInt(10)));
            baseDAO.save(incrementGenerator);
        }
    }
}
