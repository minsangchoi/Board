package com.project.Board.repository;


import com.project.Board.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByloginId(String loginId);

//    @Query("select m from Member m where m.username =:username and m.age = :age")
//    List<Member> findUser(@Param("username") String username, @Param("age") int age);
}
