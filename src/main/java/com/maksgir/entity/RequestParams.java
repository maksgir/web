package com.maksgir.entity;

public class RequestParams {
    private Double x;
    private Double y;
    private Double r;
    private Integer timezone;


    public RequestParams(Double x, Double y, Double r, Integer timezone) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.timezone = timezone;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "RequestParams{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", timezone=" + timezone +
                '}';
    }
}
