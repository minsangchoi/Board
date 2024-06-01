package com.querydsl.Board.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;             // 회원 번호 (PK)

    @Column(name = "login_id")
    private String loginId;      // 로그인 ID

    @Column(name = "password")
    private String password;     // 비밀번호

    @Column(name = "name")
    private String name;         // 이름

    @Column(name = "nickname")
    private String nickname;      // 닉네임

    @Column(name = "email")
    private String email;        // 이메일


    public Member(String loginId, String password, String name, String nickname, String email) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
    }

    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }


}
