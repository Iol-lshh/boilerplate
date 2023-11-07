package com.lshh.boardserver.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.relational.core.mapping.Table;

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
@Entity
// 이 서비스에 지역화된 User
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name="login_id")
    String loginId;

    String name;
}
