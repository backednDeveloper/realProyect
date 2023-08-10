package com.example.imtahan6.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "user_position")
public class User_Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne(targetEntity = Users.class)
    @JoinColumn(name = "user_id")
    private Users users;
    @OneToOne(targetEntity = Positions.class)
    @JoinColumn(name = "position_id")
    private Positions positions;
}
