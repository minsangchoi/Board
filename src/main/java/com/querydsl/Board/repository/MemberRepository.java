package com.querydsl.Board.repository;


import com.querydsl.Board.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByloginId(String loginId);

//    @Query("select m from Member m where m.username =:username and m.age = :age")
//    List<Member> findUser(@Param("username") String username, @Param("age") int age);
}
