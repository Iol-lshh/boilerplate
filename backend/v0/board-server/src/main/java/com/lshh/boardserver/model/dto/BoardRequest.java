package com.lshh.boardserver.model.dto;

import lombok.Data;

@Data
public class BoardRequest {
    int idx;
    String name;
    int writer;
}
