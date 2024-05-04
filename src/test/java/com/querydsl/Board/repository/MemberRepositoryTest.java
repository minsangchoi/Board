package com.querydsl.Board.repository;

import com.querydsl.Board.entity.Gender;
import com.querydsl.Board.entity.Member;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
@Transactional
@Commit
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    //회원정보생서
    @Test
    void saveMember(){
        Member saveParams = new Member("als4513","1234","민상",Gender.F,LocalDate.of(1997,5,19),false);

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
}