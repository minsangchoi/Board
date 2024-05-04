package com.querydsl.Board.repository;

import com.querydsl.Board.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void save() {
        Board board = new Board("test","asdasdasd","choe");
        Board save = boardRepository.save(board);
    }

    @Test
    void list() {
        List<Board> all = boardRepository.findAll();
        for (Board board : all) {
            System.out.println(board.getIdx());
            System.out.println("board = " + board.getContent());
        }
    }
}