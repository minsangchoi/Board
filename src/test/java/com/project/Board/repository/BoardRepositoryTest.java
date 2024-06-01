package com.project.Board.repository;

import com.project.Board.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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