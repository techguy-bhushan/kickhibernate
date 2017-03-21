package com.kickwithhibernate.generatorclassesinhibernate.uuid;

import com.kickwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 9/3/17.
 */
public class UuidTest {
    public static void main(String[] args) {
        createData();
        HibernateUtil.shutdown();
    }

    private static void createData() {
        BaseDAO<UuidGenerator, String> baseDAO = new BaseDAO<UuidGenerator, String>();

        for (int i = 0; i < 5; i++) {
           baseDAO.save(new UuidGenerator());
        }
    }
}
