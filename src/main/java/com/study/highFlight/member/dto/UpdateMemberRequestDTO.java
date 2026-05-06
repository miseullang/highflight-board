package com.study.highFlight.member.dto;

import lombok.Data;

@Data
public class UpdateMemberRequestDTO {
    private Long memberNo;
    private String memberMail;
    private String memberNickname;
}