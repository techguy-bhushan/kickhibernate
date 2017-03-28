package com.kickwithhibernate.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.kickwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 28/3/17.
 */
public class HqlTest {
    BaseDAO<School, Long> schoolDao = new BaseDAO<School, Long>();
    BaseDAO<Teacher, Long> teacherDao = new BaseDAO<Teacher, Long>();

    public static void main(String[] args) {
        HqlTest hqlTest = new HqlTest();
        hqlTest.createDummyData();

        // test list()
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from School");
        List<School> schools = query.list();
        System.out.println("Current Exits number of school :"+schools.size());

        // test executeUpdate() -> delete school with id 1
        Query deleteQuery = session.createQuery("delete from Teacher where id=1");
        deleteQuery.executeUpdate();

        // Validate executeUpdate
        Query teacherListQuery = session.createQuery("from Teacher ");
        List<Teacher> teachers = teacherListQuery.list();
        System.out.println("Current exits number of teachers :"+teachers.size());

        Query firstResultQuery=session.createQuery("from School");
        firstResultQuery.setFirstResult(1);
        firstResultQuery.list();
        System.out.println("Get first result of school :"+query.list().size());

        Query parameterQuery=session.createQuery("from School where name=:name");
        parameterQuery.setParameter("name", "DAV");
        schools = parameterQuery.list();
        System.out.println("Number of schools which have name DAV :"+schools.size());

        session.close();
        HibernateUtil.shutdown();

    }

    private void createDummyData() {
        School school = new School();
        school.setName("DAV");
        school = (School) schoolDao.save(school);

        Teacher teacher = new Teacher();
        teacher.setName("Jimmy");
        teacher.setSchool(school);
        teacherDao.save(teacher);

        Teacher teacher1 = new Teacher();
        teacher1.setName("Rahul");
        teacher1.setSchool(school);
        teacherDao.save(teacher1);

        Teacher teacher2 = new Teacher();
        teacher2.setName("Ankit");
        teacher2.setSchool(school);
        teacherDao.save(teacher2);
    }
}
