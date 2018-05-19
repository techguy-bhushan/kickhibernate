package com.kickhibernate.onetoone.unidirectinal;

import com.kickhibernate.dao.BaseDao;
import com.kickhibernate.onetoone.undirection.CellPhone;
import com.kickhibernate.onetoone.undirection.CellPhoneDetail;
import com.kickhibernate.onetoone.undirection.CellPhoneType;
import com.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class OneToOneRelationTest {

    private static BaseDao baseDao;
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void init() {
        sessionFactory = HibernateUtil.getSessionFactory(CellPhone.class, CellPhoneDetail.class);
        baseDao = new BaseDao(sessionFactory);
    }

    @Test
    public void testRelation() {
        CellPhoneDetail cellPhoneDetail =  new CellPhoneDetail();
        cellPhoneDetail.setCellPhoneType(CellPhoneType.LAND_LINE);
        cellPhoneDetail.setDescription("basic description");

        baseDao.save(cellPhoneDetail);

        CellPhone cellPhone = new CellPhone();
        cellPhone.setName("NXD");
        cellPhone.setCellPhoneDetail(cellPhoneDetail);

        Long cellPhoneID = baseDao.save(cellPhone);

        Assert.assertNotNull(cellPhone);

        CellPhone instance = baseDao.getCellPhone(cellPhoneID);

        System.out.println(instance);

        Assert.assertNotNull(instance);
        Assert.assertTrue(instance.getCellPhoneDetail().getId() != null);
    }

    @AfterClass
    public static void destroy() {
        sessionFactory.close();
    }
}
