package com.study.highFlight.board.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchPostResponseDTO {
    private Long boardNo;
    private String boardTitle;
    private String boardContent;
    private int boardReadCount;
    private LocalDateTime boardCreate;

    public SearchPostResponseDTO(Long boardNo, String boardTitle, String boardContent, int boardReadCount, LocalDateTime boardCreate) {
        this.boardNo = boardNo;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardReadCount = boardReadCount;
        this.boardCreate = boardCreate;
    }
}
