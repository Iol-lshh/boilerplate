package com.lshh.boardserver.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Accessors(chain = true)
@Setter
@Getter
@Table(name = "standard_post")
@Entity
public class StandardPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    private int idx;

    String title;
    int writer;
    LocalDateTime written;
    LocalDateTime deleted;

    @ManyToOne
    Board board;
}
