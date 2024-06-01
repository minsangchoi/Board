package com.querydsl.Board.repository;

import com.querydsl.Board.domain.Board;
import com.querydsl.Board.dto.BoardMemberDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public class BoardRepositoryImpl implements BoardRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<BoardMemberDto> searchPageBoard(Pageable pageable) {
        // 올바른 JPQL 쿼리
        String jpql = "select new com.querydsl.Board.dto.BoardMemberDto(a.idx, a.title, a.content, a.member.name as writer, a.view, a.createdDate) "
                + " from Board a join  a.member "
                + " order by a.createdDate desc";


        List<BoardMemberDto> resultList = em.createQuery(jpql,BoardMemberDto.class)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        // To get the total count
        long total = em.createQuery("select count(a) from Board a join a.member m", Long.class).getSingleResult();

        return new PageImpl<>(resultList, pageable, total);

    }

}
