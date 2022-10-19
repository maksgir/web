package com.maksgir.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
        this.executionTime = (LocalTime.now().getNano() - start.getNano()) / Math.pow(10, 9);
        this.dt = LocalDateTime.now();
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
