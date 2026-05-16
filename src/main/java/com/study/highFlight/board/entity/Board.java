package com.study.highFlight.board.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOARDS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Long boardNo;

    @Column(name = "board_title", nullable = false)
    private String boardTitle;

    @Column(name = "board_content", length = 5000, nullable = false)
    private String boardContent;

    @Column(name = "board_readCount")
    private Integer boardReadCount;

    @Column(name = "board_create", nullable = false)
    private LocalDateTime boardCreate;

    @Column(name = "board_update")
    private LocalDateTime boardUpdate;

    public void increaseReadCount() {
        this.boardReadCount++;
    }

    public void changeBoardInfo(String boardTitle, String boardContent, LocalDateTime boardUpdate) {
        if (boardTitle != null) {
            this.boardTitle = boardTitle;
        }

        if (boardContent != null) {
            this.boardContent = boardContent;
        }

        this.boardUpdate = boardUpdate;
    }
}
