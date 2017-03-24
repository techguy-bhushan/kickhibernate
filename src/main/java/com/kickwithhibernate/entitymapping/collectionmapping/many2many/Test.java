package com.kickwithhibernate.entitymapping.collectionmapping.many2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

/**
 * Created by bhushan on 24/3/17.
 */
public class Test {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
           transaction = session.beginTransaction();

            Course course = new Course();
            course.setSubjectName("Math");

            Course course1 = new Course();
            course1.setSubjectName("Physic");

            Set<Student> students = new HashSet<Student>();
            Student student1 = new Student();
            student1.setName("Test");
            session.save(student1);

            students.add(student1);

            course.setStudents(students);
            course1.setStudents(students);

            session.save(course1);
            session.save(course);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }

    /*
    * mysql> select * from Course;
+----+-------------+
| id | subjectName |
+----+-------------+
|  1 | Physic      |
|  2 | Math        |
+----+-------------+
2 rows in set (0.00 sec)

mysql> select * from Student;
+----+------+
| id | name |
+----+------+
|  1 | Test |
+----+------+
1 row in set (0.00 sec)

mysql> select * from Course_Student;
+------------+-------------+
| courses_id | students_id |
+------------+-------------+
|          1 |           1 |
|          2 |           1 |
+------------+-------------+
2 rows in set (0.00 sec)

    * */
}
