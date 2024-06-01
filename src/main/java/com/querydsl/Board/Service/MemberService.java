package com.querydsl.Board.Service;

import com.querydsl.Board.domain.Board;
import com.querydsl.Board.domain.Member;
import com.querydsl.Board.repository.BoardRepository;
import com.querydsl.Board.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    private HttpSession session;

    public void register(Member member) {
        memberRepository.save(member);
    }

    public boolean login(Member member) {
        Member findUser = memberRepository.findByloginId(member.getLoginId());
        if (findUser == null){
            return false;
        }
        if (!findUser.validatePassword(findUser.getPassword())){
            return false;
        }

        // 로그인 성공 시 사용자 정보를 세션에 저장
        session.setAttribute("userid", findUser.getLoginId());
        session.setAttribute("nickname", findUser.getNickname());
        return true;
    }



}
