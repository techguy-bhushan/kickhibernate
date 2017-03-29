package com.kickwithhibernate.hibernatecriteriaquerylanguage;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.kickwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 29/3/17.
 */
public class Test {
    public static void main(String[] args) {
        BaseDAO baseDAO = new BaseDAO();
        for (int i=0; i<10; i++) {
            Movie movie = new Movie();
            movie.setName("James Bond "+i);
            movie.setActionMovie(getRandomBoolean());
            baseDAO.save(movie);
        }

        //Get all the records
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Movie.class);
        List<Movie> movies = (List<Movie>) criteria.list();
        System.out.println("Number of movies exists in database :"+movies.size());

        //Get first 5 movies
        Criteria first5MoviesCriteria = session.createCriteria(Movie.class);
        first5MoviesCriteria=session.createCriteria(Movie.class);
        movies = first5MoviesCriteria.setFirstResult(5).list();
        System.out.println("Number of get movies :"+movies.size());

        // Get the movies whic have name "James Bond 1"
        criteria =  session.createCriteria(Movie.class);
        criteria.add(Restrictions.eq("name", "James Bond 1"));
        movies = criteria.list();
        System.out.println("Number of movies  which have name James Bond 1"+movies.size());

        //Get movies in asc orders
        criteria = session.createCriteria(Movie.class);
        criteria.addOrder(Order.asc("id"));
        movies = criteria.list();
        System.out.println("Movies list in asc order");
        for (Movie movie : movies) {
            System.out.println("Movie name:" +movie.getName() +" with id:"+movie.getId());
        }

        //Get movies in desc orders
        criteria = session.createCriteria(Movie.class);
        criteria.addOrder(Order.desc("id"));
        movies = criteria.list();
        System.out.println("Movies list in desc order");
        for (Movie movie : movies) {
            System.out.println("Movie name:" +movie.getName() +" with id:"+movie.getId());
        }
        session.close();

        Genre genre = new Genre();
        genre.setMovie(movies.get(0));
        genre.setName("Spy film");
        baseDAO.save(genre);

        Genre genre1 = new Genre();
        genre1.setMovie(movies.get(1));
        genre1.setName("Spy film");
        baseDAO.save(genre1);



        // criteria alias -> get the movies list which have genre name Spy film.
        session = HibernateUtil.getSession();
        Criteria criteria1 = session.createCriteria(Movie.class, "m");
        criteria1.createAlias("m.genres", "g");
        criteria1.add(Restrictions.eq("g.name", "Spy film"));
        List<Movie> moviesList = criteria1.list();
        session.close();

        for (Movie movie : moviesList) {
            System.out.println("Movie name "+movie.getName());
        }
        HibernateUtil.shutdown();
    }

    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }
}
