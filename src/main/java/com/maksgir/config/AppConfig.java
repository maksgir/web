package com.maksgir.config;

import com.maksgir.entity.PointEntity;
import com.maksgir.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppConfig {
    public static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
            addAnnotatedClass(PointEntity.class).
            addAnnotatedClass(UserEntity.class).buildSessionFactory();
}
