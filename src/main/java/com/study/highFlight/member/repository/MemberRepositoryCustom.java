package com.study.highFlight.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.highFlight.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface MemberRepositoryCustom {
    Optional<Member> selectMemberInfo(Long memberNo);
}
