package com.study.highFlight.member.service;

import com.study.highFlight.common.config.exception.CustomException;
import com.study.highFlight.common.config.exception.ErrorCode;
import com.study.highFlight.member.dto.*;
import com.study.highFlight.member.entity.Member;
import com.study.highFlight.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
        String nickname = memberSignUpRequestDTO.getMemberNickname();
        String mail = memberSignUpRequestDTO.getMemberMail();

        if (nickname.isEmpty() || nickname.length() > 20) {
            throw new CustomException(ErrorCode.OMG_ERROR);
        }

//        if (mail.includes("eunah")) {
//            throw new CustomException(ErrorCode.OMG_ERROR_2);
//        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String password = memberSignUpRequestDTO.getMemberPw();
        String encodePassword = passwordEncoder.encode(password);

        Member memberSign = memberRepository.save(
                Member.builder()
                        .memberId(memberSignUpRequestDTO.getMemberId())
                        .memberPw(encodePassword)
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

    // 회원 수정
    @Override
    public UpdateMemberResponseDTO memberInfo(UpdateMemberRequestDTO updateMemberRequestDTO) {
        Member member = memberRepository.getReferenceById(updateMemberRequestDTO.getMemberNo());

        member.changeMemberInfo(updateMemberRequestDTO.getMemberMail(), updateMemberRequestDTO.getMemberNickname());

        UpdateMemberResponseDTO updateMemberResponseDTO = new UpdateMemberResponseDTO();
        updateMemberResponseDTO.setMessage("회원 정보 수정 성공");

        return updateMemberResponseDTO;
    }

    // 회원ID 조회
    @Override
    public MemberIdCheckResponseDTO memberInfo(String memberId) {
        Optional<Member> requestMemberId = memberRepository.requestMemberId(memberId);

        MemberIdCheckResponseDTO memberIdCheckResponseDTO = new MemberIdCheckResponseDTO();

        if (requestMemberId.isEmpty()){
            memberIdCheckResponseDTO.setMessage("사용 가능한 아이디입니다.");
        } else {
            memberIdCheckResponseDTO.setMessage("이미 사용중인 아이디입니다.");
        }
        return memberIdCheckResponseDTO;
    }

    // 회원 탈퇴
    @Override
    public DeleteMemberResponseDTO deleteMember(Long memberNo) {
        Member member = memberRepository.getReferenceById(memberNo);

        DeleteMemberResponseDTO deleteMemberResponseDTO = new DeleteMemberResponseDTO();

        if (member.getMemberIsDelete() == false) {
            member.deleteMember();
            deleteMemberResponseDTO.setMemberNo(memberNo);
            deleteMemberResponseDTO.setMessage("탈퇴 처리되었습니다.");
        } else {
            deleteMemberResponseDTO.setMessage("이미 탈퇴된 회원입니다.");
        }

        return deleteMemberResponseDTO;
    }

    @Override
    public List<SearchMemberResponseDTO> searchMember(String memberId) {
        List<SearchMemberResponseDTO> searchMember = memberRepository.searchMember(memberId);
        return searchMember;
    }

    public Long add(Long firstNum, Long secondNum) {
        return firstNum + secondNum;
    }

}
