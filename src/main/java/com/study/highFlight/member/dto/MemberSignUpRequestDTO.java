package com.study.highFlight.member.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberSignUpRequestDTO {
    private String memberId;
    private String memberPw;
    private String memberMail;
    private String memberNickname;
}
