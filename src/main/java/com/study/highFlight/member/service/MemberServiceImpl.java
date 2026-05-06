package com.study.highFlight.member.service;

import com.study.highFlight.member.dto.*;
import com.study.highFlight.member.entity.Member;
import com.study.highFlight.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // 회원가입
    @Override
    public MemberSignUpResponseDTO signUp(MemberSignUpRequestDTO memberSignUpRequestDTO) {
        Member memberSign = memberRepository.save(
                Member.builder()
                        .memberId(memberSignUpRequestDTO.getMemberId())
                        .memberPw(memberSignUpRequestDTO.getMemberPw())
                        .memberMail(memberSignUpRequestDTO.getMemberMail())
                        .memberNickName(memberSignUpRequestDTO.getMemberNickname())
                        .memberIsDelete(false)
                        .memberCreate(LocalDateTime.now())
                        .build()
        );
        MemberSignUpResponseDTO memberSignUpResponseDTO = new MemberSignUpResponseDTO();

        memberSignUpResponseDTO.setMemberNo(memberSign.getMemberNo());
        memberSignUpResponseDTO.setMessage("회원 가입 성공");

        return memberSignUpResponseDTO;
    }

    // 회원 조회
    @Override
    public SelectMemberResponseDTO memberInfo(Long memberNo) {
        Optional<Member> selectMemberInfo = memberRepository.selectMemberInfo(memberNo);

        SelectMemberResponseDTO selectMemberResponseDTO = new SelectMemberResponseDTO();

        if (selectMemberInfo.isEmpty()){
            return  null;
        } else {
            selectMemberResponseDTO.setMemberNo(memberNo);
            selectMemberResponseDTO.setMemberId(selectMemberInfo.get().getMemberId());
            selectMemberResponseDTO.setMemberMail(selectMemberInfo.get().getMemberMail());
            selectMemberResponseDTO.setMemberNickname(selectMemberInfo.get().getMemberNickName());
            selectMemberResponseDTO.setMemberIsDelete(selectMemberInfo.get().getMemberIsDelete());
            selectMemberResponseDTO.setMemberCreate(selectMemberInfo.get().getMemberCreate());

            return selectMemberResponseDTO;
        }
    }

    @Override
    public UpdateMemberResponseDTO memberInfo(UpdateMemberRequestDTO updateMemberRequestDTO) {
        Member member = memberRepository.getReferenceById(updateMemberRequestDTO.getMemberNo());

        member.changeMemberInfo(updateMemberRequestDTO.getMemberMail(), updateMemberRequestDTO.getMemberNickname());

        UpdateMemberResponseDTO updateMemberResponseDTO = new UpdateMemberResponseDTO();
        updateMemberResponseDTO.setMessage("회원 정보 수정 성공");

        return updateMemberResponseDTO;
    }


}
