package com.maksgir.dao;

import com.maksgir.config.AppConfig;
import com.maksgir.entity.Point;
import org.hibernate.Session;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "pointDAO")
@ApplicationScoped
public class PointDAO {
    public void save(Point point) {
        try (Session session = AppConfig.sessionFactory.getCurrentSession();) {
            session.beginTransaction();

            session.save(point);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
