package com.kickwithhibernate.generatorclassesinhibernate.guid;

import com.kickwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 9/3/17.
 */
public class GuidTest {
    public static void main(String[] args) {
        createData();
        HibernateUtil.shutdown();
    }

    private static void createData() {
        BaseDAO<Guid, String> baseDAO = new BaseDAO<Guid, String>();
        for (int i = 0; i < 5; i++) {
            baseDAO.save(new Guid());
        }
    }
}
