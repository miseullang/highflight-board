package com.study.highFlight.board.repository;

import com.study.highFlight.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
}
