package com.kickwithhibernate.generatorclassesinhibernate.jpaidentifierstrategies.sequenceidentifier;

import com.kickwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 9/3/17.
 */
public class SequenceTest {
    public static void main(String[] args) {
        createData();
        HibernateUtil.shutdown();

    }

    private static void createData() {
        BaseDAO<Sequence, Long> baseDAO = new BaseDAO<Sequence, Long>();
        for (int i = 0; i < 5; i++) {
            baseDAO.save(new Sequence());
        }
    }
}
