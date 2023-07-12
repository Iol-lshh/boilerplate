package com.lshh.boardserver.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Accessors(chain = true)
@Data
public class BoardBasic {
    int idx;
    String name;
    int creater;
    LocalDateTime created;
    int updater;
    LocalDateTime updated;
}
