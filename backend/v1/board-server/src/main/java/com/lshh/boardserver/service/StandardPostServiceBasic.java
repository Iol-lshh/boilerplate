package com.lshh.boardserver.service;

import com.lshh.boardserver.model.dto.BoardBasic;
import com.lshh.boardserver.model.dto.StandardPostBasic;
import com.lshh.boardserver.model.dto.StandardPostRequest;
import com.lshh.boardserver.model.entity.Board;
import com.lshh.boardserver.model.entity.StandardPost;
import com.lshh.boardserver.model.repository.BoardRepository;
import com.lshh.boardserver.model.repository.StandardPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StandardPostServiceBasic implements StandardPostService{
    @Autowired
    StandardPostRepository standardPostRepository;
    @Autowired
    BoardRepository boardRepository;

    @Override
    public int create(StandardPostRequest standardPostRequest) {
        Board board = boardRepository.findById(standardPostRequest.getBoardIdx()).orElseThrow();

        return standardPostRepository.save(new StandardPost()
                .setTitle(standardPostRequest.getTitle())
                .setWriter(standardPostRequest.getWriter())
                .setWritten(LocalDateTime.now())
                .setBoard(board))
            .getIdx();
    }

    @Override
    @Transactional
    public int update(StandardPostRequest standardPostRequest) {
        StandardPost post = standardPostRepository.findById(standardPostRequest.getIdx()).orElseThrow();

        return standardPostRepository.save(post
                .setTitle(standardPostRequest.getTitle()))
            .getIdx();
    }

    @Override
    @Transactional
    public int delete(int idx) {
        StandardPost post = standardPostRepository.findById(idx).orElseThrow();

        return standardPostRepository.save(post
                .setDeleted(LocalDateTime.now()))
            .getIdx();
    }

    @Override
    @Transactional
    public List<StandardPostBasic> findList(int boardIdx) {
        return standardPostRepository.findAllByBoardIdxAndDeletedIsNull(boardIdx).stream()
            .map(StandardPostServiceBasic::toStandardPostBasic)
            .toList();
    }

    @Override
    public List<StandardPostBasic> findList(int boardIdx, int pageSize, int pageNo) {
        return standardPostRepository.findAllByBoardIdxAndDeletedIsNull(boardIdx, Pageable.ofSize(pageSize).withPage(pageNo)).stream()
            .map(StandardPostServiceBasic::toStandardPostBasic)
            .toList();
    }

    @Override
    public StandardPostBasic find(int idx) {
        return standardPostRepository.findById(idx)
            .map(StandardPostServiceBasic::toStandardPostBasic)
            .orElseThrow();
    }

    public static StandardPostBasic toStandardPostBasic(StandardPost entity){
        return new StandardPostBasic()
            .setIdx(entity.getIdx())
            .setTitle(entity.getTitle())
            .setWriter(entity.getWriter())
            .setWritten(entity.getWritten())
            .setBoard(BoardServiceBasic.toBoardBasic(entity.getBoard()));
    }
}
