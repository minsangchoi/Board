package com.querydsl.Board.controller;

import com.querydsl.Board.Service.BoardService;
import com.querydsl.Board.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(required = false,defaultValue = "0",value = "page") int page) {

        Page<Board> listpage = boardService.list(page); //불러올 페이지 데이터 1페이지는 0부터시작

        int totalpage = listpage.getTotalPages(); // 총페이지개수

        model.addAttribute("totalpage", totalpage);

        model.addAttribute("board", listpage.getContent());
        return "list";
    }

    @GetMapping("/detail/{idx}")
    public String detail(@PathVariable int idx, Model model) {
        model.addAttribute("board", boardService.detail(idx));
        return "detail";
    }

    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(Board board) {
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
}
