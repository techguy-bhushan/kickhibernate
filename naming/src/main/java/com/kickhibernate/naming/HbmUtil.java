package com.kickhibernate.naming;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HbmUtil {
    private static Properties getProperties(String key, String value) {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "root");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/kickhibernate");
        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put(key, value);
        properties.put("hibernate.show_sql", true);
        return properties;
    }


    public static SessionFactory getSessionFactory(String key ,String value, Class... annotatedClasses) {
        Properties properties = getProperties(key, value);
        Configuration configuration = new Configuration().setProperties(properties);
        for (Class annotatedClass: annotatedClasses) {
            configuration.addAnnotatedClass(annotatedClass);
        }
        return configuration.buildSessionFactory();
    }
}