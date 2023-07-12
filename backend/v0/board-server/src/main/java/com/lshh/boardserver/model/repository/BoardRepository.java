package com.lshh.boardserver.model.repository;

import com.lshh.boardserver.model.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    <S extends Board> List<S> findAllByDeletedIsNull();
    <S extends Board> Page<S> findAllByDeletedIsNull(Pageable pageable);
}
