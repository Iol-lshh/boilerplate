package com.lshh.boardserver.service;


import com.lshh.boardserver.model.dto.BoardBasic;
import com.lshh.boardserver.model.dto.BoardRequest;
import com.lshh.boardserver.model.entity.Board;
import com.lshh.boardserver.model.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardServiceBasic implements BoardService{

    @Autowired
    BoardRepository boardRepository;

    @Override
    public int create(BoardRequest boardRequest) {
        return boardRepository.save(new Board()
                .setName(boardRequest.getName())
                .setCreater(boardRequest.getWriter())
                .setCreated(LocalDateTime.now()))
            .getIdx();
    }

    @Override
    @Transactional
    public int update(BoardRequest boardRequest) {
        Board board = boardRepository.findById(boardRequest.getIdx())
            .orElseThrow()
            .setName(boardRequest.getName())
            .setUpdater(boardRequest.getWriter())
            .setUpdated(LocalDateTime.now());

        return boardRepository.save(board)
            .getIdx();
    }

    @Override
    @Transactional
    public int delete(int idx) {
        Board board = boardRepository.findById(idx)
            .orElseThrow()
            .setDeleted(LocalDateTime.now());

        return boardRepository.save(board)
            .getIdx();
    }

    @Override
    public BoardBasic find(int idx) {
        return boardRepository.findById(idx)
            .map(BoardServiceBasic::toBoardBasic)
            .orElseThrow();
    }

    @Override
    public List<BoardBasic> findAll() {
        return boardRepository.findAllByDeletedIsNull().stream()
            .map(BoardServiceBasic::toBoardBasic)
            .toList();
    }

    @Override
    public List<BoardBasic> findList(int pageSize, int pageNo) {
        return boardRepository.findAllByDeletedIsNull(Pageable.ofSize(pageSize).withPage(pageNo))
            .map(BoardServiceBasic::toBoardBasic)
            .toList();
    }

    static BoardBasic toBoardBasic(Board entity){
        return new BoardBasic()
            .setIdx(entity.getIdx())
            .setName(entity.getName())
            .setCreater(entity.getCreater())
            .setCreated(entity.getCreated())
            .setUpdater(entity.getUpdater())
            .setUpdated(entity.getUpdated());
    }
}
