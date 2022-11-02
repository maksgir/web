package com.maksgir.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
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

    public String getLocalZoneDt(){
        int timezone= (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("timezone");
        System.out.println(timezone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        return dt.minusHours(timezone/60).format(formatter);
    }
}
