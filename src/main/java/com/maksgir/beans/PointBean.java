package com.maksgir.beans;

import com.maksgir.service.PointService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@ManagedBean(name = "point")
@RequestScoped
public class PointBean {

    @Min(-4)
    @Max(4)
    private double x;


    @Min(value = -3, message = "Y must be more than -3")
    @Max(value = 3, message = "Y must be less than 3")
    private double y;


    @Min(0)
    @Max(3)
    private double r;


    @ManagedProperty(value = "#{pointService}")
    private PointService service;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public PointService getService() {
        return service;
    }

    public void setService(PointService service) {
        this.service = service;
    }

    public void submit() {
        FacesContext fCtx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
        String sessionId = session.getId();
        System.out.println(sessionId);
    }

    @Override
    public String toString() {
        return "PointBean{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }
}