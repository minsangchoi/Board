package com.project.Board.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id" ,nullable = false)
    private Long idx; //게시판 키값

    @Column(name = "title" ,nullable = false)
    private String title; // 제목
    @Column(name = "content" ,nullable = false)
    private String content; // 내용
    @Column(name = "writer" ,nullable = false)
    private String writer; // 작성자
    @Column(name = "view" ,nullable = false)
    private int view; // 조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",nullable = false)
    private Member member; // 회원테이블 조인

    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;

    }

    public void increaseViewCount(){
        this.view++;
    }



}
