package com.maksgir.service;


import com.maksgir.beans.UserBean;
import com.maksgir.dao.UserDAO;
import com.maksgir.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.ArrayList;

@ManagedBean(name = "userService", eager = true)
@ApplicationScoped
public class UserService {

    @ManagedProperty(value = "#{userDAO}")
    private UserDAO dao;

    public UserService() {
//        System.out.println("USER SERVICE INIT");
    }

    public void save(UserBean userBean) {
        UserEntity userEntity = new UserEntity();

        userEntity.setSessionId(userBean.getId());
        userEntity.setPoints(new ArrayList<>());

        dao.save(userEntity);
    }

    public UserEntity getUserById(String id){
        return dao.getById(id);
    }

    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
//        System.out.println("SET DAO IN USER SERVICE");
        this.dao = dao;
    }
}
