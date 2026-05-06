package com.study.highFlight.board.repository;

import com.study.highFlight.board.entity.Board;

import java.util.Optional;

public interface BoardRepositoryCustom {
    Optional<Board> boardSelectInfo(Long boardNo);
}
