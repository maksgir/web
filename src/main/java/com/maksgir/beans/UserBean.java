package com.maksgir.beans;


import com.maksgir.service.UserService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "sessionId", eager = false)
@SessionScoped
public class UserBean {

    private String id;

    @ManagedProperty(value = "#{userService}")
    private UserService service;



    public UserBean() {
//        System.out.println("USER BEAN INIT");
        FacesContext fCtx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
        id = session.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserService getService() {
        return service;
    }

    public void setService(UserService service) {
//        System.out.println("SET SERVICE IN USER BEAN");
        this.service = service;
        service.save(this);
    }
}
