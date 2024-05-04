package com.querydsl.Board.repository;

import com.querydsl.Board.entity.Board;
import com.querydsl.Board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Integer> {
}
