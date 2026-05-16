package com.study.highFlight.member.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

    @InjectMocks
    private MemberServiceImpl memberService;

    @Test
    void add() {
        // given
        Long a = 2L;
        Long b = 3L;

        // when
        Long c = memberService.add(a,b);

        // then
        assertEquals(c, 5);
    }
}