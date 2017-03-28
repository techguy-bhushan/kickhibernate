package com.kickwithhibernate.hibernatenamedquery;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.kickwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 28/3/17.
 */
public class TestNameQuery {
    public static void main(String[] args) {
        OS linux = new OS();
        linux.setOsName("LINUX");

        OS window = new OS();
        window.setOsName("WINDOWS");

        BaseDAO baseDAO = new BaseDAO();
        baseDAO.save(linux);
        baseDAO.save(window);

        Session session = HibernateUtil.getSession();
        Query query = session.getNamedQuery("listOfOS");
        List<OS> oses = query.list();
        session.close();

        System.out.println("Size of Oses :"+oses.size());
        HibernateUtil.shutdown();
    }
}
