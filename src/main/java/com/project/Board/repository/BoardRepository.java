package com.project.Board.repository;

import com.project.Board.domain.Board;
import com.project.Board.dto.BoardMemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board,Integer>,BoardRepositoryCustom {
    @Query("select new com.querydsl.Board.dto.BoardMemberDto(a.idx, a.title, a.content, a.member.name as writer, a.view, a.createdDate) "
            + " from Board a join  a.member "
            + " order by a.createdDate desc")
    Page<BoardMemberDto> searchPageingBoard(Pageable pageable);

    @Query("select a,m.name"
            + " from Board a join  a.member m "
            + " where a.idx = :idx")
     Board searchDetailBoard(@Param("idx") int idx);
}
