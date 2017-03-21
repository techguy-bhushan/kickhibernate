package com.kickoffwithhibernate.generatorclassesinhibernate.hilo;

import com.kickoffwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 9/3/17.
 */
public class HiloTest {
    public static void main(String[] args) {
        createData();
        HibernateUtil.shutdown();
    }

    private static void createData() {
        BaseDAO<Hilo, Long> baseDAO = new BaseDAO<Hilo, Long>();
        for (int i = 0; i < 5; i++) {
            baseDAO.save(new Hilo());
        }
    }
}
