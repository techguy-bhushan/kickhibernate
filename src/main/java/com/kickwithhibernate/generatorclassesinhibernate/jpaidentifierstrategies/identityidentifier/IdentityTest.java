package com.kickwithhibernate.generatorclassesinhibernate.jpaidentifierstrategies.identityidentifier;

import java.io.Serializable;

import com.kickwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 9/3/17.
 */
public class IdentityTest implements Serializable{
    private static final long serialVersionUID = 4194136612017585794L;

    public static void main(String[] args) {
        createData();
        HibernateUtil.shutdown();

    }

    private static void createData() {
        BaseDAO<Identity, Long> baseDAO = new BaseDAO<Identity, Long>();
        for (int i = 0; i < 5; i++) {
            baseDAO.save(new Identity());
        }
    }
}
