package com.querydsl.Board.repository;

import com.querydsl.Board.domain.Member;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Commit
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    //회원정보생서
    @Test
    void saveMember(){
        Member saveParams = new Member("als4513","1234","민상","테스트","test@naver.com");

        Member member = memberRepository.save(saveParams);
        Assertions.assertEquals(member.getLoginId(),"als4513");
    }

    @Test
    void findAllMember(){
        memberRepository.findAll();
    }

    @Test
    void findMemberByLoginId(){
        Member member = memberRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException());
        Assertions.assertEquals(member.getLoginId(),"als4513");

    }

    @Test
    void deleteMember(){
        memberRepository.deleteById(1L);
    }

    //로그인테스트
    @Test
    void login() {
        Member saveParams = new Member("als4513","1234","민상","테스트","test@naver.com");
        Member save = memberRepository.save(saveParams);
        Member findUser = memberRepository.findByloginId("als4513");

        System.out.println("members = " + findUser.getLoginId());
        assertThat(findUser.getLoginId()).isEqualTo(save.getLoginId());
        assertThat(findUser.getPassword()).isEqualTo(save.getPassword());

    }
}