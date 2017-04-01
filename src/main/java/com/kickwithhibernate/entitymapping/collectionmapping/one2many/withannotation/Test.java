package com.kickwithhibernate.entitymapping.collectionmapping.one2many.withannotation;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.kickwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 15/3/17.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.saveData();
        test.fetchData();

        HibernateUtil.shutdown();
    }

    private void saveData() {
        BaseDAO baseDAO = new BaseDAO();

        Album album = new Album();
        album.setName("*A Head Full of Dreams*");
        album.setArtist("Coldplay");
        baseDAO.save(album);

        Song track0 = new Song();
        track0.setName("A Head Full of Dreams");
        track0.setAlbum(album);
        baseDAO.save(track0);

        Song track1 = new Song();
        track1.setName("Birds");
        track1.setAlbum(album);
        baseDAO.save(track1);

    }

    private void fetchData() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from albums");
        List<Album> albumList = query.list();

        Iterator<Album> iterator = albumList.iterator();
        while (iterator.hasNext()) {
            Album album = iterator.next();
            System.out.println("Album Name :"+album.getName());
            System.out.println("Artist Name  :"+album.getArtist());
            List<Song> songList = album.getSongs();
            Iterator<Song> songIterator = songList.iterator();
            while (songIterator.hasNext()) {
                Song song = songIterator.next();
                System.out.println("Song name:"+song.getName());
            }
        }
        session.close();
    }
}
