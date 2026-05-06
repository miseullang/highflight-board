package com.study.highFlight.member.dto;

import lombok.Data;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
@ToString
public class SelectMemberResponseDTO {
    private Long memberNo;
    private String memberId;
    private String memberMail;
    private String memberNickname;
    private Boolean memberIsDelete;
    private LocalDateTime memberCreate;
}
