package com.study.highFlight.board.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.highFlight.board.dto.BoardSelectResponseDTO;
import com.study.highFlight.board.dto.SearchPostResponseDTO;
import com.study.highFlight.board.entity.Board;
import com.study.highFlight.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
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

    // 게시글 삭제
    @Override
    public void deletePosting(Long boardNo) {
        jpaQueryFactory.delete(board)
                .where(board.boardNo.eq(boardNo))
                .execute();
    }

    // 게시글 검색
    @Override
    public List<SearchPostResponseDTO> selectPostingByKeyword(String keyword) {
        return jpaQueryFactory.select(Projections.constructor(SearchPostResponseDTO.class,
                board.boardNo, board.boardTitle, board.boardContent, board.boardReadCount, board.boardCreate))
                .from(board)
                .where(board.boardTitle.like("%" + keyword + "%")
                        .or(board.boardContent.like("%" + keyword + "%")))
                .orderBy(board.boardNo.desc())
                .fetch();
    }
}

