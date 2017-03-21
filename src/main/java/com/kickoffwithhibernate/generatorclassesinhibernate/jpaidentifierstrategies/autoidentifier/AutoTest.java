package com.kickoffwithhibernate.generatorclassesinhibernate.jpaidentifierstrategies.autoidentifier;

import com.kickoffwithhibernate.dao.BaseDAO;
import com.kickoffwithhibernate.generatorclassesinhibernate.increment.IncrementGenerator;
import util.HibernateUtil;

/**
 * Created by bhushan on 9/3/17.
 */
public class AutoTest {
    public static void main(String[] args) {
        createAutoData();
        HibernateUtil.shutdown();

    }

    private static void createAutoData() {
        BaseDAO<Auto, Long> baseDAO = new BaseDAO<Auto, Long>();
        for (int i = 0; i < 5; i++) {
            baseDAO.save(new Auto());
        }
    }
}
