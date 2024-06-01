package com.querydsl.Board.repository;

import com.querydsl.Board.domain.Board;
import com.querydsl.Board.dto.BoardMemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardRepositoryCustom {
    Page<BoardMemberDto> searchPageBoard(Pageable pageable);

}
