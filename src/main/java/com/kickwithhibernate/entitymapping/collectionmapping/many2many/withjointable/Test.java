package com.kickwithhibernate.entitymapping.collectionmapping.many2many.withjointable;

import java.util.HashSet;
import java.util.Set;

import com.kickwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 1/4/17.
 */
public class Test {
    public static void main(String[] args) {
      Artist artist = new Artist();
        artist.setName("asd");
        artist.setDescription("sssss");

        Artist artist1 = new Artist();
        artist1.setName("1");
        artist1.setDescription("1");

        Event event = new Event();
        event.setDescription("ccd1");
        event.setName("dcddd1");

        Event event1 = new Event();
        event1.setDescription("ccd");
        event1.setName("dcddd");

        Set<Artist> events = new HashSet<Artist>();
        events.add(artist);
        events.add(artist1);

        event.setArtists(events);
        BaseDAO baseDAO = new BaseDAO();
        baseDAO.save(event);
        baseDAO.save(event1);
        HibernateUtil.shutdown();

    }
}
