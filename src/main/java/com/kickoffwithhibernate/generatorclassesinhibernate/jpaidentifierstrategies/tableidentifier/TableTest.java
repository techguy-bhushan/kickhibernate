package com.kickoffwithhibernate.generatorclassesinhibernate.jpaidentifierstrategies.tableidentifier;

import org.hibernate.Session;

import com.kickoffwithhibernate.dao.BaseDAO;
import com.kickoffwithhibernate.generatorclassesinhibernate.nativegenerator.NativeGenerator;
import util.HibernateUtil;

/**
 * Created by bhushan on 9/3/17.
 */
public class TableTest {
    public static void main(String[] args) {
        createData();
        HibernateUtil.shutdown();

    }

    private static void createData() {
        BaseDAO<Table, Long> baseDAO = new BaseDAO<Table, Long>();
        for (int i = 0; i < 5; i++) {
            baseDAO.save(new Table());
        }
    }
}
