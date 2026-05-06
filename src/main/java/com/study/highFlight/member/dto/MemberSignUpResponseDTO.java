package com.study.highFlight.member.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberSignUpResponseDTO {
    private Long memberNo;
    private String message;
}
