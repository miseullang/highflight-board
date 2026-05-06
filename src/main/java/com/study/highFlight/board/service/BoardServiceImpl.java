package com.study.highFlight.board.service;

import com.study.highFlight.board.dto.*;
import com.study.highFlight.board.entity.Board;
import com.study.highFlight.board.repository.BoardRepository;
import com.study.highFlight.member.entity.Member;
import jakarta.transaction.Transactional;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    // 게시글 작성
    @Override
    public BoardCreateResponseDTO createPosting(BoardCreateRequestDTO boardCreateRequestDTO) {
        Board createPost = boardRepository.save(
                Board.builder()
                        .boardTitle(boardCreateRequestDTO.getBoardTitle())
                        .boardCreate(LocalDateTime.now())
                        .boardReadCount(0)
                        .boardContent(boardCreateRequestDTO.getBoardContent())
                        .build()
        );
        BoardCreateResponseDTO boardCreateResponseDTO = new BoardCreateResponseDTO();

        boardCreateResponseDTO.setBoardNo(createPost.getBoardNo());
        boardCreateResponseDTO.setMessage("Success!");

        return boardCreateResponseDTO;
    }

    @Override
    public BoardSelectResponseDTO boardSelectInfo(Long boardNo) {
        Optional<Board> selectPosting = boardRepository.boardSelectInfo(boardNo);

        BoardSelectResponseDTO boardSelectResponseDTO = new BoardSelectResponseDTO();

        if(selectPosting.isEmpty()) {
            return  null;
        } else {
            Board board = selectPosting.get();
            board.increaseReadCount();

            boardSelectResponseDTO.setBoardNo(boardNo);
            boardSelectResponseDTO.setBoardTitle(board.getBoardTitle());
            boardSelectResponseDTO.setBoardContent(board.getBoardContent());
            boardSelectResponseDTO.setBoardReadCount(board.getBoardReadCount());
            boardSelectResponseDTO.setBoardUpdate(board.getBoardUpdate());
            boardSelectResponseDTO.setBoardCreate(board.getBoardCreate());

            return boardSelectResponseDTO;
        }
    }

    @Override
    public UpdateBoardResponseDTO boardUpdate(UpdateBoardRequestDTO updateBoardRequestDTO) {
        Board board = boardRepository.getReferenceById(updateBoardRequestDTO.getBoardNo());

        board.changeBoardInfo(updateBoardRequestDTO.getBoardTitle(), updateBoardRequestDTO.getBoardContent());

        UpdateBoardResponseDTO updateBoardResponseDTO = new UpdateBoardResponseDTO();
        updateBoardResponseDTO.setMessage("게시물 수정 성공");

        return  updateBoardResponseDTO;
    }
}
