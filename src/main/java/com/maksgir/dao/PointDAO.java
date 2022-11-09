package com.maksgir.dao;

import com.maksgir.config.AppConfig;
import com.maksgir.entity.PointEntity;
import org.hibernate.Session;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "pointDAO", eager = true)
@ApplicationScoped
public class PointDAO {
    public void save(PointEntity point) {
        Session session = AppConfig.sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            session.save(point);

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
