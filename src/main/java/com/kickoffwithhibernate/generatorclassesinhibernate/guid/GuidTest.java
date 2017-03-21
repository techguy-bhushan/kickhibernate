package com.kickoffwithhibernate.generatorclassesinhibernate.guid;

import org.hibernate.Session;

import com.kickoffwithhibernate.dao.BaseDAO;
import com.kickoffwithhibernate.generatorclassesinhibernate.customgenerator.Custom;
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
