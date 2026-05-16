package com.study.highFlight.common.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "회원을 찾을 수 없어요"),
    DUPLICATED_MAIL(HttpStatus.BAD_REQUEST, "이메일 중복"),
    OMG_ERROR(HttpStatus.BAD_REQUEST, "내가 무슨 에러인지 모르느냐 하지 마시고"),
    OMG_ERROR_2(HttpStatus.CONFLICT, "이건 무슨 오류지");

    private final HttpStatus status;
    private final String message;
}
