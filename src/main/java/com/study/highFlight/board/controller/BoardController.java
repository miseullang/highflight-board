package com.study.highFlight.board.controller;

import com.study.highFlight.board.dto.*;
import com.study.highFlight.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시글 생성
    @PostMapping("/create")
    public ResponseEntity<?> createPosting(@RequestBody BoardCreateRequestDTO boardCreateRequestDTO) {

        BoardCreateResponseDTO boardCreateResponseDTO = boardService.createPosting (boardCreateRequestDTO);

        return new ResponseEntity<>(boardCreateResponseDTO, HttpStatus.OK);
    }

    // 게시글 조회
    @GetMapping("/{boardNo}")
    public ResponseEntity<?> getPosting(@PathVariable Long boardNo) {

        BoardSelectResponseDTO boardSelectInfo = boardService.boardSelectInfo(boardNo);

        if (boardSelectInfo == null) {
            return new ResponseEntity<>("🚨에러🚨", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(boardSelectInfo, HttpStatus.OK);
        }
    }

    @PutMapping("/update-posting")
    public ResponseEntity<?> updatePost(@RequestBody UpdateBoardRequestDTO updateBoardRequestDTO) {

        UpdateBoardResponseDTO updateBoardResponseDTO = boardService.boardUpdate(updateBoardRequestDTO);

        return new ResponseEntity<>(updateBoardResponseDTO, HttpStatus.OK);
    }

    // 게시글 삭제
    @DeleteMapping("/{boardNo}")
    public ResponseEntity<?> deletePost(@PathVariable Long boardNo) {

        DeletePostingResponseDTO deletePostingResponseDTO = boardService.deletePosting(boardNo);

        return new ResponseEntity<>(deletePostingResponseDTO, HttpStatus.OK);
    }
}
