package com.kickwithhibernate.generatorclassesinhibernate.jpaidentifierstrategies.autoidentifier;

import com.kickwithhibernate.dao.BaseDAO;
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
