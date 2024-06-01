package com.querydsl.Board.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardMemberDto {
    private int idx; //게시판 키값
    private String title; // 제목
    private String content; // 내용
    private String writer; // 작성자
    private int view; // 조회수
    private LocalDateTime createdDate;   // 생성일시

    public BoardMemberDto(int idx, String title, String content, String writer, int view, LocalDateTime createdDate) {
        this.idx = idx;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.view = view;
        this.createdDate = createdDate;
    }
}
