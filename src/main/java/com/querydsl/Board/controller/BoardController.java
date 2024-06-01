package com.querydsl.Board.controller;

import com.querydsl.Board.Service.BoardService;
import com.querydsl.Board.Service.CommentsService;
import com.querydsl.Board.domain.Board;
import com.querydsl.Board.domain.Comments;
import com.querydsl.Board.domain.Member;
import com.querydsl.Board.dto.BoardMemberDto;
import com.querydsl.Board.repository.BoardRepository;
import com.querydsl.Board.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final CommentsService commentsService;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(required = false, defaultValue = "0") int page,
                       @RequestParam(required = false, defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<BoardMemberDto> listpage = boardService.list(pageable); // 불러올 페이지 데이터

        int totalpage = listpage.getTotalPages(); // 총 페이지 개수

        model.addAttribute("totalpage", totalpage);
        model.addAttribute("board", listpage.getContent());
        return "list";
    }

    @GetMapping("/detail/{idx}")
    public String detail(@PathVariable int idx, Model model) {
        //게시글 상세조회
        model.addAttribute("board", boardService.detail(idx));
        //댓글리스트 조회
        List<Comments> comments = commentsService.SearchComments(idx);
        model.addAttribute("comment",comments);

        return "detail";
    }

    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute Board board, HttpSession session) {
        // 세션에서 사용자 ID 가져오기
        String userId = (String) session.getAttribute("userid");

        // 사용자 ID가 없으면 로그인 페이지로 리다이렉트
        if (userId == null) {
            return "redirect:/member/login";
        }
        // 사용자 ID로 Member 엔티티 조회
        Member member = memberRepository.findByloginId(userId);
        // board 테이블에 member_id 세팅
        board.setMember(member);
        //게시글 저장
        boardService.register(board);

        return "redirect:/board/list";
    }

    @GetMapping("/update/{idx}")
    public String updateGet(@PathVariable int idx, Model model) {
        model.addAttribute("board", boardService.detail(idx));
        return "update";
    }

    @PostMapping("/update/{idx}")
    public String updatePost(Board board) {
        boardService.update(board);
        return "redirect:/board/list";
    }

    @GetMapping("delete/{idx}")
    public String deleteGet(@PathVariable int idx) {
        boardService.delete(idx);
        return "redirect:/board/list";
    }
    //댓글작성
    @PostMapping("/comment/register/{idx}")
    public String updatePost(@PathVariable("idx") int boardId,@ModelAttribute Comments comments, HttpSession session) {

        // 세션에서 사용자 ID 가져오기
        String userId = (String) session.getAttribute("userid");

        // 사용자 ID가 없으면 로그인 페이지로 리다이렉트
        if (userId == null) {
            return "redirect:/member/login";
        }
        // 사용자 ID로 Member 엔티티 조회
        Member member = memberRepository.findByloginId(userId);

        // 댓글 테이블에 member_id 세팅
        comments.setMember(member);

        Board board = boardRepository.findById(boardId).orElse(null);
        // 댓글 테이블에 member_id 세팅
        comments.setBoard(board);

        commentsService.register(comments);

        return "redirect:/board/detail/"+boardId;
    }
    //댓글수정 get
    @GetMapping("/comment/commentupdate/{id}/{idx}")
    public String CommentupdateGet(@PathVariable Long id, Model model) {
        model.addAttribute("comment", commentsService.Commentsdetail(id));
        return "commentupdate";
    }
    //댓글수정 post
    @PostMapping("/comment/commentupdate/{id}/{idx}")
    public String CommentupdatePost(@PathVariable Long id,@PathVariable Long idx,Comments comments) {
        commentsService.CommentUpdate(id,comments.getComment());

        return "redirect:/board/detail/"+idx;
    }
    //댓글삭제
    @PostMapping("/comment/delete/{id}/{idx}")
    public String CommentDelete(@PathVariable Long id ,@PathVariable Long idx) {
        commentsService.CommentDelete(id);

        return "redirect:/board/detail/"+idx;
    }
}
