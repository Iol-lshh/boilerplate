package com.lshh.boardserver.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StandardPostRequest {
    int idx;
    String title;
    int writer;
    int boardIdx;
}
