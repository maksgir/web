package com.maksgir.dao;

import com.maksgir.config.AppConfig;
import com.maksgir.entity.UserEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "userDAO")
@ApplicationScoped
public class UserDAO {

    public void save(UserEntity user) {
        Session session = AppConfig.sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
        } catch ( Exception e ) {
            if ( session.getTransaction().isActive() ) {
                session.getTransaction().rollback();
            }
            throw e;
        }
        finally {
            if ( session != null && session.isOpen() ) {
                session.close();
            }
        }


    }

    public UserEntity getById(String id) {
        UserEntity user = null;
        Session session = AppConfig.sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            user = session.get(UserEntity.class, id);

            Hibernate.initialize(user.getPoints());

            session.getTransaction().commit();
        } catch ( Exception e ) {
            if ( session.getTransaction().isActive() ) {
                session.getTransaction().rollback();
            }
            throw e;
        }
        finally {
            if ( session != null && session.isOpen() ) {
                session.close();
            }
        }
        return user;
    }

    public void clearPoints(String id){
        Session session = AppConfig.sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            session.createQuery("delete from PointEntity where owner.sessionId = :id").setParameter("id", id).executeUpdate();

            session.getTransaction().commit();
        } catch ( Exception e ) {
            if ( session.getTransaction().isActive() ) {
                session.getTransaction().rollback();
            }
            throw e;
        }
        finally {
            if ( session != null && session.isOpen() ) {
                session.close();
            }
        }
    }
}
