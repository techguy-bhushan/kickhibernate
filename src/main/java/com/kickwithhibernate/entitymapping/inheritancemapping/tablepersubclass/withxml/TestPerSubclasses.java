package com.kickwithhibernate.entitymapping.inheritancemapping.tablepersubclass.withxml;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Created by bhushan on 12/3/17.
 */
public class TestPerSubclasses {
    public static void main(String[] args) {
        RegularEmployee regularEmployee = new RegularEmployee();
        regularEmployee.setName("abc");
        regularEmployee.setSalaryPerMonth(35000);
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
mysql> select * from emp_;
+----+------+
| id | name |
+----+------+
|  1 | abc  |
|  2 | rst  |
+----+------+
2 rows in set (0.00 sec)

mysql> select * from regular_employees;
+-------+----------------+
| empId | salaryPerMonth |
+-------+----------------+
|     1 |          35000 |
+-------+----------------+
1 row in set (0.00 sec)

mysql> select * from contract_eployees;
+-------+------------------+---------------+
| empId | contractDuration | salaryPerHour |
+-------+------------------+---------------+
|     2 | 1 yr             |          1000 |
+-------+------------------+---------------+
1 row in set (0.00 sec)
*/
}
