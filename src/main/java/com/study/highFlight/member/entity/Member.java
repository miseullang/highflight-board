package com.study.highFlight.member.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBERS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @Column(name = "member_id", length = 255, nullable = false)
    private String memberId;

    @Column(name = "member_pw", length = 1000, nullable = false)
    private String memberPw;

    @Column(name = "member_mail", length = 255, nullable = false)
    private String memberMail;

    @Column(name = "member_nickname", length = 255, nullable = false)
    private String memberNickName;

    @Column(name = "member_is_delete")
    private Boolean memberIsDelete;

    @Column(name = "member_create", nullable = false)
    private LocalDateTime memberCreate;

    public void changeMemberInfo(String memberMail, String memberNickName) {
        if (memberMail != null) {
            this.memberMail = memberMail;
        }

        if (memberNickName != null) {
            this.memberNickName = memberNickName;
        }
    }

    public void deleteMember() {
        this.memberIsDelete = true;
    }
}
