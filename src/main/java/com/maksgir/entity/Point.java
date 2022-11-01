package com.maksgir.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "points")
@Getter
@Setter
@NoArgsConstructor
public class Point {
    @Id
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
    private Date dt;

    @Column(name = "exe_time")
    private double exe_time;

    @Column(name = "hit")
    private boolean hit;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;


}
