package com.maksgir.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "points")
@Getter
@Setter
@NoArgsConstructor
public class PointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "x")
    private double x;

    @Column(name = "y")
    private double y;

    @Column(name = "r")
    private double r;

    @Column(name = "timezone")
    private int timezone;

    @Column(name = "dt")
    private LocalDateTime dt;

    @Column(name = "exe_time")
    private double exe_time;

    @Column(name = "hit")
    private boolean hit;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    public PointEntity(double x, double y, double r, int timezone, double exe_time, boolean hit, UserEntity owner) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.timezone = timezone;
        this.dt = LocalDateTime.now();
        this.exe_time = exe_time;
        this.hit = hit;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "PointEntity{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", timezone=" + timezone +
                ", dt=" + dt +
                ", exe_time=" + exe_time +
                ", hit=" + hit +
                '}';
    }
}
