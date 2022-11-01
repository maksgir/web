package com.maksgir.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "session_id")
    private String model;

    @OneToMany(mappedBy = "owner")
    private List<Point> points;
}
