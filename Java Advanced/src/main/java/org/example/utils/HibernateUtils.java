package org.example.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    public static SessionFactory sessionFactory;

    //tạo sessionFactory
    static {
        Configuration cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
        // kết nối đên Db
        Session session = sessionFactory.openSession(); //tạo connection

    }
}
