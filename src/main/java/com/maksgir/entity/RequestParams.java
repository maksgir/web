package com.maksgir.entity;

public class RequestParams {
    private Integer x;
    private Integer y;
    private Double r;
    private Integer timezone;

    public RequestParams(Integer x, Integer y, Double r, Integer timezone) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.timezone = timezone;
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

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "Request{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", timezone=" + timezone +
                '}';
    }
}
