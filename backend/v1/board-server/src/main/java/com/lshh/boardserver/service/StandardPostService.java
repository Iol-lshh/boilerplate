package com.lshh.boardserver.service;

import com.lshh.boardserver.model.dto.StandardPostBasic;
import com.lshh.boardserver.model.dto.StandardPostRequest;

import java.util.List;

public interface StandardPostService {
    int create(StandardPostRequest standardPostRequest);

    int update(StandardPostRequest standardPostRequest);

    int delete(int idx);

    List<StandardPostBasic> findList(int boardIdx);
    List<StandardPostBasic> findList(int boardIdx, int pageSize, int pageNo);

    StandardPostBasic find(int idx);
}
