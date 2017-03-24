package com.kickwithhibernate.entitymapping.inheritancemapping.tablepersubclass.withannotation;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Created by bhushan on 12/3/17.
 */
public class TestPerSubClasses {
    public static void main(String[] args) {
        RegularEmployee regularEmployee = new RegularEmployee();
        regularEmployee.setName("abc");
        regularEmployee.setSalaryPerMonth(50005);
        createData(regularEmployee);

        ContractEmployee contractEmployee = new ContractEmployee();
        contractEmployee.setName("rst");
        contractEmployee.setContractDuration("1 yr");
        contractEmployee.setSalaryPerHour(1000);
        createData(contractEmployee);

        HibernateUtil.shutdown();

    }

    private static void createData(Employee instance) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(instance);
        session.getTransaction().commit();
    }

    /*
mysql> select * from emp_1;
+----+------+
| id | name |
+----+------+
|  1 | abc  |
|  2 | rst  |
+----+------+
2 rows in set (0.00 sec)

mysql> select * from reg_emp;
+----------------+-----+
| salaryPerMonth | eid |
+----------------+-----+
|          50005 |   1 |
+----------------+-----+
1 row in set (0.00 sec)

mysql> select * from con_emp;
+------------------+---------------+----+
| contractDuration | salaryPerHour | id |
+------------------+---------------+----+
| 1 yr             |          1000 |  2 |
+------------------+---------------+----+
1 row in set (0.00 sec)
    * */
}
