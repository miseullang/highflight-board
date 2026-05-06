package com.study.highFlight.member.controller;

import com.study.highFlight.member.dto.*;
import com.study.highFlight.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.reflect.MemberSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 회원 가입
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody MemberSignUpRequestDTO memberSignUpRequestDTO) {

        MemberSignUpResponseDTO memberSignUpResponseDTO = memberService.signUp (memberSignUpRequestDTO);

        return new ResponseEntity<>(memberSignUpResponseDTO, HttpStatus.OK);
    }

    // 회원 조회
    @GetMapping("/{memberNo}")
    public ResponseEntity<?> getMember(@PathVariable Long memberNo) {

        SelectMemberResponseDTO memberInfo = memberService.memberInfo(memberNo);

        return new ResponseEntity<>(memberInfo, HttpStatus.OK);
    }

    // 회원 정보 수정
    @PutMapping("/update-member")
    public ResponseEntity<?> updateMember(@RequestBody UpdateMemberRequestDTO updateMemberRequestDTO) {

        UpdateMemberResponseDTO updateMemberResponseDTO = memberService.memberInfo(updateMemberRequestDTO);

        return new ResponseEntity<>(updateMemberResponseDTO, HttpStatus.OK);
    }
}
