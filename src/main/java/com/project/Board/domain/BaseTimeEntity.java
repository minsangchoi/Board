package com.project.Board.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class BaseTimeEntity {

    @Column(name = "created_date")
    public LocalDateTime createdDate;   // 생성일시

    @Column(name = "modified_date")
    public LocalDateTime modifiedDate;  // 최종 수정일시


    /* 해당 엔티티를 저장하기 이전에 실행 */
    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
    }

    /* 해당 엔티티를 업데이트 하기 이전에 실행*/
    @PreUpdate
    public void preUpdate() {
        this.modifiedDate = LocalDateTime.now();
    }

}
