package com.maksgir.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ResponseParams {
    private Integer x;
    private Integer y;
    private Double r;
    private String answer;
    private double executionTime;
    private LocalDateTime dt;

    public ResponseParams(Integer x, Integer y, Double r, String answer, LocalTime start) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.answer = answer;
        this.executionTime = (LocalTime.now().getNano() - start.getNano()) / Math.pow(10, 3);
        this.dt = LocalDateTime.now();
        System.out.println(dt.toLocalTime());
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public double getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(double executionTime) {
        this.executionTime = executionTime;
    }

    public LocalDateTime getDt() {
        return dt;
    }

    public String getStringDt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd");

        return dt.format(formatter);
    }

    public void setDt(LocalDateTime dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "ResponseParams{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", answer='" + answer + '\'' +
                ", executionTime=" + executionTime +
                ", dt=" + dt +
                '}';
    }
}
