package com.maksgir.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "session_id")
    private String sessionId;

    @OneToMany(mappedBy = "owner")
    private List<PointEntity> points;
}
