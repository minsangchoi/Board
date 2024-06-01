package com.project.Board.controller;

import com.project.Board.domain.Member;
import com.project.Board.Service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    //로그인폼으로이동
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginId(@ModelAttribute Member member) {
        if (memberService.login(member)){
            return "redirect:/board/list";
        }
        return "login";
    }

    //로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); //세션초기화
        return "redirect:/board/list"; //메인화면으로..
    }

    //회원가입폼으로이동
    @GetMapping("/join")
    public String join() {
        return "join";
    }
    //회원가입 저장
    @PostMapping("/join")
    public String registerPost(Member member) {
        memberService.register(member);
        return "redirect:/member/login";
    }
}
