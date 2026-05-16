package com.study.highFlight.board.repository;

import com.study.highFlight.board.dto.SearchPostResponseDTO;
import com.study.highFlight.board.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepositoryCustom {
    Optional<Board> boardSelectInfo(Long boardNo);

    void deletePosting(Long boardNo);

    List<SearchPostResponseDTO> selectPostingByKeyword(String keyword);
}
