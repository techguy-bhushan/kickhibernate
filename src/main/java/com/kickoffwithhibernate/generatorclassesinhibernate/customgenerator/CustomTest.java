package com.kickoffwithhibernate.generatorclassesinhibernate.customgenerator;

import org.hibernate.Session;

import com.kickoffwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 9/3/17.
 */
public class CustomTest {
    public static void main(String[] args) {
        createData();
        HibernateUtil.shutdown();
    }

    private static void createData() {
      BaseDAO<Custom, String> baseDAO = new BaseDAO<Custom, String>();
        for (int i = 0; i < 5; i++) {
            baseDAO.save(new Custom());
        }
    }
}
