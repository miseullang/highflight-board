package com.study.highFlight.board.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.highFlight.board.dto.BoardSelectResponseDTO;
import com.study.highFlight.board.entity.Board;
import com.study.highFlight.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static com.study.highFlight.board.entity.QBoard.board;

public class BoardRepositoryImpl implements BoardRepositoryCustom {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    // 게시글 조회
    @Override
    public Optional<Board> boardSelectInfo(Long boardNo) {
        return Optional.ofNullable(
                jpaQueryFactory.select(board)
                        .from(board)
                        .where(board.boardNo.eq(boardNo))
                        .fetchFirst()
        );
    }
}

