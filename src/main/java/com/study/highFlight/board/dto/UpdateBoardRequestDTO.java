package com.study.highFlight.board.dto;

import lombok.Data;

@Data
public class UpdateBoardRequestDTO {
    private Long boardNo;
    private String boardTitle;
    private String boardContent;
}