package com.maksgir.service;


import com.maksgir.beans.PointBean;
import com.maksgir.dao.PointDAO;
import com.maksgir.entity.PointEntity;
import com.maksgir.entity.UserEntity;
import com.maksgir.util.AreaHitChecker;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "pointService", eager = true)
@ApplicationScoped
public class PointService {

    @ManagedProperty(value = "#{pointDAO}")
    private PointDAO dao;

    private AreaHitChecker hitChecker = new AreaHitChecker();


    public PointDAO getDao() {
        return dao;
    }

    public void setDao(PointDAO dao) {
        this.dao = dao;
    }

    public void save(PointBean pointBean) {
        System.out.println(pointBean);

        long start = System.currentTimeMillis();
        boolean hit = hitChecker.checkHit(pointBean.getX(), pointBean.getY(), pointBean.getR());
        double exeTime = System.currentTimeMillis() - start;
        UserEntity userEntity = pointBean.getUserBean().getUserEntity();

        System.out.println(userEntity.getPoints());

        PointEntity pointEntity = new PointEntity(pointBean.getX(), pointBean.getY(),
                pointBean.getR(), pointBean.getTimezone(), exeTime, hit, userEntity);

        System.out.println(pointEntity);

        dao.save(pointEntity);
    }
}
