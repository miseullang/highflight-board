package com.study.highFlight.board.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BoardCreateRequestDTO {
    private String boardTitle;
    private String boardContent;
}
