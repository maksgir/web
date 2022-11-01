package com.maksgir.dao;

import com.maksgir.config.AppConfig;
import com.maksgir.entity.User;
import org.hibernate.Session;

public class UserDAO {

    public void save(User user) {
        try (Session session = AppConfig.sessionFactory.getCurrentSession();) {
            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public User getById(String id) {
        User user = null;
        try (Session session = AppConfig.sessionFactory.getCurrentSession();) {
            session.beginTransaction();

            user = session.get(User.class, id);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
