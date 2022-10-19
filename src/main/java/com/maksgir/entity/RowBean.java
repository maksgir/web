package com.maksgir.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RowBean {
    private int x;
    private int y;
    private double r;
    private String hit;
    private double executionTime;
    private String dt;

    public RowBean(int x, int y, double r, String hit, LocalTime start) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.executionTime = (LocalTime.now().getNano() - start.getNano()) / Math.pow(10, 6);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd");
        this.dt = LocalDateTime.now().format(formatter);
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

    public double getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(double executionTime) {
        this.executionTime = executionTime;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "RowBean{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", answer='" + hit + '\'' +
                ", executionTime=" + executionTime +
                ", dt=" + dt +
                '}';
    }
}
