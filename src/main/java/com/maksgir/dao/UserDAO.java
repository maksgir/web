package com.maksgir.dao;

import com.maksgir.config.AppConfig;
import com.maksgir.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "userDAO")
@ApplicationScoped
public class UserDAO {

    public void save(UserEntity user) {
        try (Session session = AppConfig.sessionFactory.getCurrentSession();) {
            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public UserEntity getById(String id) {
        UserEntity user = null;
        try (Session session = AppConfig.sessionFactory.getCurrentSession();) {
            session.beginTransaction();

            user = session.get(UserEntity.class, id);

            Hibernate.initialize(user.getPoints());

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void clearPoints(String id){
        try (Session session = AppConfig.sessionFactory.getCurrentSession();) {
            session.beginTransaction();
            session.createQuery("delete from PointEntity where owner.sessionId = :id").setParameter("id", id).executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
