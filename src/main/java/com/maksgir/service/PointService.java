package com.maksgir.service;


import com.maksgir.beans.PointBean;
import com.maksgir.dao.PointDAO;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "pointService", eager = true)
@ApplicationScoped
public class PointService {
    @ManagedProperty(value = "#{pointDAO}")
    private PointDAO dao;

    public PointDAO getDao() {
        return dao;
    }

    public void setDao(PointDAO dao) {
        this.dao = dao;
    }

    public void save(PointBean pointBean){
//        dao.save();
    }
}
