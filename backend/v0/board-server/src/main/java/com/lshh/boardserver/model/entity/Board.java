package com.lshh.boardserver.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Accessors(chain = true)
@Setter
@Getter
@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    int idx;

    String name;

    int creater;
    LocalDateTime created;
    int updater;
    LocalDateTime updated;
    LocalDateTime deleted;

    @OneToMany
    List<StandardPost> standardPost;
}
