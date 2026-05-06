package com.study.highFlight.board.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BoardCreateResponseDTO {
    private Long boardNo;
    private String message;
}
