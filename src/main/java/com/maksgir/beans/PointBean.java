package com.maksgir.beans;

import com.maksgir.service.PointService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@ManagedBean(name = "point")
@RequestScoped
@Getter
@Setter
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

    private Integer timezone;

    @ManagedProperty(value = "#{pointService}")
    private PointService service;

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;


    public void submit() {
        System.out.println("обновляю timezone - "+ timezone);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("timezone", timezone);
        service.save(this);
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
