package com.maksgir.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

@Table(name = "spider_point")
@Entity
@Getter
@Setter
public class SpiderPoint extends PointEntity {
    @Column(name = "leg_num")
    private int legNum;
}
