package com.study.highFlight.board.service;

import com.study.highFlight.board.dto.*;

import java.util.List;

public interface BoardService{
    // 게시글 작성
    BoardCreateResponseDTO createPosting(BoardCreateRequestDTO boardCreateRequestDTO);

    // 게시글 조회
    BoardSelectResponseDTO boardSelectInfo(Long boardNo);

    // 게시글 수정
    UpdateBoardResponseDTO boardUpdate(UpdateBoardRequestDTO updateBoardRequestDTO);

    // 게시글 삭제
    DeletePostingResponseDTO deletePosting(Long boardNo);

    // 게시글 검색
    List<SearchPostResponseDTO> searchPost(String keyword);
}
