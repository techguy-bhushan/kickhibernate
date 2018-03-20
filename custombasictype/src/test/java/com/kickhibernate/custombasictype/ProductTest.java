package com.kickhibernate.custombasictype;

import com.util.BaseDAO;
import org.hamcrest.core.Is;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.assertThat;

public class ProductTest {
    private static BaseDAO<Product, Integer> productDao;
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void init() {
        sessionFactory = Hbm.getSessionFactory(Product.class);
        productDao = new BaseDAO<>(sessionFactory);
    }

    @Test
    public void saveProduct() {
        BitSet bitSet = BitSet.valueOf( new long[] {1, 2, 3} );
        Product instance = new Product();
        instance.setId(1);
        instance.setBitSet(bitSet);
        productDao.save(instance);

        Product product = productDao.findById(Product.class,1);

        assertThat(product.getId(), Is.is(1));
        assertThat(product.getBitSet().size(), Is.is(bitSet.size()));
    }

    @AfterClass
    public static void destroy() {
        sessionFactory.close();
    }

    /*bitSet will save as a varchar
    desc Product;

* +--------+--------------+------+-----+---------+-------+
| Field  | Type         | Null | Key | Default | Extra |
+--------+--------------+------+-----+---------+-------+
| id     | int(11)      | NO   | PRI | NULL    |       |
| bitSet | varchar(255) | YES  |     | NULL    |       |
+--------+--------------+------+-----+---------+-------+


mysql> select * from Product;
+----+---------+
| id | bitSet  |
+----+---------+
|  1 | 1,10,11 |
+----+---------+

    * */
}
