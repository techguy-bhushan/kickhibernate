package com.kickwithhibernate.generatorclassesinhibernate.sequence;


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
        BaseDAO<SequenceGenerator, String> baseDAO = new BaseDAO<SequenceGenerator, String>();
        for (int i = 0; i < 5; i++) {
            baseDAO.save(new SequenceGenerator());
        }
    }
}
