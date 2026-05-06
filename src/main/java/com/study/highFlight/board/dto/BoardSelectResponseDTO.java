package com.study.highFlight.board.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardSelectResponseDTO {
    private Long boardNo;
    private String boardTitle;
    private String boardContent;
    private int boardReadCount;
    private LocalDateTime boardCreate;
    private LocalDateTime boardUpdate;
}