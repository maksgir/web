package com.maksgir.service;


import com.maksgir.beans.PointBean;
import com.maksgir.dao.PointDAO;
import com.maksgir.dto.PointDTO;
import com.maksgir.entity.AntPoint;
import com.maksgir.entity.PointEntity;
import com.maksgir.entity.SpiderPoint;
import com.maksgir.entity.UserEntity;
import com.maksgir.util.AreaHitChecker;
import com.maksgir.util.DataGenerator;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@ManagedBean(name = "pointService", eager = true)
@ApplicationScoped
public class PointService {

    @ManagedProperty(value = "#{pointDAO}")
    private PointDAO dao;

    private AreaHitChecker hitChecker = new AreaHitChecker();

    private DataGenerator dataGenerator = new DataGenerator();

    public PointDAO getDao() {
        return dao;
    }

    public void setDao(PointDAO dao) {
        this.dao = dao;
    }

    public void save(PointBean pointBean) {
        long start = System.currentTimeMillis();

        boolean hit = hitChecker.checkHit(pointBean.getX(), pointBean.getY(), pointBean.getR());

        double exeTime = System.currentTimeMillis() - start;
        UserEntity userEntity = pointBean.getUserBean().getUserEntity();
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);

        PointEntity pointEntity =  (pointBean.getType().equals("Павук"))? new SpiderPoint():new AntPoint();
        pointEntity.setX(pointBean.getX());
        pointEntity.setY(pointBean.getY());
        pointEntity.setR(pointEntity.getR());
        pointEntity.setDt(ldt);
        pointEntity.setExe_time(exeTime);
        pointEntity.setHit(hit);
        pointEntity.setOwner(userEntity);

        if (pointEntity instanceof SpiderPoint){
            ((SpiderPoint) pointEntity).setLegNum(dataGenerator.getLegs());
        } else {
            ((AntPoint) pointEntity).setBodyColor(dataGenerator.getColor());
        }


        PointDTO pointDTO = new PointDTO(pointBean.getX(), pointBean.getY(),
                pointBean.getR(), ldt, exeTime, hit, pointBean.getType());

        dao.save(pointEntity);

        pointBean.getUserBean().getPointDTOList().add(pointDTO);
    }
}
