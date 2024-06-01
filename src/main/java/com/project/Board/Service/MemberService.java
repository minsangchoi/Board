package com.project.Board.Service;

import com.project.Board.domain.Member;
import com.project.Board.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
