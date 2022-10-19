package com.maksgir.entity;

public class RequestParams {
    private Integer x;
    private Integer y;
    private Double r;


    public RequestParams(Integer x, Integer y, Double r) {
        this.x = x;
        this.y = y;
        this.r = r;

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


    @Override
    public String toString() {
        return "Request{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }
}
