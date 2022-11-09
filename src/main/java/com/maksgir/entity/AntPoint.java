package com.maksgir.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

@Table(name = "ant_point")
@Entity
@Getter
@Setter
public class AntPoint extends PointEntity {
    @Column(name = "body_color")
    private String bodyColor;
}
