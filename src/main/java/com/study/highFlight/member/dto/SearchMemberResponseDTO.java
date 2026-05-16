package com.study.highFlight.member.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchMemberResponseDTO {
    private Long memberNo;
    private String memberId;
    private String memberMail;
    private String memberNickname;
    private LocalDateTime memberCreate;

    public SearchMemberResponseDTO(Long memberNo, String memberId, String memberMail, String memberNickname, LocalDateTime memberCreate) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberMail = memberMail;
        this.memberNickname = memberNickname;
        this.memberCreate = memberCreate;
    }
}
