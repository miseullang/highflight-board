package com.study.highFlight.member.service;

import com.study.highFlight.board.dto.DeletePostingResponseDTO;
import com.study.highFlight.member.dto.*;

import java.util.List;

public interface MemberService {
    // 회원가입
    MemberSignUpResponseDTO signUp(MemberSignUpRequestDTO memberSignUpRequestDTO);

    // 회원조회
    SelectMemberResponseDTO memberInfo(Long memberNo);

    // 회원수정
    UpdateMemberResponseDTO memberInfo(UpdateMemberRequestDTO updateMemberRequestDTO);

    // 회원ID 조회
    MemberIdCheckResponseDTO memberInfo(String memberId);

    // 회원 탈퇴
    DeleteMemberResponseDTO deleteMember(Long memberNo);

    // 회원 검색
    List<SearchMemberResponseDTO> searchMember(String memberId);
}