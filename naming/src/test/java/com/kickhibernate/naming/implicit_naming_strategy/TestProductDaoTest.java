package com.kickhibernate.naming.implicit_naming_strategy;

import com.kickhibernate.naming.HbmUtil;
import com.kickhibernate.naming.Product;
import com.kickhibernate.naming.ProductDao;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestProductDaoTest {

    private static ProductDao productDao;
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void init() {
        sessionFactory = HbmUtil.getSessionFactory("hibernate.implicit_naming_strategy","org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl", Product.class);
        productDao = new ProductDao(sessionFactory);
    }

    @Test
    public void saveProduct() {
        Product product = new Product();
        product.setId(1);
        product.setPrice(10.2);
        product.setProductName("phone");
        int id = productDao.save(product);
        System.out.println("Saved with id");

    }

    @AfterClass
    public static void destroy() {
        sessionFactory.close();
    }

    /*
    * Datebase  table structure for Product
 +-------------+--------------+------+-----+---------+-------+
| Field       | Type         | Null | Key | Default | Extra |
+-------------+--------------+------+-----+---------+-------+
| id          | int(11)      | NO   | PRI | NULL    |       |
| price       | double       | NO   |     | NULL    |       |
| productName | varchar(255) | YES  |     | NULL    |       |
+-------------+--------------+------+-----+---------+-------+

    * */
}