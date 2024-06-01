package com.project.Board.Service;

import com.project.Board.domain.Board;
import com.project.Board.dto.BoardMemberDto;
import com.project.Board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    //게시글저장
    public void register(Board board) {
        boardRepository.save(board);
    }
    //게시글 리스트조회
    public List<Board> list() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "idx"));
    }
    //게시글 상세 조회 및 조회수 증가
    public Board detail(int idx) {
        Board board = boardRepository.searchDetailBoard(idx);
        increaseViewCount(board);
        return board;
    }
    //조회수증가
    private void increaseViewCount(Board board) {
        board.increaseViewCount();
        boardRepository.save(board);
    }
    //게시글수정
    public void update(Board board) {
        boardRepository.save(board);
    }
    //게시글삭제
    public void delete(int idx) {
        boardRepository.deleteById(idx);
    }

    //게시글 리스트 페이징조회
    public Page<BoardMemberDto> list(Pageable pageable) {

        return boardRepository.searchPageingBoard(pageable);
    }

}
