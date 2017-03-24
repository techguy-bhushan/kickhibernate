package com.kickwithhibernate.entitymapping.associationmapping.many2one;

import com.kickwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 24/3/17.
 */
public class Test {
    public static void main(String[] args) {
        createData();
        HibernateUtil.shutdown();
    }

    private static void createData() {
        BaseDAO baseDAO = new BaseDAO();

        Department hr = new Department();
        hr.setDepName("HR");
        baseDAO.save(hr);

        Emp emp = new Emp();
        emp.setEmpCode(1425);
        emp.setDepartment(hr);
        baseDAO.save(emp);

        Emp emp2 = new Emp();
        emp2.setEmpCode(1456);
        emp2.setDepartment(hr);
        baseDAO.save(emp2);

    }


    /*
    * mysql> select * from Department;
+----+---------+
| id | depName |
+----+---------+
|  1 | HR      |
+----+---------+
1 row in set (0.00 sec)

mysql> select * from Emp;
+----+---------+---------------+
| id | empCode | department_id |
+----+---------+---------------+
|  1 |    1425 |             1 |
|  2 |    1456 |             1 |
+----+---------+---------------+
2 rows in set (0.00 sec)

    * */
}
