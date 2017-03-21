package com.kickwithhibernate.entitymapping.collectionmapping.one2many.another;

import java.util.Date;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Created by bhushan on 19/3/17.
 */
public class Test {
    public static void main(String[] args) {
        Node node = new Node();
        node.setUpdateDate(new Date());
        NodeRecord nodeRecord = new NodeRecord();
        nodeRecord.setNode(node);
        nodeRecord.setCreatedDate(new Date());
        NodeRecord nodeRecord1 = new NodeRecord();
        nodeRecord1.setNode(node);
        nodeRecord1.setCreatedDate(new Date(new Date().getTime() - (10 * 24 * 60 * 60 * 1000)) );
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(node);
        session.save(nodeRecord);
        session.save(nodeRecord1);
        session.getTransaction().commit();
        //session.close();
        // fetch data
        Query query = session.createQuery("from Node as n join n.nodeRecords as nr where date(nr.createdDate) = date(n.updateDate)");
        List<Node> albumList = query.list();
        session.close();
    }


}
