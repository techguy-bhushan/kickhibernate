package com.kickwithhibernate.cache;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;

import com.kickwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 31/3/17.
 */
public class TestCache {
    public static void main(String[] args) {
        BaseDAO<GameLevel, Long> baseDAO = new BaseDAO<GameLevel, Long>();
        GameLevel gameLevel = new GameLevel();
        gameLevel.setLevel("Man in middle");

        GameLevel gameLevel1 = new GameLevel();
        gameLevel1.setLevel("Man in middle Part 2");

        GameLevel gameLevel2 = new GameLevel();
        gameLevel2.setLevel("Man in middle Part 2");

        GameLevel gameLevel3 = new GameLevel();
        gameLevel3.setLevel("Man in middle Part 3");

        GameLevel gameLevel4 = new GameLevel();
        gameLevel4.setLevel("Man in middle Part 4");

        baseDAO.save(gameLevel);
        baseDAO.save(gameLevel1);
        baseDAO.save(gameLevel2);
        baseDAO.save(gameLevel3);
        baseDAO.save(gameLevel4);

        Statistics stats = HibernateUtil.getSessionFactory().getStatistics();
        stats.setStatisticsEnabled(true);

        Session session = HibernateUtil.getSession();
        GameLevel g = (GameLevel)session.load(GameLevel.class, 1);
        System.out.println("get game level: "+g.getLevel());
        System.out.println("Second Level Put Count=" + stats.getSecondLevelCacheStatistics("com.kickwithhibernate.cache.GameLevel"));
        System.out.println("---------------------------\n\n");
        session.close();

        Session newSession = HibernateUtil.getSession();
        GameLevel g1 = (GameLevel) newSession.load(GameLevel.class, 1);
        System.out.println("get game level: "+g1.getLevel());
        System.out.println("Second Level Put Count=" + stats.getSecondLevelCacheStatistics("com.kickwithhibernate.cache.GameLevel"));
        System.out.println("---------------------------\n\n");
        newSession.close();


        Session session1 = HibernateUtil.getSession();
        Query query = session1.createQuery("from GameLevel");
        query.setCacheable(true);
        System.out.println("Total number of Game level: "+query.list().size());
        System.out.println("Second Level Put Count=" + stats.getSecondLevelCacheStatistics("com.kickwithhibernate.cache.GameLevel"));
        System.out.println("---------------------------\n\n");
        session1.close();

        Session session2 = HibernateUtil.getSession();
        Query query1 = session2.createQuery("from GameLevel");
        query1.setCacheable(true);
        System.out.println("Total number of Game level: "+query1.list().size());
        System.out.println("Second Level Put Count=" + stats.getSecondLevelCacheStatistics("com.kickwithhibernate.cache.GameLevel"));
        System.out.println("---------------------------\n\n");
        session2.close();
        HibernateUtil.shutdown();


    }
}
