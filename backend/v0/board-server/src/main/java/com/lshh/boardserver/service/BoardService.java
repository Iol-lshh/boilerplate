package com.lshh.boardserver.service;

import com.lshh.boardserver.model.dto.BoardBasic;
import com.lshh.boardserver.model.dto.BoardRequest;
import com.lshh.boardserver.model.entity.Board;

import java.util.List;

public interface BoardService {
    List<BoardBasic> findAll();

    BoardBasic find(int idx);

    int create(BoardRequest boardRequest);

    int update(BoardRequest boardRequest);

    int delete(int idx);

    List<BoardBasic> findList(int pageSize, int pageNo);
}
