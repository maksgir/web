package com.maksgir.dto;

import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.time.LocalDateTime;


@Getter
@Setter
@ManagedBean
@RequestScoped
public class PointDTO {
    private double x;
    private double y;
    private double r;
    private LocalDateTime dt;
    private double exe_time;
    private boolean hit;

    public PointDTO(double x, double y, double r, LocalDateTime dt, double exe_time, boolean hit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.dt = dt;
        this.exe_time = exe_time;
        this.hit = hit;
    }
}
