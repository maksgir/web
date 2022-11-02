package com.maksgir.beans;


import com.maksgir.dto.PointDTO;
import com.maksgir.entity.UserEntity;
import com.maksgir.service.UserService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "userBean")
@SessionScoped
@Getter
@Setter
public class UserBean {

    private String id;

    @ManagedProperty(value = "#{userService}")
    private UserService service;

    private List<PointDTO> pointDTOList;


    public UserBean() {
        FacesContext fCtx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
        id = session.getId();
        pointDTOList = new ArrayList<>();
    }

    @PostConstruct
    public void init(){
        service.save(this);
    }


    public UserEntity getUserEntity(){
        return service.getUserById(id);
    }

    public void clear(){
        System.out.println("clear");
        System.out.println(pointDTOList);
        pointDTOList.clear();
        service.clearPoints(this);
    }
}
