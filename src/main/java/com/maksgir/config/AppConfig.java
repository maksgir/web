package com.maksgir.config;

import com.maksgir.entity.Point;
import com.maksgir.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppConfig {
    public static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
            addAnnotatedClass(Point.class).
            addAnnotatedClass(User.class).buildSessionFactory();
}
