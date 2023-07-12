package com.lshh.boardserver.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Accessors(chain = true)
@Data
public class StandardPostBasic {
    int idx;
    String title;
    int writer;
    LocalDateTime written;
    BoardBasic board;
}
