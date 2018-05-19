package com.kickhibernate.manytoone.bidirectional;

import com.kickhibernate.dao.BaseDao;
import com.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class TestBidirectionalRelation {
    private static BaseDao baseDao;
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void init() {
        sessionFactory = HibernateUtil.getSessionFactory(Order.class, Item.class);
        baseDao = new BaseDao(sessionFactory);
    }

    @Test
    public void testRelation() {
        Item item = new Item();
        item.setBigDecimal(new BigDecimal(10.50));
        item.setName("pen");

        Item item2 = new Item();
        item2.setBigDecimal(new BigDecimal(5.99));
        item2.setName("pencil");

        Order order = new Order();
        order.setCreatedDate(new Date());
        order.setUpdateDate(new Date());
        order.addItem(item);
        order.addItem(item2);

        item.setOrder(order);
        item2.setOrder(order);

        baseDao.save(order);


       Assert.assertNotNull(order.getId());
       Assert.assertNotNull(order.getItems().get(0).getId());
       Assert.assertNotNull(order.getItems().get(1).getId());
    }

    @AfterClass
    public static void destroy() {
        sessionFactory.close();
    }
}
