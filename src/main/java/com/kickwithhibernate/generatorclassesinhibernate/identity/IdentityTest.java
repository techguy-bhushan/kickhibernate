package com.kickwithhibernate.generatorclassesinhibernate.identity;

import com.kickwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 9/3/17.
 */
public class IdentityTest {
    public static void main(String[] args) {
        createData();
        HibernateUtil.shutdown();

    }

    private static void createData() {
        BaseDAO<IdentityGenerator, String> baseDAO = new BaseDAO<IdentityGenerator, String>();
        for (int i = 0; i < 5; i++) {
            baseDAO.save(new IdentityGenerator());
        }
    }
}
