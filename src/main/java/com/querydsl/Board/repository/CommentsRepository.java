package com.querydsl.Board.repository;


import com.querydsl.Board.domain.Board;
import com.querydsl.Board.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments,Long> {
    @Query("select distinct a,m.name"
            + " from Comments a join fetch a.member m "
            + " where a.board.idx = :idx")
    List<Comments> searchDetailComments(@Param("idx") int idx);
}
