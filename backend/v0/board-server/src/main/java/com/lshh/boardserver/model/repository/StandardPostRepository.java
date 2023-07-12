package com.lshh.boardserver.model.repository;

import com.lshh.boardserver.model.entity.StandardPost;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StandardPostRepository extends JpaRepository<StandardPost, Integer> {
    <S extends StandardPost> List<S> findAllByBoardIdxAndDeletedIsNull(int boardIdx);

    <S extends StandardPost> Page<S> findAllByBoardIdxAndDeletedIsNull(int boardIdx, Pageable pageable);

}
