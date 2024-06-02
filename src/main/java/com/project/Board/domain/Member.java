package com.project.Board.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id" ,nullable = false)
    private Long id;             // 회원 번호 (PK)

    @Column(name = "login_id" ,nullable = false)
    private String loginId;      // 로그인 ID

    @Column(name = "password" ,nullable = false)
    private String password;     // 비밀번호

    @Column(name = "name" ,nullable = false)
    private String name;         // 이름

    @Column(name = "nickname",nullable = false)
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
